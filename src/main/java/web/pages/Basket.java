package web.pages;

import domain.Cart.Item_cart;
import domain.Order.CreateOrders;
import domain.User.LoginFacade;
import domain.User.User;
import infrastructure.DBOrder;
import infrastructure.Database;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * CREATED BY mathi @ 29-10-2020 - 19:29
 **/
@WebServlet({"/basket", "/basket/*"})
public class Basket extends Servlet {
    final Database db = new Database();
    final LoginFacade facade = new LoginFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HashMap<Integer, Item_cart> itemCart = new HashMap<>();
        ArrayList<Item_cart> itemCarts = new ArrayList<>();
        itemCart.putAll(getCart(req).getItemCarts());
        for (Map.Entry<Integer, Item_cart> entery : itemCart.entrySet()) {
            itemCarts.add(entery.getValue());
        }
        req.setAttribute("cart", itemCarts);
        req.setAttribute("cupcakesAntal", itemCart.size());
        req.setAttribute("totalSum", getCart(req).getSum());
        System.out.println(itemCart);
        render("basket", "/WEB-INF/pages/basket.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = getUser(req, resp, "log ind for at ændre i din kurv ");
            if (req.getParameter("delteOrderLine") != null) {
                int id = Integer.parseInt(req.getParameter("CartItemId"));
                try {
                    getCart(req).deleteSum(getCart(req).getItemCarts().get(id));
                    getCart(req).getItemCarts().remove(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resp.sendRedirect(req.getContextPath() + "/basket");
            } else if (req.getParameter("CompleteOrder") != null && (getUser(req, resp, "Du skal være logget ind for at kunde foresætte dit køb") != null)) {
                    if (user.getKredit() >= getCart(req).getSum()) {
                        System.out.println(user.getKredit() + " sum:" + getCart(req).getSum());
                        createOrder(req, user);
                        resp.sendRedirect(req.getContextPath() + "/order");
                    } else {
                        HttpSession session = req.getSession();
                        session.setAttribute("basketError", "" + "Du har ikke nok kredit for denne order! kontakt en adminitrator, Din nuværende kredit: ");
                        System.out.println("wallet too empty");
                        resp.sendRedirect(req.getContextPath() + "/basket");
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void createOrder(HttpServletRequest request, User user) throws SQLException {
        String orderID;
        User use = (User) request.getSession().getAttribute("user");
        int orderidPart0 = new Random().nextInt(getCart(request).getItemCarts().size() + 9999);
        int orderidPart1 = getCart(request).getItemCarts().size();
        int orderidPart2 = user.getId();
        orderID = "#" + orderidPart0 + (orderidPart1) + (orderidPart2);
        HttpSession session = request.getSession();
        session.setAttribute("OrderDetailjer", getCart(request).getItemCarts());
        session.setAttribute("OrderNummer", orderID);
        CreateOrders createOrders = new CreateOrders(orderID, getCart(request).getItemCarts());
        DBOrder enterOrder = new DBOrder(db);
        facade.deletekredit(user.getId(), getCart(request).getSum());
        enterOrder.createOrder(orderID, user, createOrders, getCart(request).getSum());
        use.setKredit(facade.refreshKredit(use.getId()));

    }
}


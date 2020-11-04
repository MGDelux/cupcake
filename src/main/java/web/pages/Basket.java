package web.pages;

import domain.Cart.Item_cart;
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
import java.util.ArrayList;
import java.util.Random;

/**
 * CREATED BY mathi @ 29-10-2020 - 19:29
 **/
@WebServlet({"/basket", "/basket/*"})
public class Basket extends Servlet {
    Database db = new Database();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<Item_cart> itemCart = getCart(req).getItemCarts();
        req.setAttribute("cart", itemCart);
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
               Item_cart c = getCart(req).getCartItem(id);

                if (!getCart(req).getItemCarts().removeIf(i -> i.getCartItem() == id)) {
                    System.out.println("error");
                }
                getCart(req).deleteSum(c);
                resp.sendRedirect(req.getContextPath() + "/basket");
            } else if (req.getParameter("CompleteOrder") != null) {
                if (getUser(req, resp, "Du skal være logget ind for at kunde foresætte dit køb") != null) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void createOrder(HttpServletRequest request, User user) throws SQLException {
        DBOrder order = new DBOrder(db);
        String orderID;
        int orderidPart0 = new Random().nextInt(getCart(request).getItemCarts().size() + 1000);
        int orderidPart1 = getCart(request).getItemCarts().size();
        int orderidPart2 = user.getId();
        String useremail = user.getEmail();
        String[] splittop = useremail.split("@");
        orderID = "#" + orderidPart0 + Integer.toString(orderidPart1) + Integer.toString(orderidPart2) + splittop[0];
        HttpSession session = request.getSession();
        session.setAttribute("OrderDetailjer", getCart(request).getItemCarts());
        session.setAttribute("OrderNummer",orderID);
        order.createOrder(orderID, user, getCart(request).getItemCarts(), getCart(request).getSum());
    }
}


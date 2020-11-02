package web.pages;

import com.mysql.cj.Session;
import domain.Cart.Item_cart;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * CREATED BY mathi @ 29-10-2020 - 19:29
 **/
@WebServlet({"/basket", "/basket/*"})
public class Basket extends Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<Item_cart> itemCart = new ArrayList<>();
        try {
            for (Item_cart cart : getCart(req).getCartItems()) {
                itemCart.add(cart);
            }
            req.setAttribute("cart", itemCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("cupcakesAntal", itemCart.size());
        req.setAttribute("totalSum", getCart(req).getSum());
        System.out.println(itemCart);
        render("basket", "/WEB-INF/pages/basket.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("CartItemId"));
        getCart(req).getCartItems().removeIf(i->i.getCartItem()==id);
       Item_cart cart = getCart(req).getCartItems().get(id);
        System.out.println("kart :"+ cart);
       //getCart(req).deleteSum(cart);
        resp.sendRedirect(req.getContextPath() + "/basket");
    }
}


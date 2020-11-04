package web.pages;

import domain.Cart.Item_cart;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

@WebServlet({"/order", "/order/*"})
public class Order extends Servlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(req.getSession().getAttributeNames());
        ArrayList<Item_cart> itemCart = getCart(req).getItemCarts();
        req.setAttribute("cart", itemCart);
        render("Orderpage", "/WEB-INF/pages/order.jsp", req, resp);
        if (!getCart(req).getItemCarts().isEmpty()) {
            getCart(req).getItemCarts().clear();
        }


    }


}

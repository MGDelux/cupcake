package web.pages;

import domain.Cart.Item_cart;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

@WebServlet({"/order", "/order/*"})
public class Order extends Servlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(req.getSession().getAttributeNames());
        HashMap<Integer,Item_cart> itemCart = getCart(req).getItemCarts();
        ArrayList<Item_cart> itemCarts = new ArrayList<>();
        for (Map.Entry<Integer, Item_cart> entery : itemCart.entrySet()) {
            itemCarts.add(entery.getValue());
        }
        req.setAttribute("cart", itemCarts);
        render("Orderpage", "/WEB-INF/pages/order.jsp", req, resp);
        if (!getCart(req).getItemCarts().isEmpty()) {
            getCart(req).getItemCarts().clear();
        }


    }


}

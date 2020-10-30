package web.pages;

import Repository.Cart.CartRepo;
import api.Cart;
import domain.Bottoms.Bottoms;
import Repository.Cupcakes.NoCupcake;
import domain.Toppings.Toppings;
import infrastructure.DBCupcake;
import infrastructure.DBOrders;
import infrastructure.Database;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@WebServlet({"/products", "/products/*"})
public class Products extends Servlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);
        System.out.println(req.getPathInfo());
        ArrayList<Toppings> currentToppings = new ArrayList<>();
        ArrayList<Bottoms> currentButtoms = new ArrayList<>();
        try {
            for (Toppings tops : loadCupcakes().findAllTop()) {
                currentToppings.add(tops);
            }
            for (Bottoms buts : loadCupcakes().findAllBut()) {
                currentButtoms.add(buts);
            }
            req.setAttribute("toppings", currentToppings);
            req.setAttribute("currentButtoms", currentButtoms);
            render("index test", "/WEB-INF/pages/products.jsp", req, resp);
        } catch (NoCupcake cupcake) {
            cupcake.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("sumbitBotsTilKurv") != null) {
            try {
                sumitBotsTilKurv(req,resp);
            } catch (NoCupcake noCupcake) {
                noCupcake.printStackTrace();
            }
        }
        resp.sendRedirect(req.getContextPath() + "/products/");
    }

    private void sumitBotsTilKurv(HttpServletRequest req, HttpServletResponse resp) throws NoCupcake {
        String bots = req.getParameter("BotToKurv");
        String[] split = bots.split(" ");
        System.out.println(0+ "," +split[0]);

return;
    }


    private void sumitTopsTilKurv(HttpServletRequest req, HttpServletResponse resp) throws NoCupcake {
        String top = req.getParameter("TopToKurv");
        String[] split = top.split(" ");
        System.out.println(split[0]);


        return;
    }
}


package web.pages;

import domain.Buttoms;
import Repository.NoCupcake;
import domain.Toppings;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/products", "/products/*"})
public class Products extends Servlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);
        System.out.println(req.getPathInfo());
        ArrayList<Toppings> currentToppings = new ArrayList<>();
        ArrayList<Buttoms> currentButtoms = new ArrayList<>();
        try {
            for (Toppings tops : loadCupcakes().findAllTop()) {
                System.out.println(tops);
                currentToppings.add(tops);
            }
            for (Buttoms buts : loadCupcakes().findAllBut()) {
                System.out.println(buts);
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
        if (req.getParameter("sumbitTopsTilKurv") != null) {
            System.out.println("HELLO");
            sumitTopsTilKurv(req,resp);
        }
        if (req.getParameter("sumbitBotsTilKurv") != null) {
            System.out.println("HELLO2");
            sumitBotsTilKurv(req,resp);
        }
        resp.sendRedirect(req.getContextPath() + "/products/");
    }

    private void sumitBotsTilKurv(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("xd");
        String top = req.getParameter("BotToKurv");
        System.out.println(top);
return;
    }

    private void sumitTopsTilKurv(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("xd");
        String top = req.getParameter("BotToKurv");
        System.out.println(top);
        return;
    }
}


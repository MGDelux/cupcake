package web.pages;

import domain.*;
import infrastructure.DBCupcakeRepository;
import infrastructure.Database;
import web.Servlet;
import api.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/AdminPage", "/AdminPage/*"})
public class AdminPage extends Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LoginFacade loginFacade = new LoginFacade();
        ArrayList<Toppings> toppings = new ArrayList<>();
        ArrayList<Buttoms> buttoms = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        setUp(req, resp);
        cupcake cupcake = loadCupcakes();
        try {
            for (Toppings tops : cupcake.findAllTop()) {
                System.out.println(tops);
                toppings.add(tops);
            }
            for (Buttoms buts : cupcake.findAllBut()) {
                System.out.println(buts);
                buttoms.add(buts);
            }
            for (User u : loginFacade.getAllUsers()) {
                users.add(u);
            }

            req.setAttribute("buttoms", buttoms);
            req.setAttribute("toppings", toppings);
            req.setAttribute("cupcakes", cupcake);
            req.setAttribute("users", users);
        } catch (NoCupcake noCupcake) {
            noCupcake.printStackTrace();
        }
        log(req, "admin page");
        render("admin page", "/WEB-INF/pages/AdminPage.jsp", req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String nytop = req.getParameter("topping");
        String nypris = req.getParameter("toppingPris");
        try {
            cupcake cupcake = loadCupcakes();
            double nyprisCheck = Double.parseDouble(nypris);
            cupcake.createTopsList(nytop, nyprisCheck);
        } catch (NumberFormatException e) {
           req.setAttribute("error", e.getMessage());
            System.out.println("error"+ e.getMessage());
           doGet(req,resp);
           return;
        }
    }
}

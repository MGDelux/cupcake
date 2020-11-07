package web.pages;

import domain.Bottoms.Bottoms;
import Repository.Cupcakes.NoCupcake;
import domain.Toppings.Toppings;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet({"/products", "/products/*"})
public class Products extends Servlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);
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
        } catch (NoCupcake | SQLException cupcake) {
            cupcake.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("AddCupcakeToKurv") != null) {
            addCupCake(req, resp);

        }
        if (req.getParameter("logger") != null) {
            logout(req, resp);

        }
    }

    private void submitToCart(HttpServletRequest req, HttpServletResponse resp) throws NoCupcake, SQLException { //refactor
        String top = req.getParameter("TopToKurv");
        String[] splittop = top.split(",");
        String bots = req.getParameter("BotToKurv");
        String[] splitbot = bots.split(",");
        getCart(req).addItemIntoCart(splittop[0], splitbot[0]);
    }

    private void addCupCake(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("AddCupcakeToKurv") != null) {
            try {
                submitToCart(req, resp);
            } catch (NoCupcake | SQLException noCupcake) {
                noCupcake.printStackTrace();
            }
        }
        resp.sendRedirect(req.getContextPath() + "/products/");
    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (getUser(req, resp, "Logged ud. ") != null) {
                HttpSession session = req.getSession();
                session.invalidate();
                resp.sendRedirect(req.getContextPath() + "/");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



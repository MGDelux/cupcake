package web.pages;

import domain.Buttoms;
import domain.NoCupcake;
import domain.Toppings;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("")
public class Index extends Servlet {
    private static ArrayList<Toppings> currentToppings = new ArrayList<>();
    private static ArrayList<Buttoms> currentButtoms = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(req.getPathInfo());
        setUp(req, resp);
        if (req.getPathInfo().equals("/")) {
            render("index test", "/WEB-INF/pages/index.jsp", req, resp);
            log("load index");
        } else {
            try {
                log("loading cakes");
                Iterable<Toppings> tops = api.findAllTop();
                for (Toppings toppings : tops) {
                    currentToppings.add(toppings);
                    Iterable<Buttoms> buttoms = api.findAllBut();
                    for (Buttoms buttoms1 : buttoms) {
                        currentButtoms.add(buttoms1);
                    }
                    req.setAttribute("tops", currentToppings);
                    req.setAttribute("but", currentButtoms);
                }
            } catch (NoCupcake noCupcake) {
                resp.sendError(500, "ERROR IN GETTING CUPCAKES");
                log("error loading cakes");
            }
        }
    }
}

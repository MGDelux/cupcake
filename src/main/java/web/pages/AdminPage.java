package web.pages;

import Repository.User.LoginError;
import Repository.Cupcakes.NoCupcake;
import domain.Bottoms.Bottoms;
import domain.Toppings.Toppings;
import domain.User.LoginFacade;
import domain.User.User;
import web.Servlet;
import api.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet({"/AdminPage", "/AdminPage/*"})
public class AdminPage extends Servlet {
LoginFacade loginFacade = new LoginFacade();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (getUser(req, resp, "need to be logged in") != null) {
            if (getUser(req, resp, "admin error").getRole().equals("admin")) {
                LoginFacade loginFacade = new LoginFacade();
                ArrayList<Toppings> toppings = new ArrayList<>();
                ArrayList<Bottoms> buttoms = new ArrayList<>();
                ArrayList<User> users = new ArrayList<>();
                setUp(req, resp);
                try {
                    for (Toppings tops : loadCupcakes().findAllTop()) {
                        toppings.add(tops);
                    }
                    for (Bottoms buts : loadCupcakes().findAllBut()) {
                        buttoms.add(buts);
                    }
                    for (User u : loginFacade.getAllUsers()) {
                        users.add(u);
                    }
                    req.setAttribute("buttoms", buttoms);
                    req.setAttribute("toppings", toppings);
                    req.setAttribute("cupcakes", loadCupcakes());
                    req.setAttribute("users", users);

                    log(req, "admin page");
                    render("admin page", "/WEB-INF/pages/AdminPage.jsp", req, resp);

                } catch (NoCupcake noCupcake) {
                    resp.sendError(500, noCupcake.getMessage());
                    System.out.println(noCupcake.getMessage());
                } catch (LoginError loginError) {
                    resp.sendError(500, loginError.getMessage());
                    System.out.println(loginError.getMessage());
                } catch (SQLException throwables) {
                    resp.sendError(500, throwables.getMessage());
                    System.out.println(throwables.getMessage());
                }
            }else {
                HttpSession session = req.getSession();
                resp.sendRedirect(req.getContextPath()+"/login/");
                session.setAttribute("loggedIn","ADMIN ONLY PAGE PLEASE SIGN IN AS ADMIN");

            }
        }
    }
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("post");
        if (req.getParameter("removetoppingidbutton") != null) {
            removeTopping(req);
        }
        if (req.getParameter("addtoppingbutton") != null) {
            addTopping(req, resp);
        }
        if (req.getParameter("add-button") != null) {
            addButtom(req, resp);
        }
        if (req.getParameter("removeBut") != null) {
            System.out.println("remove buttom");
            removeButtom(req);
        }
        if (req.getParameter("createNewUser") != null) {
            System.out.println("create user");
            createUser(req);
        }
        if (req.getParameter("addKredit") != null) {
            addkredit(req);
        }
        if (req.getParameter("deleteUser") != null) {
            String kundeId = req.getParameter("kunderIDToDelete");
            try {
                System.out.println("delete user >" + kundeId);
                loginFacade.deleteUser(kundeId);
            } catch (LoginError loginError) {
                loginError.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        resp.sendRedirect(req.getContextPath() + "/AdminPage");
    }

    private void addkredit(HttpServletRequest request) {
        String kundeId = request.getParameter("kunderID");
        String kundeKredit = request.getParameter("KreditToAdd");
        try {
            int parseID = Integer.parseInt(kundeId);
            double parseKredit = Double.parseDouble(kundeKredit);
            loginFacade.addKredit(parseID, parseKredit);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (LoginError loginError) {
            loginError.printStackTrace();
        }

    }

    private void createUser(HttpServletRequest req) {
        String email = req.getParameter("kunderEmail");
        String role = req.getParameter("kundeRole");
        String password = req.getParameter("kunderPassword");
        String kundeKredit = req.getParameter("kunderKredt");
        try {
            double parseInt = Double.parseDouble(kundeKredit);
            loginFacade.createUser(email, password, role, parseInt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (LoginError loginError) {
            loginError.printStackTrace();
        }
    }


    protected void addTopping(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nytop = req.getParameter("topping");
        String nypris = req.getParameter("toppingPris");
        try {
            Cupcake cupcake = loadCupcakes();
            double nyprisCheck = Double.parseDouble(nypris);
            cupcake.createTopsList(nytop, nyprisCheck);
        } catch (NumberFormatException e) {
            req.setAttribute("error", e.getMessage());
            System.out.println("error" + e.getMessage());
            doGet(req, resp);
            return;
        }

    }

    protected void addButtom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nytop = req.getParameter("buttomName");
        String nypris = req.getParameter("buttomPris");
        try {
            Cupcake cupcake = loadCupcakes();
            double nyprisCheck = Double.parseDouble(nypris);
            cupcake.createButtomsList(nytop, nyprisCheck);
        } catch (NumberFormatException e) {
            req.setAttribute("error", e.getMessage());
            System.out.println("error" + e.getMessage());
            doGet(req, resp);
            return;
        }

    }

    protected void removeTopping(HttpServletRequest req) {
        String nytop = req.getParameter("removeToppingid");
        int parseInt = Integer.parseInt(nytop);
        try {
            Cupcake cupcake = loadCupcakes();
            cupcake.removeTopping(parseInt);
        } catch (NoCupcake noCupcake) {
            noCupcake.printStackTrace();
        }
    }

    protected void removeButtom(HttpServletRequest req) {
        String nytop = req.getParameter("removeButId");
        System.out.println("remvoe " + nytop);
        int parseInt = Integer.parseInt(nytop);
        try {


            Cupcake cupcake = loadCupcakes();
            cupcake.removeButtom(parseInt);
        } catch (NoCupcake noCupcake) {
            noCupcake.printStackTrace();
        }
    }
}

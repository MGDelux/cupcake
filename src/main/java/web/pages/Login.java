package web.pages;

import domain.LoginError;
import domain.LoginFacade;
import domain.User;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends Servlet {
    public static String email;
    private LoginFacade loginFacade = new LoginFacade();
    private User user;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);
        email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            user = loginFacade.login(email, password);
            HttpSession session = req.getSession();
            PrintWriter out = resp.getWriter();
            out.println("log test");
            log("login test");
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", user.getEmail());
        } catch (LoginError loginError) {
            loginError.printStackTrace();
        }


    }
}

package web.pages;

import domain.User.LoginFacade;
import domain.User.User;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/PasswordRecovery", "/PasswordRecovery/*"})
public class PasswordRecovery extends Servlet {
    private  String email;
    private  String password;
    private LoginFacade loginFacade = new LoginFacade();
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req, resp);
        log(req, "Recovery page");
        render("Recovery page", "/WEB-INF/pages/lostpassword.jsp", req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        email = req.getParameter("email");
        password = req.getParameter("password");

    }
}

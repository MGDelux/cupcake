package web.pages;

import Repository.User.LoginError;
import domain.User.LoginFacade;
import domain.User.User;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet({"/register", "/register/*"})
public class Register extends Servlet {
    private final LoginFacade loginFacade = new LoginFacade();
    User user;

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req,resp);
        log(req,"register page");
        render("register page","/WEB-INF/pages/register.jsp",req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String  email = req.getParameter("email1");
        String password = req.getParameter("password1");
        try {
            user = loginFacade.createUser(email,password,"customer",0);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"");
            log(req,"New user registered "+ user.getEmail());
            return;
        } catch (LoginError | SQLException e) {
            req.setAttribute("error", e.getMessage());
            System.out.println("error "+ e.getMessage());
            doGet(req,resp);
            return;
        }

    }
}
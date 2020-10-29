package web.pages;

import Repository.LoginError;
import domain.LoginFacade;
import domain.User;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet({"/register", "/register/*"})
public class Register extends Servlet {
    private String email;
    private String password;
    private String password1;
    private LoginFacade loginFacade = new LoginFacade();
    private User user;

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req,resp);
        log(req,"register page");
        render("register page","/WEB-INF/pages/register.jsp",req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        email = req.getParameter("email1");
        password = req.getParameter("password1");
        password1 = req.getParameter("password2"); //redudant
        try {
            user = loginFacade.createUser(email,password,"customer",0);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"");
            log(req,"New user registered "+ user.getEmail());
            return;
        } catch (LoginError | SQLException loginError) {
            req.setAttribute("error", loginError.getMessage());
            System.out.println("error "+ loginError.getMessage());
            doGet(req,resp);
            return;
        }

    }
}
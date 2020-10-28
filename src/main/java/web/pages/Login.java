package web.pages;

import domain.LoginError;
import domain.LoginFacade;
import domain.User;
import web.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet({"/login", "/login/*"})
public class Login extends Servlet {
    private  String email;
    private  String password;
    private LoginFacade loginFacade = new LoginFacade();
    private User user;

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req,resp);
        log(req,"Login page");
        render("login page","/WEB-INF/pages/login.jsp",req,resp);
    }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws IOException, ServletException {
      email = req.getParameter("email");
      password = req.getParameter("password");
      try {
          user = loginFacade.login(email, password);
          req.getSession().setAttribute("user",user);
          resp.sendRedirect(req.getContextPath()+"");
          return;
      } catch (LoginError loginError) {
          req.setAttribute("error", loginError.getMessage());
          System.out.println("error "+ loginError.getMessage());
          doGet(req,resp);
          return;
      }
  }
}

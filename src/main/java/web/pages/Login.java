package web.pages;

import domain.LoginError;
import domain.LoginFacade;
import domain.User;
import web.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet({"/login", "/login/*"})
public class Login extends Servlet {
    private  String email;
    private  String password;
    private LoginFacade loginFacade = new LoginFacade();
    private User user;

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException, IOException {
        log(req,"Login page");
        setUp(req,resp);
        render("login page","/WEB-INF/pages/login.jsp",req,resp);
    }
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
      email = req.getParameter("email");
      password = req.getParameter("password");
      try {
          user = loginFacade.login(email, password);
          HttpSession session = req.getSession();
          PrintWriter out = resp.getWriter();
          out.println("log test");
          session.setAttribute("user", user);
          session.setAttribute("role", user.getRole());
          session.setAttribute("email", user.getEmail());
          if (session.getAttribute("role").equals("customer")) {
              render("C logged in", "WEB-INF/pages/index.jsp", req, resp);
          } else {
              render("A logged in","WEB-INF/pages/index.jsp", req, resp);

          }


      } catch (LoginError loginError) {
          req.setAttribute("error", loginError.getMessage());
          render("error in login", "WEB-INF/pages/login.jsp", req, resp);
      }

  }
}

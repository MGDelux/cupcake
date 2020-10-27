package web.pages;

import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/order", "/order/*"})
public class Order extends Servlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setUp(req,resp);
        render("Orderpage", "/WEB-INF/pages/order.jsp", req, resp);
    }

}

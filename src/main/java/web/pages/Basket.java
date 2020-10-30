package web.pages;

import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathi @ 29-10-2020 - 19:29
 **/
@WebServlet({"/basket", "/basket/*"})
public class Basket extends Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Servlet.loadCupcakes();
        render("basket", "/WEB-INF/pages/basket.jsp", req, resp);
    }
}


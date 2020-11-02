package web.pages;

import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CREATED BY mathi @ 28-10-2020 - 21:35
 **/
@WebServlet("")
public class index extends Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        render("index+", "/WEB-INF/pages/index.jsp", req, resp);
    }
}

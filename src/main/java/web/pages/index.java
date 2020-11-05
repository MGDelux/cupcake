package web.pages;

import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (getUser(req, resp, "Logged ud. ") != null) {
                HttpSession session = req.getSession();
                session.invalidate();
                resp.sendRedirect(req.getContextPath() + "");

            } else {
               // resp.sendRedirect(req.getContextPath() + "/login");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

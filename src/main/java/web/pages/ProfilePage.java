package web.pages;

import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * CREATED BY mathi @ 29-10-2020 - 19:29
 **/
@WebServlet({"/profilepage", "/profilepage/*"})
public class ProfilePage extends Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(getUser(req,resp,"Log ind for at se din profil! ")!=null) {
            render("profilepage", "/WEB-INF/pages/ProfilePage.jsp", req, resp);
        }

    }
}

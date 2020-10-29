package web;

import api.cupcake;
import infrastructure.DBCupcake;
import infrastructure.Database;
import web.widget.IndexNav;
import web.widget.Navbar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class Servlet extends HttpServlet {
    protected static final cupcake api;

    static {
        api = loadCupcakes();
    }

    public static cupcake loadCupcakes() {
        Database db = new Database();
        return new cupcake(new DBCupcake(db), new DBCupcake(db));

    }

    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
    }

    protected void render(String title, String content, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("indexNavbar",new IndexNav(req));
        req.setAttribute("navbar",new Navbar(req));
        req.setAttribute("version", cupcake.getVer());
        req.setAttribute("title", title);
        req.setAttribute("content", content);
        req.getRequestDispatcher(content).forward(req, resp);
        log(req, "loaded");


    }

    protected void log(HttpServletRequest req, String message) {
        System.err.println("(" + LocalDateTime.now() + ") " + this.getClass().getCanonicalName() + " \"" + req.getRequestURI() + "\": " + message);
    }
}

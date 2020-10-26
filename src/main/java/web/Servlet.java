package web;

import api.cupcake;
import infrastructure.DBCupcakeRepository;
import infrastructure.Database;

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

  private static cupcake loadCupcakes() {
        Database db = new Database();
        return new cupcake(new DBCupcakeRepository(db),new DBCupcakeRepository(db));
    }

    protected void setUp(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("UTF-8");
    }
    protected void render(String title, String content, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("version", cupcake.getVer());
        req.setAttribute("title", title);
        req.setAttribute("content", content);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
    protected void log(HttpServletRequest req, String message) {
        System.err.println("(" + LocalDateTime.now() + ") " + this.getClass().getCanonicalName() + " \"" + req.getRequestURI() + "\": " + message);
    }
}

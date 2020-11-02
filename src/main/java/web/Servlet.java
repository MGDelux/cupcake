package web;

import api.Cart;
import api.Cupcake;
import infrastructure.DBCupcake;
import infrastructure.Database;
import web.widget.IndexNav;
import web.widget.Navbar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class Servlet extends HttpServlet {
    protected static final Cupcake cupcakeApi;

    static {
        cupcakeApi = loadCupcakes();
    }

    protected static Cart getCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null) {
            cart = new Cart(cupcakeApi);
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public static Cupcake loadCupcakes() {
        Database db = new Database();
        return new Cupcake(new DBCupcake(db), new DBCupcake(db));

    }

    protected void setUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
    }

    protected void render(String title, String content, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("indexNavbar", new IndexNav(req));
        req.setAttribute("navbar", new Navbar(req));
        req.setAttribute("version", Cupcake.getVer());
        req.setAttribute("title", title);
        req.setAttribute("content", content);
        req.getRequestDispatcher(content).forward(req, resp);
        log(req, "loaded");


    }

    protected void log(HttpServletRequest req, String message) {
        System.err.println("(" + LocalDateTime.now() + ") " + this.getClass().getCanonicalName() + " \"" + req.getRequestURI() + "\": " + message);
    }
}

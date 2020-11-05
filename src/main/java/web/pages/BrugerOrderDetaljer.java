package web.pages;

import domain.Order.GetOrderContent;
import infrastructure.DBOrder;
import infrastructure.Database;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * CREATED BY mathi @ 05-11-2020 - 12:31
 **/
@WebServlet({"/orderDetails", "/orderDetails/*"})
public class BrugerOrderDetaljer extends Servlet {
    ArrayList<GetOrderContent> orderContent = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses  = req.getSession();

        Database db = new Database();
        DBOrder dbo = new DBOrder(db);
        orderContent =  dbo.getOrderContent(ses.getAttribute("UserOrderDetailId").toString());
        req.setAttribute("orderContent",orderContent);
        render("kek", "/WEB-INF/pages/orderDetails.jsp", req, resp);
    }
}

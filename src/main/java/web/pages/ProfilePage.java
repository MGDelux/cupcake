package web.pages;

import domain.Order.CreateOrders;
import domain.Order.GetOrders;
import infrastructure.DBOrder;
import infrastructure.Database;
import web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathi @ 29-10-2020 - 19:29
 **/
@WebServlet({"/profilepage", "/profilepage/*"})
public class ProfilePage extends Servlet {
    String id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<GetOrders> userOrders = new ArrayList<>();
        if(getUser(req,resp,"Log ind for at se din profil! ")!=null) {
            Database db = new Database();
            DBOrder dbo = new DBOrder(db);
            try {
                List<String> x = dbo.getuserOrdersId(getUser(req,resp,"error in getting user infomation").getId());
                for (String s:x){
                    userOrders.add(dbo.loadUserOrders(s));
                }
                req.setAttribute("Order",userOrders);
                System.out.println(userOrders);
                System.out.println(x.toString());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            render("profilepage", "/WEB-INF/pages/ProfilePage.jsp", req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("idStuff") != null) {
            userOrderDetail(req, resp);

        }
        if (req.getParameter("logger") != null) {
            logout(req, resp);

        }
    }


   private void userOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       HttpSession ses  = req.getSession();

       id = req.getParameter("idStuff").toString();
       ses.setAttribute("UserOrderDetailId", id);
       resp.sendRedirect(req.getContextPath() + "/orderDetails/");
   }

    private void logout(HttpServletRequest req, HttpServletResponse resp){
        try {
            if (getUser(req, resp, "Logged ud. ") != null) {
                HttpSession session = req.getSession();
                session.invalidate();
                resp.sendRedirect(req.getContextPath() + "/");
            } else {
                // resp.sendRedirect(req.getContextPath() + "/login");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


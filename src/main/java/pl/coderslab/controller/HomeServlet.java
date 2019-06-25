package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int homeNumberOfOrders = Integer.parseInt(getServletContext().getInitParameter("homeNumberOfOrders"));

        OrderDao orderDao = new OrderDao();
        Order[] orders = orderDao.findNumberOf(homeNumberOfOrders);

        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request,response);
    }
}

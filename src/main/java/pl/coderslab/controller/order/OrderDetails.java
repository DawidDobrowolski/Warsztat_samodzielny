package pl.coderslab.controller.order;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/details")
public class OrderDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));

        OrderDao orderDao = new OrderDao();
        Order order = orderDao.read(orderId);


        request.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/views/order/orderDetails.jsp")
                .forward(request,response);
    }
}

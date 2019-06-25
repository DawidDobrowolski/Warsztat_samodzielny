package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees/orders")
public class EmployeesShowOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("id"));

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.read(employeeId);

        OrderDao orderDao = new OrderDao();
        Order[] employeeOrders = orderDao.findAllByEmployeeID(employeeId);

        request.setAttribute("employee", employee);
        request.setAttribute("employeeOrders", employeeOrders);
        getServletContext().getRequestDispatcher("/employeesOrders.jsp")
                .forward(request,response);
    }
}

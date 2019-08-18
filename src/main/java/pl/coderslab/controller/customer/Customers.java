package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customers")
public class Customers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDao();
        Customer[] customers = customerDao.findAll();

        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/views/customer/customers.jsp")
                .forward(request,response);
    }
}

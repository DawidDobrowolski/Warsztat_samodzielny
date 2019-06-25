package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/customers/update")
public class CustomersUpdate extends HttpServlet {
    Customer customer;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        customer.setName(request.getParameter("name"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setBirthdayDate(Date.valueOf(request.getParameter("birthdayDate")));

        CustomerDao customerDao = new CustomerDao();
        customerDao.update(customer);

        response.sendRedirect("/customers");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("id"));

        CustomerDao customerDao = new CustomerDao();
        customer = customerDao.read(customerId);

        request.setAttribute("customer", customer);
        getServletContext().getRequestDispatcher("/customersUpdate.jsp")
                .forward(request,response);
    }
}

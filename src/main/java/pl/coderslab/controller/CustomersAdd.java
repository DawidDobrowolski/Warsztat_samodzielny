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

@WebServlet("/customers/add")
public class CustomersAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setBirthdayDate(Date.valueOf(request.getParameter("birthdayDate")));

        CustomerDao customerDao = new CustomerDao();
        customerDao.create(customer);

        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/customersAdd.jsp");

    }
}

package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicles")
public class Vehicles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("id"));

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.read(customerId);

        VehicleDao vehicleDao = new VehicleDao();
        Vehicle[] vehicles = vehicleDao.findAllByCustomerID(customerId);

        request.setAttribute("vehicles", vehicles);
        request.setAttribute("customer", customer);
        getServletContext().getRequestDispatcher("/vehicles.jsp")
                .forward(request, response);
    }
}

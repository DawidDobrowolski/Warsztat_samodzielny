package pl.coderslab.controller.vehicle;

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
import java.sql.Date;

@WebServlet("/vehicles/add")
public class VehiclesAdd extends HttpServlet {

    int customerId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Vehicle vehicle = new Vehicle();
        vehicle.setModel(request.getParameter("model"));
        vehicle.setBrand(request.getParameter("brand"));
        vehicle.setProductionYear(Integer.parseInt(request.getParameter("productionYear")));
        vehicle.setPlateNumber(request.getParameter("plateNumber"));
        vehicle.setNextCheckDay(Date.valueOf(request.getParameter("nextCheckDay")));

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.read(customerId);
        vehicle.setCustomer(customer);

        VehicleDao vehicleDao = new VehicleDao();
        vehicleDao.create(vehicle);

        response.sendRedirect("/vehicles?id=" + customerId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerId = Integer.parseInt(request.getParameter("id"));
        response.sendRedirect("/views/vehicle/vehiclesAdd.jsp");

    }
}

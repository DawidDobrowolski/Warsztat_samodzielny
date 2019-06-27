package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/order/add")
public class OrderAdd extends HttpServlet {

    Employee[] employees;
    Vehicle[] vehicles;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();

        order.setEntranceDate(Date.valueOf(request.getParameter("entranceDate")));
        order.setPlanStartDate(Date.valueOf(request.getParameter("planStartDate")));
        order.setStartDate(Date.valueOf(request.getParameter("startDate")));

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.read(Integer.parseInt(request.getParameter("employee")));
        order.setEmployee(employee);

        order.setProblemDescription(request.getParameter("problemDescription"));
        order.setRepairDescription(request.getParameter("repairDescription"));

        Status status = new Status(0);
        StatusDao statusDao = new StatusDao();
        statusDao.create(status);
        order.setStatus(status);

        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.read(Integer.parseInt(request.getParameter("vehicle")));
        order.setVehicle(vehicle);

        order.setRepairCost(Double.parseDouble(request.getParameter("repairCost")));
        order.setPartsCost(Double.parseDouble(request.getParameter("partsCost")));
        order.setHoursNumber(Integer.parseInt(request.getParameter("hoursNumber")));
        order.setCostPerHour(employee.getCostPerHour());
        order.setRepairCost(order.getPartsCost() + (order.getHoursNumber()*order.getCostPerHour()));


        OrderDao orderDao = new OrderDao();
        orderDao.create(order);

        response.sendRedirect("/");

    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        employees = employeeDao.findAll();

        VehicleDao vehicleDao = new VehicleDao();
        vehicles = vehicleDao.findAll();

        request.setAttribute("employees", employees);
        request.setAttribute("vehicles", vehicles);
        getServletContext().getRequestDispatcher("/orderAdd.jsp")
                .forward(request,response);
    }
}

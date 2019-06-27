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

@WebServlet("/order/update")
public class OrderUpdate extends HttpServlet {
    Order order;
    Employee[] employees;
    Vehicle[] vehicles;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        order.setEntranceDate(Date.valueOf(request.getParameter("entranceDate")));
        order.setPlanStartDate(Date.valueOf(request.getParameter("planStartDate")));
        order.setStartDate(Date.valueOf(request.getParameter("startDate")));

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.read(Integer.parseInt(request.getParameter("employee")));
        order.setEmployee(employee);

        order.setProblemDescription(request.getParameter("problemDescription"));
        order.setRepairDescription(request.getParameter("repairDescription"));

        StatusDao statusDao = new StatusDao();
        Status status = statusDao.read(order.getStatus().getId());
        status.setStatusCode(Integer.parseInt(request.getParameter("status")));
        statusDao.update(status);

        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.read(Integer.parseInt(request.getParameter("vehicle")));
        order.setVehicle(vehicle);

        order.setRepairCost(Double.parseDouble(request.getParameter("repairCost")));
        order.setPartsCost(Double.parseDouble(request.getParameter("partsCost")));
        order.setHoursNumber(Integer.parseInt(request.getParameter("hoursNumber")));
        order.setCostPerHour(employee.getCostPerHour());
        order.setRepairCost(order.getPartsCost() + (order.getHoursNumber()*order.getCostPerHour()));


        OrderDao orderDao = new OrderDao();
        orderDao.update(order);

        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));

        OrderDao orderDao = new OrderDao();
        order = orderDao.read(orderId);

        EmployeeDao employeeDao = new EmployeeDao();
        employees = employeeDao.findAll();

        VehicleDao vehicleDao = new VehicleDao();
        vehicles = vehicleDao.findAll();

        request.setAttribute("order", order);
        request.setAttribute("employees", employees);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("statuses", order.getStatus().getStatusNames());
        getServletContext().getRequestDispatcher("/orderUpdate.jsp")
                .forward(request,response);
    }
}

package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees/add")
public class EmployeesAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setLastName(request.getParameter("lastName"));
        employee.setAddress(request.getParameter("address"));
        employee.setPhone(Integer.parseInt(request.getParameter("phone")));
        employee.setNote(request.getParameter("note"));
        employee.setCostPerHour(Double.parseDouble(request.getParameter("costPerHour")));

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.create(employee);

        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/employeesAdd.jsp");

    }
}

package pl.coderslab.controller.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees/update")
public class EmployeesUpdate extends HttpServlet {
    Employee employee;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employee.setName(request.getParameter("name"));
        employee.setLastName(request.getParameter("lastName"));
        employee.setAddress(request.getParameter("address"));
        employee.setPhone(Integer.parseInt(request.getParameter("phone")));
        employee.setNote(request.getParameter("note"));
        employee.setCostPerHour(Double.parseDouble(request.getParameter("costPerHour")));

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.update(employee);

        response.sendRedirect("/employees");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("id"));

        EmployeeDao employeeDao = new EmployeeDao();
        employee = employeeDao.read(employeeId);

        request.setAttribute("employee", employee);
        getServletContext().getRequestDispatcher("/views/employee/employeesUpdate.jsp")
                .forward(request, response);
    }
}

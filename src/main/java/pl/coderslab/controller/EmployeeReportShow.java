package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.ReportDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.EmployeeReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/employeeReport")
public class EmployeeReportShow extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));

        ReportDao reportDao = new ReportDao();
        EmployeeReport[] employeeReports = reportDao.findAllInDateByEmployeeID(startDate,endDate);

        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("employeeReports", employeeReports);
        getServletContext().getRequestDispatcher("/employeeReportShow.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee[] employees = employeeDao.findAll();


        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/employeeReport.jsp")
                .forward(request, response);
    }
}

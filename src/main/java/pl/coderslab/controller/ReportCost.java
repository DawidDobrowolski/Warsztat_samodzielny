package pl.coderslab.controller;

import pl.coderslab.dao.ReportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/costReport")
public class ReportCost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));

        ReportDao reportDao = new ReportDao();
        double[] costs = reportDao.findOrderCosts(startDate,endDate);
        double repairCost = costs[0];
        double partsCost = costs[1];
        double hoursNumber = costs[2];
        double employeeCost = costs[3];
        double profit = repairCost - employeeCost - partsCost;
        double totalCost = employeeCost + partsCost;
        double margin = Math.floor(profit/repairCost*10000)/100;

        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("repairCost", repairCost);
        request.setAttribute("partsCost", partsCost);
        request.setAttribute("hoursNumber", hoursNumber);
        request.setAttribute("employeeCost", employeeCost);
        request.setAttribute("profit", profit);
        request.setAttribute("totalCost", totalCost);
        request.setAttribute("margin", margin);
        getServletContext().getRequestDispatcher("/costReportShow.jsp")
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/costReport.jsp");

    }
}

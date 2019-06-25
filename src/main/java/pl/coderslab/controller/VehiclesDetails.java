package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicles/details")
public class VehiclesDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(request.getParameter("id"));

        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.read(vehicleId);

        request.setAttribute("vehicle", vehicle);
        getServletContext().getRequestDispatcher("/vehiclesDetails.jsp")
                .forward(request,response);
    }
}

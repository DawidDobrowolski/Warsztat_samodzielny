package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicles/delete")
public class VehiclesDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(request.getParameter("id"));
        int customerId = Integer.parseInt(request.getParameter("idCus"));


        VehicleDao vehicleDao = new VehicleDao();
        vehicleDao.delete(vehicleId);
        response.sendRedirect("/vehicles?id=" + customerId);
    }
}

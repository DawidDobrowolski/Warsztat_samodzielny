package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/vehicles/update")
public class VehiclesUpdate extends HttpServlet {

    Vehicle vehicle;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        vehicle.setModel(request.getParameter("model"));
        vehicle.setBrand(request.getParameter("brand"));
        vehicle.setProductionYear(Integer.parseInt(request.getParameter("productionYear")));
        vehicle.setPlateNumber(request.getParameter("plateNumber"));
        vehicle.setNextCheckDay(Date.valueOf(request.getParameter("nextCheckDay")));

        VehicleDao vehicleDao = new VehicleDao();
        vehicleDao.update(vehicle);

        response.sendRedirect("/vehicles?id=" + vehicle.getCustomer().getId());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(request.getParameter("id"));

        VehicleDao vehicleDao = new VehicleDao();
        vehicle = vehicleDao.read(vehicleId);

        request.setAttribute("vehicle", vehicle);
        getServletContext().getRequestDispatcher("/views/vehicle/vehiclesUpdate.jsp")
                .forward(request,response);
    }
}

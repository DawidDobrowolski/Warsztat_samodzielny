package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import java.sql.*;
import java.util.Arrays;

public class VehicleDao {

    private static final String CREATE_VEHICLE_QUERY =
            "INSERT INTO vehicle(model, brand, productionYear, plateNumber, nextCheckDay, customerId) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String READ_VEHICLE_QUERY =
            "SELECT * FROM vehicle where id = ?";
    private static final String UPDATE_VEHICLE_QUERY =
            "UPDATE vehicle SET model=?, brand=?, productionYear=?, plateNumber=?, nextCheckDay=?, customerId=? where id = ?";
    private static final String DELETE_VEHICLE_QUERY =
            "DELETE FROM vehicle WHERE id = ?";
    private static final String FIND_ALL_VEHICLE_QUERY =
            "SELECT * FROM vehicle";
    private static final String FIND_ALL_VEHICLE_BY_CUSTOMER_ID_QUERY =
            "SELECT * FROM vehicle WHERE customerId = ?";


    public Vehicle create(Vehicle vehicle) {

        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat =
                    connect.prepareStatement(CREATE_VEHICLE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStat.setString(1, vehicle.getModel());
            preStat.setString(2, vehicle.getBrand());
            preStat.setInt(3, vehicle.getProductionYear());
            preStat.setString(4, vehicle.getPlateNumber());
            preStat.setDate(5, vehicle.getNextCheckDay());
            preStat.setInt(6, vehicle.getCustomer().getId());
            preStat.executeUpdate();
            ResultSet resultSet = preStat.getGeneratedKeys();
            if (resultSet.next()) {
                vehicle.setId(resultSet.getInt(1));
            }
            return vehicle;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Vehicle read(int vehicleId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(READ_VEHICLE_QUERY);
            preStat.setInt(1, vehicleId);
            ResultSet resultSet = preStat.executeQuery();
            if (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setProductionYear(resultSet.getInt("productionYear"));
                vehicle.setPlateNumber(resultSet.getString("plateNumber"));
                vehicle.setNextCheckDay(resultSet.getDate("nextCheckDay"));

                CustomerDao customerDao = new CustomerDao();
                int customerId = resultSet.getInt("customerId");
                Customer customer = customerDao.read(customerId);
                vehicle.setCustomer(customer);

                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void update(Vehicle vehicle) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(UPDATE_VEHICLE_QUERY);
            preStat.setString(1, vehicle.getModel());
            preStat.setString(2, vehicle.getBrand());
            preStat.setInt(3, vehicle.getProductionYear());
            preStat.setString(4, vehicle.getPlateNumber());
            preStat.setDate(5, vehicle.getNextCheckDay());
            preStat.setInt(6, vehicle.getCustomer().getId());
            preStat.setInt(7, vehicle.getId());
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int vehicleId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(DELETE_VEHICLE_QUERY);
            preStat.setInt(1, vehicleId);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vehicle[] findAll() {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_VEHICLE_QUERY);
            Vehicle[] vehicles = findAllgetInf(preStat);
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Vehicle[] findAllByCustomerID(int customerID) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_VEHICLE_BY_CUSTOMER_ID_QUERY);
            preStat.setInt(1, customerID);
            Vehicle[] vehicles = findAllgetInf(preStat);
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private Vehicle[] findAllgetInf (PreparedStatement preStat){
        Vehicle[] vehicles = new Vehicle[0];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setProductionYear(resultSet.getInt("productionYear"));
                vehicle.setPlateNumber(resultSet.getString("plateNumber"));
                vehicle.setNextCheckDay(resultSet.getDate("nextCheckDay"));

                CustomerDao customerDao = new CustomerDao();
                int customerId = resultSet.getInt("customerId");
                Customer customer = customerDao.read(customerId);
                vehicle.setCustomer(customer);

                vehicles = addToArray(vehicle, vehicles);
            }
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Vehicle[] addToArray(Vehicle v, Vehicle[] vehicles) {
        Vehicle[] tmpVehicles = Arrays.copyOf(vehicles, vehicles.length + 1);
        tmpVehicles[vehicles.length] = v;
        return tmpVehicles;
    }


}

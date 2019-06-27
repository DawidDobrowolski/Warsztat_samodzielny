package pl.coderslab.dao;

import pl.coderslab.model.*;

import java.sql.*;
import java.util.Arrays;

public class OrderDao {

    private static final String CREATE_ORDER_QUERY =
            "INSERT INTO orderInf(entranceDate, planStartDate, startDate, employeeId, problemDescription, repairDescription, statusId, vehicleId, repairCost, partsCost, hoursNumber,costPerHour) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_ORDER_QUERY =
            "SELECT * FROM orderInf where id = ?";
    private static final String UPDATE_ORDER_QUERY =
            "UPDATE orderInf SET entranceDate=?, planStartDate=?, startDate=?, employeeId=?, problemDescription=?, repairDescription=?, statusId=?, vehicleId=?, repairCost=?, partsCost=?, hoursNumber=?, costPerHour=? where id = ?";
    private static final String DELETE_ORDER_QUERY =
            "DELETE FROM orderInf WHERE id = ?";
    private static final String FIND_ALL_ORDER_QUERY =
            "SELECT * FROM orderInf";
    private static final String FIND_ALL_ORDER_BY_EMPLOYEE_ID_QUERY =
            "SELECT * FROM orderInf WHERE employeeId = ?";
    private static final String FIND_ALL_ORDER_BY_STATUS_ID_QUERY =
            "SELECT * FROM orderInf WHERE statusId = ?";
    private static final String FIND_ALL_ORDER_BY_VEHICLE_ID_QUERY =
            "SELECT * FROM orderInf WHERE vehicleId = ?";
    private static final String FIND_NUMBER_OF_ORDER_QUERY =
            "SELECT * FROM orderInf ORDER BY entranceDate DESC LIMIT ?";



    public Order create(Order order) {

        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat =
                    connect.prepareStatement(CREATE_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStat.setDate(1, order.getEntranceDate());
            preStat.setDate(2, order.getPlanStartDate());
            preStat.setDate(3, order.getStartDate());
            preStat.setInt(4, order.getEmployee().getId());
            preStat.setString(5, order.getProblemDescription());
            preStat.setString(6, order.getRepairDescription());
            preStat.setInt(7, order.getStatus().getId());
            preStat.setInt(8, order.getVehicle().getId());
            preStat.setDouble(9, order.getRepairCost());
            preStat.setDouble(10, order.getPartsCost());
            preStat.setInt(11, order.getHoursNumber());
            preStat.setDouble(12, order.getCostPerHour());
            preStat.executeUpdate();
            ResultSet resultSet = preStat.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Order read(int orderId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(READ_ORDER_QUERY);
            preStat.setInt(1, orderId);
            ResultSet resultSet = preStat.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setEntranceDate(resultSet.getDate("entranceDate"));
                order.setPlanStartDate(resultSet.getDate("planStartDate"));
                order.setStartDate(resultSet.getDate("startDate"));

                EmployeeDao employeeDao = new EmployeeDao();
                int employeeId = resultSet.getInt("employeeId");
                Employee employee = employeeDao.read(employeeId);
                order.setEmployee(employee);

                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));

                StatusDao statusDao = new StatusDao();
                int statusId = resultSet.getInt("statusId");
                Status status = statusDao.read(statusId);
                order.setStatus(status);

                VehicleDao vehicleDao = new VehicleDao();
                int vehicleId = resultSet.getInt("vehicleId");
                Vehicle vehicle = vehicleDao.read(vehicleId);
                order.setVehicle(vehicle);

                order.setRepairCost(resultSet.getDouble("repairCost"));
                order.setPartsCost(resultSet.getDouble("partsCost"));
                order.setHoursNumber(resultSet.getInt("hoursNumber"));
                order.setCostPerHour(resultSet.getDouble("costPerHour"));

                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void update(Order order) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(UPDATE_ORDER_QUERY);
            preStat.setDate(1, order.getEntranceDate());
            preStat.setDate(2, order.getPlanStartDate());
            preStat.setDate(3, order.getStartDate());
            preStat.setInt(4, order.getEmployee().getId());
            preStat.setString(5, order.getProblemDescription());
            preStat.setString(6, order.getRepairDescription());
            preStat.setInt(7, order.getStatus().getId());
            preStat.setInt(8, order.getVehicle().getId());
            preStat.setDouble(9, order.getRepairCost());
            preStat.setDouble(10, order.getPartsCost());
            preStat.setInt(11, order.getHoursNumber());
            preStat.setDouble(12, order.getCostPerHour());
            preStat.setInt(13, order.getId());
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int orderId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(DELETE_ORDER_QUERY);
            preStat.setInt(1, orderId);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order[] findAll() {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_ORDER_QUERY);
            Order[] orders = findAllgetInf(preStat);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Order[] findNumberOf(int limit) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_NUMBER_OF_ORDER_QUERY);
            preStat.setInt(1, limit);
            Order[] orders = findAllgetInf(preStat);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Order[] findAllByEmployeeID(int employeeID) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_ORDER_BY_EMPLOYEE_ID_QUERY);
            preStat.setInt(1, employeeID);
            Order[] orders = findAllgetInf(preStat);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Order[] findAllByStatusID(int statusID) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_ORDER_BY_STATUS_ID_QUERY);
            preStat.setInt(1, statusID);
            Order[] orders = findAllgetInf(preStat);
            return orders;
        } catch (SQLException e) {;
            e.printStackTrace();
            return null;
        }
    }

    public Order[] findAllByVehicleID(int vehicleID) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_ORDER_BY_VEHICLE_ID_QUERY);
            preStat.setInt(1, vehicleID);
            Order[] orders = findAllgetInf(preStat);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }




    private Order[] findAllgetInf (PreparedStatement preStat){
        Order[] orders = new Order[0];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setEntranceDate(resultSet.getDate("entranceDate"));
                order.setPlanStartDate(resultSet.getDate("planStartDate"));
                order.setStartDate(resultSet.getDate("startDate"));

                EmployeeDao employeeDao = new EmployeeDao();
                int employeeId = resultSet.getInt("employeeId");
                Employee employee = employeeDao.read(employeeId);
                order.setEmployee(employee);

                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));

                StatusDao statusDao = new StatusDao();
                int statusId = resultSet.getInt("statusId");
                Status status = statusDao.read(statusId);
                order.setStatus(status);

                VehicleDao vehicleDao = new VehicleDao();
                int vehicleId = resultSet.getInt("vehicleId");
                Vehicle vehicle = vehicleDao.read(vehicleId);
                order.setVehicle(vehicle);

                order.setRepairCost(resultSet.getDouble("repairCost"));
                order.setPartsCost(resultSet.getDouble("partsCost"));
                order.setHoursNumber(resultSet.getInt("hoursNumber"));
                order.setCostPerHour(resultSet.getDouble("costPerHour"));

                orders = addToArray(order, orders);
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }



    private Order[] addToArray(Order o, Order[] orders) {
        Order[] tmpOrders = Arrays.copyOf(orders, orders.length + 1);
        tmpOrders[orders.length] = o;
        return tmpOrders;
    }
}

package pl.coderslab.dao;

import pl.coderslab.model.Employee;

import java.sql.*;
import java.util.Arrays;

public class EmployeeDao {
    private static final String CREATE_EMPLOYEE_QUERY =
            "INSERT INTO employee(name, lastname, address, phone, note, costPerHour) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String READ_EMPLOYEE_QUERY =
            "SELECT * FROM employee where id = ?";
    private static final String UPDATE_EMPLOYEE_QUERY =
            "UPDATE employee SET name=?, lastname=?, address=?, phone=?, note=?, costPerHour=? where id = ?";
    private static final String DELETE_EMPLOYEE_QUERY =
            "DELETE FROM employee WHERE id = ?";
    private static final String FIND_ALL_EMPLOYEE_QUERY =
            "SELECT * FROM employee";


    public Employee create(Employee employee) {

        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat =
                    connect.prepareStatement(CREATE_EMPLOYEE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStat.setString(1, employee.getName());
            preStat.setString(2, employee.getLastName());
            preStat.setString(3, employee.getAddress());
            preStat.setInt(4, employee.getPhone());
            preStat.setString(5, employee.getNote());
            preStat.setDouble(6, employee.getCostPerHour());
            preStat.executeUpdate();
            ResultSet resultSet = preStat.getGeneratedKeys();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
            }
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Employee read(int employeeId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(READ_EMPLOYEE_QUERY);
            preStat.setInt(1, employeeId);
            ResultSet resultSet = preStat.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setLastName(resultSet.getString("lastname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhone(resultSet.getInt("phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setCostPerHour(resultSet.getDouble("costPerHour"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void update(Employee employee) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(UPDATE_EMPLOYEE_QUERY);
            preStat.setString(1, employee.getName());
            preStat.setString(2, employee.getLastName());
            preStat.setString(3, employee.getAddress());
            preStat.setInt(4, employee.getPhone());
            preStat.setString(5, employee.getNote());
            preStat.setDouble(6, employee.getCostPerHour());
            preStat.setInt(7, employee.getId());
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int employeeId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(DELETE_EMPLOYEE_QUERY);
            preStat.setInt(1, employeeId);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee[] findAll() {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_EMPLOYEE_QUERY);
            Employee[] employees = findAllgetInf(preStat);
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private Employee[] findAllgetInf (PreparedStatement preStat){
        Employee[] employees = new Employee[0];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setLastName(resultSet.getString("lastname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhone(resultSet.getInt("phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setCostPerHour(resultSet.getDouble("costPerHour"));
                employees = addToArray(employee, employees);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Employee[] addToArray(Employee e, Employee[] employees) {
        Employee[] tmpEmployee = Arrays.copyOf(employees, employees.length + 1);
        tmpEmployee[employees.length] = e;
        return tmpEmployee;
    }


}

package pl.coderslab.dao;

import pl.coderslab.model.Customer;

import java.sql.*;
import java.util.Arrays;

public class CustomerDao {

    private static final String CREATE_CUSTOMER_QUERY =
            "INSERT INTO customer(name, lastname, birthdayDate) VALUES (?, ?, ?)";
    private static final String READ_CUSTOMER_QUERY =
            "SELECT * FROM customer where id = ?";
    private static final String UPDATE_CUSTOMER_QUERY =
            "UPDATE customer SET name = ?, lastname = ?, birthdayDate = ? where id = ?";
    private static final String DELETE_CUSTOMER_QUERY =
            "DELETE FROM customer WHERE id = ?";
    private static final String FIND_ALL_CUSTOMERS_QUERY =
            "SELECT * FROM customers";


    public Customer create(Customer customer) {

        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat =
                    connect.prepareStatement(CREATE_CUSTOMER_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStat.setString(1, customer.getName());
            preStat.setString(2, customer.getLastName());
            preStat.setDate(3, customer.getBirthdayDate());
            preStat.executeUpdate();
            ResultSet resultSet = preStat.getGeneratedKeys();
            if (resultSet.next()) {
                customer.setId(resultSet.getInt(1));
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Customer read(int customerId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(READ_CUSTOMER_QUERY);
            preStat.setInt(1, customerId);
            ResultSet resultSet = preStat.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setLastName(resultSet.getString("lastname"));
                customer.setBirthdayDate(resultSet.getDate("birthdayDate"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void update(Customer customer) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(UPDATE_CUSTOMER_QUERY);
            preStat.setString(1, customer.getName());
            preStat.setString(2, customer.getLastName());
            preStat.setDate(3, customer.getBirthdayDate());
            preStat.setInt(4, customer.getId());
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int customerId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(DELETE_CUSTOMER_QUERY);
            preStat.setInt(1, customerId);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer[] findAll() {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_CUSTOMERS_QUERY);
            Customer[] customers = findAllgetInf(preStat);
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private Customer[] findAllgetInf (PreparedStatement preStat){
        Customer[] customers = new Customer[0];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));

                customer.setName(resultSet.getString("name"));
                customer.setLastName(resultSet.getString("lastname"));
                customer.setBirthdayDate(resultSet.getDate("birthdayDate"));
                customers = addToArray(customer, customers);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Customer[] addToArray(Customer c, Customer[] customers) {
        Customer[] tmpCustomers = Arrays.copyOf(customers, customers.length + 1);
        tmpCustomers[customers.length] = c;
        return tmpCustomers;
    }

}

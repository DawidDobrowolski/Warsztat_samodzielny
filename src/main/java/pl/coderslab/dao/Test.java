package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;

public class Test {

    public static void main(String[] args) {

        CustomerDao customerDao = new CustomerDao();
        Customer[] customers  = customerDao.findAll();

        for (Customer cus : customers){
            System.out.println(cus.getName());
        }

        Customer customer = customerDao.read(1);
        System.out.println(customer.getBirthdayDate());

        OrderDao orderDao = new OrderDao();
        Order[] orders = orderDao.findAll();
        for (Order or : orders){
            System.out.println(or.toString());
        }

        Order order = orderDao.read(1);
        System.out.println(order.getVehicle().getPlateNumber());
        System.out.println(order.getVehicle().getCustomer().getName());
    }



}

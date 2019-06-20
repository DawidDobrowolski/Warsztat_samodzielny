package pl.coderslab.model;

import java.sql.Date;

public class Vehicle {

    private int id;
    private String model;
    private String brand;
    private int productionYear;
    private String plateNumber;
    private Date nextCheckDay;
    private Customer customer;


    public Vehicle() {
    }

    public Vehicle(String model, String brand, int productionYear, String plateNumber, Date nextCheckDay, Customer customer) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.plateNumber = plateNumber;
        this.nextCheckDay = nextCheckDay;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getNextCheckDay() {
        return nextCheckDay;
    }

    public void setNextCheckDay(Date nextCheckDay) {
        this.nextCheckDay = nextCheckDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

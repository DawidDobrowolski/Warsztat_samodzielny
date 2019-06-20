package pl.coderslab.model;

import java.sql.Date;

public class Order {

    private int id;
    private Date entranceDate;
    private Date planStartDate;
    private Date startDate;
    private Employee employee;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private Vehicle vehicle;
    private double repairCost;
    private double partsCost;
    private int hoursNumber;

    public Order() {
    }

    public Order(Date entranceDate, Date planStartDate, Date startDate, Employee employee, String problemDescription, String repairDescription, Status status, Vehicle vehicle, double repairCost, double partsCost, int hoursNumber) {
        this.entranceDate = entranceDate;
        this.planStartDate = planStartDate;
        this.startDate = startDate;
        this.employee = employee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.repairCost = repairCost;
        this.partsCost = partsCost;
        this.hoursNumber = hoursNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public int getHoursNumber() {
        return hoursNumber;
    }

    public void setHoursNumber(int hoursNumber) {
        this.hoursNumber = hoursNumber;
    }
}

package pl.coderslab.model;

public class Employee {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private int phone;
    private String note;
    private Double costPerHour;

    public Employee() {
    }

    public Employee(String name, String lastName, String address, int phone, String note, Double costPerHour) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.costPerHour = costPerHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
    }
}

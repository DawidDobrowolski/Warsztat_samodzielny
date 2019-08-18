package pl.coderslab.model;

import java.sql.Date;

public class Customer {
    private int id;
    private String name;
    private String lastName;
    private Date birthdayDate;

    public Customer() {
    }

    public Customer(String name, String lastname, Date birthdayDate) {
        this.name = name;
        this.lastName = lastname;
        this.birthdayDate = birthdayDate;
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

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

}

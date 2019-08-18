package pl.coderslab.model;

public class Status {
    /*Legenda statusow:

    0 - Accepted
    1 - Approved repair costs
    2 - In repair
    3 - Ready to pick up
    4 - Resignation

    * */

    private int id;
    private int statusCode;
    private String statusName;
    public  String[] statusNames = {"Accepted", "Approved repair costs", "In repair", "Ready to pick up", "Resignation"};

    public Status() {
    }

    public Status(int statusCode) {
        this.statusCode = statusCode;
        this.statusName = statusNames[statusCode];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        this.statusName = statusNames[statusCode];
    }

    public String getStatusName() {
        return statusName;
    }


    public String[] getStatusNames() {
        return statusNames;
    }
}

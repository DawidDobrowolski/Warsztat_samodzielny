package pl.coderslab.model;

public class Status {
    /*Legenda statusow:

    0 - Przyjęty
    1 - Zatwierdzone koszty naprawy
    2 - W naprawie
    3 - Gotowy do odbioru
    4 - Rezygnacja

    * */

    private int id;
    private int statusCode;

    public Status() {
    }

    public Status(int statusCode) {
        this.statusCode = statusCode;
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
    }
}

package pl.coderslab.model;

public class EmployeeReport {

    Employee employee;
    int hoursSum;

    public EmployeeReport() {
    }

    public EmployeeReport(Employee employee, int hoursSum) {
        this.employee = employee;
        this.hoursSum = hoursSum;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getHoursSum() {
        return hoursSum;
    }

    public void setHoursSum(int hoursSum) {
        this.hoursSum = hoursSum;
    }

    @Override
    public String toString() {
        return "EmployeeReport{" +
                "employee=" + employee.getName() +
                ", hoursSum=" + hoursSum +
                '}';
    }
}

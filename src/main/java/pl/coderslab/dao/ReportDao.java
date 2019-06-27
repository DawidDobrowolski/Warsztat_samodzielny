package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.EmployeeReport;

import java.sql.*;
import java.util.Arrays;

public class ReportDao {


    private static final String FIND_ORDER_IN_DATE_BY_EMPLOYEE_ID_QUERY =
            "SELECT employeeId,sum(hoursNumber) as hoursNumber FROM orderInf WHERE statusId BETWEEN 0 and 3 and startDate BETWEEN ? AND ? group by employeeId";
    private static final String FIND_ORDER_IN_DATE_COSTS =
            "SELECT SUM(repairCost) as repairCost,sum(partsCost) as partsCost, sum(hoursNumber) as hoursNumber, sum(costPerHour*hoursNumber ) as employeeCost FROM orderInf WHERE statusId BETWEEN 0 and 3 and startDate BETWEEN ? AND ?";


    public int[] findOrderCosts(Date start, Date end) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ORDER_IN_DATE_COSTS);
            preStat.setDate(1, start);
            preStat.setDate(2, end);
            int[] costs = findOrderCostsGetArr(preStat);
            return costs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int[] findOrderCostsGetArr (PreparedStatement preStat){
        int[] costs = new int[3];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()) {
                costs[0] = resultSet.getInt("repairCost");
                costs[1] = resultSet.getInt("partsCost");
                costs[2] = resultSet.getInt("hoursNumber");
                costs[3] = resultSet.getInt("employeeCost");

            }
            return costs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public EmployeeReport[] findAllInDateByEmployeeID(Date start, Date end) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ORDER_IN_DATE_BY_EMPLOYEE_ID_QUERY);
            preStat.setDate(1, start);
            preStat.setDate(2, end);
            EmployeeReport[] employeeReports = findAllgetInfEmployeeReport(preStat);
            return employeeReports;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private EmployeeReport[] findAllgetInfEmployeeReport (PreparedStatement preStat){
        EmployeeReport[] employeeReports = new EmployeeReport[0];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()) {
                EmployeeReport employeeReport = new EmployeeReport();

                EmployeeDao employeeDao = new EmployeeDao();
                int employeeId = resultSet.getInt("employeeId");
                Employee employee = employeeDao.read(employeeId);
                employeeReport.setEmployee(employee);

                employeeReport.setHoursSum(resultSet.getInt("hoursNumber"));


                employeeReports = addToArrayEmployeeReport(employeeReport, employeeReports);
            }
            return employeeReports;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private EmployeeReport[] addToArrayEmployeeReport(EmployeeReport e, EmployeeReport[] employeeReports) {
        EmployeeReport[] tmpEmployeeReports = Arrays.copyOf(employeeReports, employeeReports.length + 1);
        tmpEmployeeReports[employeeReports.length] = e;
        return tmpEmployeeReports;
    }


}

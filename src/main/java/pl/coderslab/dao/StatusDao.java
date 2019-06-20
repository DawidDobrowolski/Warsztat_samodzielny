package pl.coderslab.dao;

import pl.coderslab.model.Status;

import java.sql.*;
import java.util.Arrays;

public class StatusDao {

    private static final String CREATE_STATUS_QUERY =
            "INSERT INTO status(statusCode) VALUES (?)";
    private static final String READ_STATUS_QUERY =
            "SELECT * FROM status where id = ?";
    private static final String UPDATE_STATUS_QUERY =
            "UPDATE status SET statusCode = ? where id = ?";
    private static final String DELETE_STATUS_QUERY =
            "DELETE FROM status WHERE id = ?";
    private static final String FIND_ALL_STATUS_QUERY =
            "SELECT * FROM status";


    public Status create(Status status) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat =
                    connect.prepareStatement(CREATE_STATUS_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStat.setInt(1, status.getStatusCode());
            preStat.executeUpdate();
            ResultSet resultSet = preStat.getGeneratedKeys();
            if (resultSet.next()) {
                status.setId(resultSet.getInt(1));
            }
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Status read(int statusId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(READ_STATUS_QUERY);
            preStat.setInt(1, statusId);
            ResultSet resultSet = preStat.executeQuery();
            if (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setStatusCode(resultSet.getInt("statusCode"));
                return status;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void update(Status status) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(UPDATE_STATUS_QUERY);
            preStat.setInt(1, status.getStatusCode());
            preStat.setInt(2, status.getId());
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int statusId) {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(DELETE_STATUS_QUERY);
            preStat.setInt(1, statusId);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Status[] findAll() {
        try (Connection connect = DbUtil.getConn()) {
            PreparedStatement preStat = connect.prepareStatement(FIND_ALL_STATUS_QUERY);
            Status[] statuses = findAllgetInf(preStat);
            return statuses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private Status[] findAllgetInf (PreparedStatement preStat){
        Status[] statuses = new Status[0];
        try (ResultSet resultSet = preStat.executeQuery()) {
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setStatusCode(resultSet.getInt("statusCode"));
                statuses = addToArray(status, statuses);
            }
            return statuses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Status[] addToArray(Status s, Status[] statuses) {
        Status[] tmpStatuses = Arrays.copyOf(statuses, statuses.length + 1);
        tmpStatuses[statuses.length] = s;
        return tmpStatuses;
    }
}

package pl.coderslab.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static DataSource ds;

    private static final String URL =
            "jdbc:mysql://localhost:3306/car?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "coderslab";

    public static Connection getConn() throws SQLException {
        return getInstance().getConnection();
    }

    private static DataSource getInstance() {
        if(ds == null) {
            try {
                Context ctx = new InitialContext();
                ds = (DataSource)ctx.lookup("java:comp/env/jdbc/car");
            } catch (NamingException e) {
                e.printStackTrace();}}
        return ds;}


    public static Connection getConn2() throws SQLException {
        return DriverManager.getConnection(URL,USER, PASSWORD);
    }
}

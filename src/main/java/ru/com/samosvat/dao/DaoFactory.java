package ru.com.samosvat.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    static Logger log = Logger.getLogger(DaoFactory.class.getName());

    private static final String urlPostGre = "jdbc:postgresql://localhost/students";

    public static Connection getConnection(DbType type) {
        Connection con = null;
        switch (type) {
            case MYSQL:
                break;
            case POSTGRESQL:
                con = getPostgreConnection();
                break;
            default: {
            }
        }
        return con;
    }

    private static Connection getPostgreConnection() {

        try {
            log.info("load postgre driver");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error("driver class not found");
            log.error(e.getMessage());
        }
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "admin");
        Connection conn = null;
        try {
            log.info("create connection");
            conn = DriverManager.getConnection(urlPostGre, props);
        } catch (SQLException e) {
            log.error("connection error");
            log.error(e.getMessage());
        }
        return conn;
    }

    private static Connection getGetMySQLConnection() {
        return null;
    }
}

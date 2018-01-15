package com.sokil.configuration;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Log4j
public class ConnectionManager {
    private static Connection con;

    public static synchronized Connection getConnection() {
        if (con == null){
            Properties props = new Properties();
            try {
                InputStream inputStream = ConnectionManager.class.getResourceAsStream("/db.properties");
                props.load(inputStream);
                Class.forName(props.getProperty("jdbc.driverClassName"));
                    try {
                        con = DriverManager.getConnection(
                                props.getProperty("jdbc.url"),
                                props.getProperty("jdbc.username"),
                                props.getProperty("jdbc.password"));
                    } catch (SQLException ex) {
                        log.error("Failed to create the database connection.",ex);
                    }

            } catch (IOException | ClassNotFoundException ex) {
                log.error("Driver not found.",ex);
            }
            return con;
        }
        return con;
    }
}

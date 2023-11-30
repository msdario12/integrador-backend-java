package ar.com.integradorbackend.repository;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ConnectionsManager
 */
public class ConnectionsManager {

    public static Connection getConnection() {
        String host = "localhost";
        String username = "dariomsn12";
        String password = "sqlADX339";
        String port = "3306";
        String dbName = "integrador_codoacodo";

        String dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?serverTimeZone=UTC&useSSL=false";

        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo obtener conexion: " + e + dbUrl);
        }

    }

    public static Connection getMariaConnection() {

        String host = "localhost";
        String username = "dariomsn12";
        String password = "sqlADX339";
        String port = "3306";
        String dbName = "integrador_codoacodo";

        String dbUrl = "jdbc:mariadb://" + host + ":" + port + "/" + dbName;

        String driver = "org.mariadb.jdbc.Driver";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo obtener conexion: " + e + dbUrl);
        }
    }

}

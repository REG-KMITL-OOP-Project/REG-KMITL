package dev.it22.kmitl.reg.utils;

import java.sql.*;
import java.util.Objects;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {
    Dotenv dotenv = Dotenv.load();

    private Connection conn;
    private String hostname;
    private int port;
    private String databaseName;
    private String username;
    private String password;

    public Database(String hostname, int port, String databaseName, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }

    public Database() {

        if (dotenv.get("DATABASE_HOSTNAME") == null) {
            System.out.println("🚫 DATABASE_HOSTNAME not set");
            return;
        }
        if (dotenv.get("DATABASE_PORT") == null) {
            System.out.println("🚫 DATABASE_PORT not set");
            return;
        }
        if (dotenv.get("DATABASE_DBNAME") == null) {
            System.out.println("🚫 DATABASE_DBNAME not set");
            return;
        }
        if (dotenv.get("DATABASE_USERNAME") == null) {
            System.out.println("🚫 DATABASE_USERNAME not set");
            return;
        }
        if (dotenv.get("DATABASE_PASSWORD") == null) {
            System.out.println("🚫 DATABASE_PASSWORD not set");
            return;
        }
        this.hostname = dotenv.get("DATABASE_HOSTNAME");
        this.port = Integer.parseInt(Objects.requireNonNull(dotenv.get("DATABASE_PORT")));
        this.databaseName = dotenv.get("DATABASE_DBNAME");
        this.username = dotenv.get("DATABASE_USERNAME");
        this.password = dotenv.get("DATABASE_PASSWORD");

        String dbStringConnect = "jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.databaseName;
        System.out.println("💛Try to connect to " + dbStringConnect);
        try {
            this.conn = DriverManager.getConnection(dbStringConnect, this.username, this.password);
        }
        catch (Exception e) {
            System.out.println("❤️‍🔥 Error connecting to " + dbStringConnect + ": " + e.getMessage());
        }
    }


    public ResultSet getQuery(String query) throws  SQLException {
        System.out.println("💗 Try to execute query " + query);
        try{

            Statement stmt = this.conn.createStatement();
            return stmt.executeQuery(query);
        }
        catch (Exception e) {
            System.out.println("❤️‍🔥 Error executing query " + query + " : " + e.getMessage());
            throw new SQLException("Database Error: " + e.getMessage());
        }
    }

    public int postQuery(String query) throws  SQLException {
        System.out.println("💗 Try to execute query " + query);
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println("❤️‍🔥 Error executing query " + query + " : " + e.getMessage());
            throw new SQLException("Database Error: " + e.getMessage());
        }
    }
}

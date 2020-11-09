package ru.dpopkov.apatheia.qabase;

import java.io.StringWriter;
import java.sql.*;

public class TestDb {
    public static void main(String[] args) {
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcUrl = "jdbc:postgresql://localhost:5432/qabase";
        String user = "postgres";
        String pass = "";
        StringWriter writer = new StringWriter();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, pass)) {
            writer.append("Connection: ").append(connection.toString()).append("\n");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) from questions");
            if (rs.next()) {
                int count = rs.getInt(1);
                writer.append("count(*) from questions = ").append(String.valueOf(count));
            }
            System.out.println(writer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

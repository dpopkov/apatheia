package ru.dpopkov.apatheia.qabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        writer.append("Served at: ").append(req.getContextPath()).append("\n");
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
        String jdbcUrl = "jdbc:postgresql://localhost:5432/qabase";
        Properties info = new Properties();
        info.load(TestDbServlet.class.getResourceAsStream("/db.properties"));
        try (Connection connection = DriverManager.getConnection(jdbcUrl, info)) {
            writer.append("Connection: ").append(connection.toString()).append("\n");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) from questions");
            if (rs.next()) {
                int count = rs.getInt(1);
                writer.append("count(*) from questions = ").append(String.valueOf(count));
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

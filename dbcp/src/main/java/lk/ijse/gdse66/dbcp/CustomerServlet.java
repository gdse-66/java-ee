package lk.ijse.gdse66.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "customerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext sc = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) sc.getAttribute("dbcp");
        try {
            Connection connection = dbcp.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
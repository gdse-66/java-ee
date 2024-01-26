package lk.ijse.gdse66.builtincp;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;

@WebServlet(name = "customerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            InitialContext ic = new InitialContext();
            DataSource pool = (DataSource) ic.lookup("java:/comp/env/jdbc/pos");

            Connection connection = pool.getConnection();

            System.out.println(connection);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
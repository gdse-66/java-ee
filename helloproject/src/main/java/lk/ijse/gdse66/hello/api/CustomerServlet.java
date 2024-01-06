package lk.ijse.gdse66.hello.api;

import com.mysql.cj.xdevapi.JsonArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Customer", urlPatterns = "/customers", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "username" , value = "root"),
        @WebInitParam(name = "password" , value = "MYsql@123@"),
        @WebInitParam(name = "url" , value = "jdbc:mysql://localhost:3306/gdse66_hello")
})
public class CustomerServlet extends HttpServlet {
    private String username;
    private String password;
    private String url;

    @Override
    public void init() throws ServletException {
        /*ServletConfig is used to get configuration information such as database url, mysql username and password*/
        ServletConfig sc = getServletConfig();
        username = sc.getInitParameter("username");
        password = sc.getInitParameter("password");
        url = sc.getInitParameter("url");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;

        /*catch request parameter as a String*/
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");

        System.out.printf("id=%s, name=%s, address=%s\n", id,name,address);

        /*create a database connection and save data in database*/
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            PreparedStatement stm = connection.prepareStatement("INSERT INTO customer(id, name, address) VALUES (?,?,?)");

            stm.setString(1,id);
            stm.setString(2, name);
            stm.setString(3, address);

            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection !=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;

        /*create a database connection and fetch data in database*/
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM customer");
            ResultSet rst = stm.executeQuery();

            String jsonArray = "";

            while (rst.next()){
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString("address");
                System.out.printf("id=%s, name=%s, address=%s\n",id,name,address);

                /*String customer = String.format("id=%s, name=%s, address=%s\n", id, name, address);
                writer.write(customer); // write all customers as the text in response*/

                /*Example for Json object format: {"id":C001, "name":Kasun, "address":Galle}*/
                String jsonObject = "{ \"id\": \"" + id + "\"," + "\"name\":\""+ name+ "\"," + "\"address\":\"" + address + "\"}"; //convert one customer record to JSON object format
                jsonArray += jsonObject + ",";
            }

            jsonArray = "[" + jsonArray.substring(0,jsonArray.length()-1) + "]"; //create JSON array format to add all customers

            resp.getWriter().write(jsonArray); //write JSON array format in response
            resp.setContentType("application/json"); //set the MIME type of the content of the response (Thus, add response header called "Content-Type")

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection !=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

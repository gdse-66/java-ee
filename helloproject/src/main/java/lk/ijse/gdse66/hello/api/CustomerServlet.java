package lk.ijse.gdse66.hello.api;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        System.out.println("doPost()");

        /*
         * catch form data when they are submitted as <form action="customers" method="post" enctype="application/x-www-form-urlencoded">
         * data is sent through body (application/x-www-form-urlencoded)
         */
        String id = req.getParameter("CusId");
        String name = req.getParameter("CusName");
        String address = req.getParameter("CusAddress");

        System.out.printf("id=%s, name=%s, address=%s\n", id,name,address);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet()");

        /*
         * catch form data when they are submitted as <form action="customers" method="get">
         * data is sent as Query string
         */
        String id = req.getParameter("CusId");
        String name = req.getParameter("CusName");
        String address = req.getParameter("CusAddress");

        System.out.printf("id=%s, name=%s, address=%s\n", id,name,address);
    }
}

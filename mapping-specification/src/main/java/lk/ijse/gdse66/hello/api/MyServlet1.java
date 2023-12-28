package lk.ijse.gdse66.hello.api;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

/*------------   Exact Mapping  -----------------*/
@WebServlet(name = "MyServlet1", urlPatterns = "/hello")
public class MyServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello, I'm from MyServlet1</h1>");
    }
}


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

        System.out.println("---------------Exact Mapping ----------------");
        System.out.println("ContextPath: " + request.getContextPath());
        System.out.println("PathInfo: " + request.getPathInfo());
        System.out.println("ServletPath: " + request.getServletPath());
        System.out.println("PathTranslated: " + request.getPathTranslated());
        System.out.println("queryString: " + request.getQueryString());
        System.out.println("RequestURI: " + request.getRequestURI());
        System.out.println("RequestURL: " + request.getRequestURL());
        System.out.println("Protocol: " + request.getProtocol());
        System.out.println("Scheme: " + request.getScheme());
        System.out.println("Remote Address: " + request.getRemoteAddr());
        System.out.println("RequestPort: " + request.getRemotePort());
        System.out.println("RemoteHost: " + request.getRemoteHost());
        System.out.println("ServerName: " + request.getServerName());
        System.out.println("ServerPort: " + request.getServerPort());
        System.out.println("Method: " + request.getMethod());
    }
}


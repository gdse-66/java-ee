package lk.ijse.gdse66.hello.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*------------   Wildcard Mapping  -----------------*/
@WebServlet(name = "MyServlet2", urlPatterns = "/*")
public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello, I'm from MyServlet2</h1>");

        System.out.println("---------------Wildcard Mapping ----------------");
        System.out.println("ContextPath: " + request.getContextPath());
        System.out.println("PathInfo: " + request.getPathInfo());
        System.out.println("ServletPath: " + request.getServletPath());
        System.out.println("PathTranslated: " + request.getPathTranslated());
        System.out.println("queryString: " + request.getQueryString());
        System.out.println("RequestURI: " + request.getRequestURI());
        System.out.println("RequestURL: " + request.getRequestURL());
    }
}

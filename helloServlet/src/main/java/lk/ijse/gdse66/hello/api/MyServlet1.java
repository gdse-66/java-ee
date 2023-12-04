package lk.ijse.gdse66.hello.api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet1 : doGet()");
        resp.getWriter().println("I am from the MyServlet1 : doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet1 : doPost()");
        resp.getWriter().println("I am from the MyServlet1 : doPost()");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet1 : doPut()");
        resp.getWriter().println("I am from the MyServlet1 : doPut()");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet1 : doDelete()");
        resp.getWriter().println("I am from the MyServlet1 : doDelete()");
    }

}

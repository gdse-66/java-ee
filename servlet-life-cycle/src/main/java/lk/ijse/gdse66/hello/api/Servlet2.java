package lk.ijse.gdse66.hello.api;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class Servlet2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet2: init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet2: doGet()");
    }

}

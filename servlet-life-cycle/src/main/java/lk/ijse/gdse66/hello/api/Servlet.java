package lk.ijse.gdse66.hello.api;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet: init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet: doGet()");
    }

}

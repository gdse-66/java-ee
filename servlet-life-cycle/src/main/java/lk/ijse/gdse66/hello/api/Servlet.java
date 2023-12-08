package lk.ijse.gdse66.hello.api;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet extends HttpServlet {

    static{
        System.out.println("Servlet class object is being initialized");
    }

    public Servlet() {
        System.out.println("Servlet: constructor()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet: init(ServletConfig)");
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet: init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet: doGet()");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet: destroy()");
    }
}

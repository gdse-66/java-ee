package lk.ijse.gdse66.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebFilter(filterName = "CORSFilter", urlPatterns = {"/customers", "/orders"})*/
/*@WebFilter(filterName = "CORSFilter", urlPatterns = "/*")*/
public class CORSFilter extends HttpFilter {

    static {
        System.out.println("CORSFilter Class object is being initialized");
    }

    public CORSFilter() {
        System.out.println("CORSFilter: constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("CORSFilter: init()");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("CORSFilter: incoming request");

        System.out.println("CORSFilter: dispatch to the next filter/servlet");
        chain.doFilter(req,res);

        System.out.println("CORSFilter: outgoing Response");

    }

    @Override
    public void destroy() {
        System.out.println("CORSFilter is about to destroy");
    }
}

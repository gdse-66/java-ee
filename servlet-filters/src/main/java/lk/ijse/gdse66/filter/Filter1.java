package lk.ijse.gdse66.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Filter1 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter1: incoming request");

        System.out.println("Filter1: dispatch to the next filter/servlet");
        chain.doFilter(req,res);

        System.out.println("Filter1: outgoing Response");

    }
}

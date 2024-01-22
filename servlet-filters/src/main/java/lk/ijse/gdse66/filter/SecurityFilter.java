package lk.ijse.gdse66.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SecurityFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("SecurityFilter: incoming request");

        System.out.println("SecurityFilter: dispatch to the next filter/servlet");
        chain.doFilter(req,res);

        System.out.println("SecurityFilter: outgoing Response");

    }
}

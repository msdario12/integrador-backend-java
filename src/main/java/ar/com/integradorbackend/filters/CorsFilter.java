package ar.com.integradorbackend.filters;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * CorsFilter
 */
@WebFilter(urlPatterns = { "/*" })
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        List<String> originesPermitidos = List.of("http://localhost:8080", "http://127.0.0.1:8080",
                "http://localhost:33063", "http://127.0.0.1:33063");

        String origin = ((HttpServletRequest) req).getHeader("Origin");

        if (origin != null && originesPermitidos.contains(origin)) {
            ((HttpServletResponse) res).addHeader("Access-Control-Allow-Origin", origin);
            ((HttpServletResponse) res).addHeader("Access-Control-Allow-Methods",
                    "GET, OPTIONS, HEAD, PUT, POST, DELETE");
            ((HttpServletResponse) res).addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        }
        if (((HttpServletRequest) req).getMethod().equals("OPTIONS")) {
            ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }
        chain.doFilter(req, res);
    }

}

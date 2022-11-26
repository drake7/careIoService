package careIOv2.org.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyCorsFilter implements Filter {


@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers",
    		"Access-Control-Allow-Origin,"
    		+ "Access-Control-Allow-Headers,"
    		+ "Access-Control-Allow-Methods,"
    		+ "Content-Type,"
    		+ "Authorization,"
    		+ "Accept,"
    		+ " X-Requested-With,"
    		+ " remember-me,Postman-Token,Cookie,Connection,Content-Length,Host,User-Agent,Accept,Accept-Encoding");

    chain.doFilter(req, res);
}

@Override
public void init(FilterConfig filterConfig) {
}




@Override
public void destroy() {
}

}
package vn.vnpay.persistenjpa.config;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class FilterRequest implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(FilterRequest.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UUID uuid = UUID.randomUUID();
        ThreadContext.put("token", uuid.toString());
        logger.info("Create token request in Thread context: {} ", uuid.toString());
        chain.doFilter(request,response);
    }

}

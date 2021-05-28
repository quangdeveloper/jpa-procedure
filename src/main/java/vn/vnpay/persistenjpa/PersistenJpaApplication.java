package vn.vnpay.persistenjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class PersistenJpaApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(PersistenJpaApplication.class, args);
    }

}

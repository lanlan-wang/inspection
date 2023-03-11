package com.wll.inspection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wll
 */
@SpringBootApplication
public class InspectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(InspectionApplication.class, args);
    }


}

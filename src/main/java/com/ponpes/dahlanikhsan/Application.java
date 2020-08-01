package com.ponpes.dahlanikhsan;

import com.ponpes.dahlanikhsan.app_security.model.FUser;
import com.ponpes.dahlanikhsan.app_security.repository.UserRepository;
import com.ponpes.dahlanikhsan.app_security.repository.UserService;
import com.ponpes.dahlanikhsan.app_security.securityconfig.SecurityConfiguration;
import com.ponpes.dahlanikhsan.ui.views.Home;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * The entry point of the Spring Boot application.
 */
//@SpringBootApplication(scanBasePackageClasses = { MainView.class}, exclude = SecurityAutoConfiguration.class)
 @SpringBootApplication(scanBasePackageClasses = { SecurityConfiguration.class, MainView.class, Application.class,
        Home.class, UserService.class }, exclude = ErrorMvcAutoConfiguration.class)


@EnableJpaRepositories(basePackageClasses = { UserRepository.class })
@EntityScan(basePackageClasses = { FUser.class })
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }

}

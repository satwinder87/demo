package com.example.demo;

import com.example.demo.rest.PingController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;

@SpringBootTest()
class DemoApplicationTests {
    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(context);
    }

    @Test
    void AuthenticationManagerTest() {
        Assertions.assertNotNull(context);

        PingController pingController = this.context.getBean(PingController.class);
        Assertions.assertNotNull(pingController);

        Arrays.stream(this.context.getBeanDefinitionNames()).forEach(System.out::println);

        AuthenticationManager authenticationManager = this.context.getBean(AuthenticationManager.class);
        Assertions.assertNotNull(authenticationManager);
        Authentication authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated("user", "password"));
		Assertions.assertTrue(authentication.isAuthenticated());

    }

}

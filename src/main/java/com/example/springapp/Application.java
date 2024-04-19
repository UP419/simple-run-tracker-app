package com.example.springapp;

import com.example.springapp.user.User;
import com.example.springapp.user.UserHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        log.info("Application started successfully");
    }


    @Bean
    UserHttpClient userHttpClient() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(UserHttpClient.class);
    }
//    @Bean
//    CommandLineRunner runner(UserRestClient restClient) {
//        return args -> {
//            System.out.println("----------");
//            List<User> users = restClient.findAll();
//            System.out.println(users);
//            User user = restClient.findById(1);
//            System.out.println(user);
//        };
//    }

    @Bean
    CommandLineRunner runner(UserHttpClient client) {
        return args -> {
            System.out.println("----------");
            List<User> users = client.findAll();
            System.out.println(users);
            User user = client.findById(1);
            System.out.println(user);
        };
    }

}


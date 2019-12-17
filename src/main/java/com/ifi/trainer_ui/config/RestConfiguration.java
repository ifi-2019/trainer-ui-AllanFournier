package com.ifi.trainer_ui.config;

import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfiguration {

    @Value("${trainer.service.username}")
    String username;

    @Value("${trainer.service.password}")
    String password;

    @Bean
    RestTemplate trainerApiRestTemplate(){
        RestTemplate restTemp = new RestTemplate();
        List A = new ArrayList();
        A.add(new BasicAuthenticationInterceptor(username,password));
        restTemp.setInterceptors(A);
        return  restTemp;
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}

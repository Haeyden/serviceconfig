package com.micomecy.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: serviceconfig
 * @Date: 2019.2.21 下午 1:00
 * @Author: MicoMecy
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ConfigClientApplication {

    /**
     * http://localhost:8881/actuator/bus-refresh
     */


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
    @Value("${foo}")
    String foo;
    @RequestMapping("/hi")
    public String hi(){
        return foo;
    }
}

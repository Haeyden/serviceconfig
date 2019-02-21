package com.micomecy.hi;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;

/**
 * @program: serviceconfig
 * @Date: 2019.2.21 下午 7:46
 * @Author: MicoMecy
 */
@SpringBootApplication
@RestController
public class HiServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HiServiceApplication.class, args);
    }
    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome(){
        System.out.println("calling trace hi-service");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        System.out.println("calling trace service-hi");
        return "I service-hi";
    }

    @Bean
    public Sampler defayltSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}

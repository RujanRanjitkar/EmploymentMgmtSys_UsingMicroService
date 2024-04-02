package com.example.employee_service.openFeignClient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "ADDRESS-SERVICE", configuration = MyCustomLoadBalancerConfiguration.class)
public class AddressServiceLoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feiBuilder(){
        return Feign.builder();
    }
}

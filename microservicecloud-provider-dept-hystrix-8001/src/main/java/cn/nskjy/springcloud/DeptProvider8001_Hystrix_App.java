package cn.nskjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("cn.nskjy.springcloud.*")
@SpringBootApplication
@EnableEurekaClient // 服务启动后会自动注入进eureka服务中
@EnableCircuitBreaker // 对HystrixR的熔断支持
public class DeptProvider8001_Hystrix_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Hystrix_App.class,args);
    }
}

package cn.nskjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("cn.nskjy.springcloud.*")
@SpringBootApplication
@EnableEurekaClient // 服务启动后会自动注入进eureka服务中
//@EnableDiscoveryClient // 服务发现 @EnableEurekaClient已包含
public class DeptProvider8002_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002_App.class,args);
    }
}

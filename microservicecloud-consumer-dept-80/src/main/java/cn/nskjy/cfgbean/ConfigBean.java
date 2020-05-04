package cn.nskjy.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced // 开启负载均衡？？？ SpringCloud Ribbon是一款基于Netflix Ribbon实现的一套客户端 负载均衡的工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
//        return new RandomRule(); // 开启Ribbon随机轮询算法
        return new RetryRule();// 默认是轮询算法
    }
}

/*
* application.xml
* <bean id="user" class="cn.nskjy.User"">
* </bean>
* @Configuretion 相当于注解版的spring容器
*/

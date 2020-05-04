package cn.nskjy.controller;

import com.nskjy.springcloud.entitys.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_consumer {

//    private static final String URL_PREFIX = "http://localhost:8001";
    private static final String URL_PREFIX = "http://MICROSERVERCLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/dept/consumer/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/dept/consumer/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @RequestMapping(value = "/dept/consumer/list")
    public List<Dept> list() {
        return restTemplate.getForObject(URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/dept/consumer/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        restTemplate.delete(URL_PREFIX + "/dept/delete/" + id);
    }

    @RequestMapping(value = "/dept/consumer/update")
    public void update(Dept dept) {
       restTemplate.put(URL_PREFIX + "/dept/update", dept);
    }

    @RequestMapping(value = "/dept/consumer/discovery")
    public Object discovery() {
        return restTemplate.getForObject(URL_PREFIX + "/dept/discovery",Object.class);
    }
}

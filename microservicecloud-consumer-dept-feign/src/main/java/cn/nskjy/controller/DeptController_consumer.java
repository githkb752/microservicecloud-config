package cn.nskjy.controller;

import com.nskjy.springcloud.entitys.Dept;
import com.nskjy.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptController_consumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/dept/consumer/add")
    public boolean add(Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping(value = "/dept/consumer/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/dept/consumer/list")
    public List<Dept> list() {
        return service.findAll();
    }
}

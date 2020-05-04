package com.nskjy.springcloud.service;

import com.nskjy.springcloud.entitys.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "MICROSERVERCLOUD-DEPT")
@FeignClient(value = "MICROSERVERCLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Integer id); // 按照id查部门

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> findAll(); // 查找所有部门

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean addDept(Dept dept); // 添加部门

    @RequestMapping(value = "/dept/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Integer id); // 按照id删除部门

    public boolean update(Dept dept); // 更新部门
}

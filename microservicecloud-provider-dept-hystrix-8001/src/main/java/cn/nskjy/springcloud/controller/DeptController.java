package cn.nskjy.springcloud.controller;

import cn.nskjy.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nskjy.springcloud.entitys.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service = null;

    @Autowired
    private DiscoveryClient client;



    // 一旦调用失败并抛出错误的信息后，就会调用@HystrixCommand中fallbackMethed中指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Integer id) {
        Dept dept = service.get(id);
        if (dept == null) {
            throw new RuntimeException("该ID：" + id + "没有对应的信息");
        }
        return dept;
    }
    public Dept processHystrix_Get(@PathVariable("id") Integer id) {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,null -- hystrix").setDb_source("数据库没有该信息");
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Integer id) { // 按照id删除部门
        return service.delete(id);
    }

    @RequestMapping(value = "/dept/update", method = RequestMethod.PUT)
    public boolean update(@RequestBody Dept dept) { // 更新部门
        return service.update(dept);
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> services = client.getServices();
        System.out.println("***********" + services);
        List<ServiceInstance> instances = client.getInstances("microservercloud-dept");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getPort() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }
        return this.client;
    }

}

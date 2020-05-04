package com.nskjy.springcloud.service;

import com.nskjy.springcloud.entitys.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 这个别忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept findById(Integer id) {
                return new Dept().setDeptno(id).setDname("该id" + id +"没有对应的信息：Consumer提供的降级信息,此刻服务provider已关闭").setDb_source("no this database in mysql");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public boolean delete(Integer id) {
                return false;
            }

            @Override
            public boolean update(Dept dept) {
                return false;
            }
        };
    }
}

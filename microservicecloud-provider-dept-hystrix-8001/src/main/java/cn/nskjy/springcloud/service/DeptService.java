package cn.nskjy.springcloud.service;

import com.nskjy.springcloud.entitys.Dept;

import java.util.List;

public interface DeptService {

    public Dept get(Integer id); // 按照id查部门

    public List<Dept> list(); // 查找所有部门

    public boolean add(Dept dept); // 添加部门

    public boolean delete(Integer id); // 按照id删除部门

    public boolean update(Dept dept); // 更新部门
}

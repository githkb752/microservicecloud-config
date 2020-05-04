package cn.nskjy.springcloud.dao;

import com.nskjy.springcloud.entitys.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    public Dept findById(Integer id); // 按照id查部门

    public List<Dept> findAll(); // 查找所有部门

    public boolean addDept(Dept dept); // 添加部门

    public boolean deleById(Integer id); // 按照id删除部门

    public boolean updateDept(Dept dept); // 更新部门
}

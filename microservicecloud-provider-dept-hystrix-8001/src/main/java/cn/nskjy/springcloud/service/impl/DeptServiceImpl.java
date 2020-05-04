package cn.nskjy.springcloud.service.impl;

import cn.nskjy.springcloud.dao.DeptMapper;
import cn.nskjy.springcloud.service.DeptService;
import com.nskjy.springcloud.entitys.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept get(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }

    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public boolean delete(Integer id) { // 按照id删除部门
        return deptMapper.deleById(id);
    }

    @Override
    public boolean update(Dept dept) { // 更新部门
        return deptMapper.updateDept(dept);
    }
}

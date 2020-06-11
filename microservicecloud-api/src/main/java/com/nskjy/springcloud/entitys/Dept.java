package com.nskjy.springcloud.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable { // entity Dept orm mysql dept表 // 必须序列化
    private String dname; // 部门名称
    private String db_source; // 来自哪个数据库，微服务架构每个服务可以对应一个数据库，同一个信息可以存储到不同数据库

    public Dept(String db_source) {
        this.db_source = db_source;
    }
}

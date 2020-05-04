package com;

import cn.hutool.http.HttpUtil;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DeptProvider8001_App.class)
public class tes6t {

    @Test
    public void testa(){


        String restp = HttpUtil.get("http://localhost:8001/dept/list");

        System.out.println("resp: " + restp);


    }
}

package com.erp;

import com.erp.domain.LeavesAdmin;
import com.erp.mapper.LeaveMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErpApplicationTests {
@Autowired
private LeaveMapper leaveMapper;
    @Test
    public void contextLoads() {
    Integer a=500;
    Integer b=500;
        System.out.println(a==b);
    }

}

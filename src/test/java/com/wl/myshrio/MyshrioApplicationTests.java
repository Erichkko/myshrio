package com.wl.myshrio;

import com.wl.myshrio.generator.jooq.tables.pojos.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.wl.myshrio.generator.jooq.Tables.SYS_USER;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyshrioApplicationTests {

    @Autowired
    DSLContext dsl;

    @Test
    public void contextLoads() {
    }

    @Test
    public void dbTest(){
        List<SysUser> result =  dsl.select()
                .from(SYS_USER)
                .fetch()
                .into(SysUser.class);
        System.out.println(result.toString());
    }

}

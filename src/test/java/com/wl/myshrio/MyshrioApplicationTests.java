package com.wl.myshrio;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.pojos.SysUser;
import com.wl.myshrio.service.OperatingRecordService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyshrioApplicationTests {

    @Autowired
    DSLContext dsl;

    @Autowired
    OperatingRecordService operatingRecordService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void dbTest() {
        List<SysUser> result = dsl.select()
                .from(Tables.SYS_USER)
                .fetch()
                .into(SysUser.class);
        System.out.println(result.toString());
    }

    @Test
    public void t1() {
        dsl.select(
                Tables.SYS_OPERATING_RECORD.UID.as("Na"),
                DSL.count(),
                DSL.field("2").as("type")).
                from(Tables.SYS_OPERATING_RECORD).
                where(Tables.SYS_OPERATING_RECORD.UID.isNull()).or(Tables.SYS_OPERATING_RECORD.UID.in(dsl.select(Tables.SYS_USER.ID).from(Tables.SYS_USER)));

    }

}

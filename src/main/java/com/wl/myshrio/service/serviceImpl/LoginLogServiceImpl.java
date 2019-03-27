package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog;
import com.wl.myshrio.service.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.wl.myshrio.generator.jooq.Tables.SYS_LOGIN_LOG;

@Slf4j
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    DSLContext dslContext;
    @Override
    public void insert(SysLoginLog sysLoginLog) {
        int execute = dslContext.insertInto(SYS_LOGIN_LOG).
                set(SYS_LOGIN_LOG.LOGINIP, sysLoginLog.getLoginip()).
                set(SYS_LOGIN_LOG.LOGINTIME, sysLoginLog.getLogintime()).
                set(SYS_LOGIN_LOG.LOGINTOTAL, sysLoginLog.getLogintotal()).
                set(SYS_LOGIN_LOG.UID, sysLoginLog.getUid()).
                set(SYS_LOGIN_LOG.ID,sysLoginLog.getId()).
                execute();
        log.error("插入访问数据：(1 代表success)" +execute);
    }

    @Override
    public Integer findVisitCountByUserId(String uid) {
        Integer record1 = dslContext.selectCount().
                from(SYS_LOGIN_LOG).
                where(SYS_LOGIN_LOG.UID.eq(uid)).
                fetchOne(0,Integer.class);
        log.error("record1 == "+record1);
//        int i = s + 1;
        return record1+1;
    }


}

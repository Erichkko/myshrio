package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog;
import com.wl.myshrio.model.dto.LoginTotalDto;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.vo.LoginLogVo;
import com.wl.myshrio.service.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.wl.myshrio.generator.jooq.Tables.SYS_LOGIN_LOG;
import static com.wl.myshrio.generator.jooq.Tables.SYS_USER;

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
                set(SYS_LOGIN_LOG.ID, sysLoginLog.getId()).
                execute();
        log.error("插入访问数据：(1 代表success)" + execute);
    }

    @Override
    public Integer findVisitCountByUserId(String uid) {
        Integer record1 = dslContext.selectCount().
                from(SYS_LOGIN_LOG).
                where(SYS_LOGIN_LOG.UID.eq(uid)).
                fetchOne(0, Integer.class);
        log.error("record1 == " + record1);
//        int i = s + 1;
        return record1 + 1;
    }

    @Override
    public List<LoginTotalDto> findUserLoginTotal() {

        List<LoginLogVo> loignList = dslContext.select(Tables.SYS_USER.ID,
                Tables.SYS_USER.NICKNAME.as("userName"),
                DSL.max(SYS_LOGIN_LOG.LOGINTOTAL).as("loginTotal")).
                from(Tables.SYS_USER).
                innerJoin(SYS_LOGIN_LOG).on(SYS_LOGIN_LOG.UID.eq(Tables.SYS_USER.ID)).
                groupBy(SYS_USER.ID).
                fetch().
                into(LoginLogVo.class);

        String[] strName = new String[loignList.size()];
        int[] itotal = new int[loignList.size()];
        for (int i = 0, j = loignList.size(); i < j; i++) {
            strName[i] = loignList.get(i).getUserName();
            itotal[i] = loignList.get(i).getLoginTotal();
        }
        List<LoginTotalDto> listLoginTotal = new ArrayList<>();
        LoginTotalDto loginTotalDto = new LoginTotalDto();
        loginTotalDto.setName(strName);
        loginTotalDto.setTotal(itotal);
        listLoginTotal.add(loginTotalDto);
        return listLoginTotal;

    }

    @Override
    public List<LoginLogVo> findUserLoginLogByPage(ParamsDto dto) {

        List<LoginLogVo> vos;
        if (!StringUtils.isEmpty(dto.getKeyword())) {
            vos = dslContext.select(SYS_USER.ID,
                    SYS_LOGIN_LOG.LOGINIP,
                    SYS_USER.NICKNAME.as("userName"),
                    SYS_LOGIN_LOG.LOGINTIME).
                    from(SYS_LOGIN_LOG).
                    innerJoin(SYS_USER).on(SYS_USER.ID.eq(SYS_LOGIN_LOG.UID)).
                    where(SYS_USER.NICKNAME.like("%" + dto.getKeyword() + "%")).
                    limit(dto.getPageSize()).
                    offset(dto.getPageSize() * dto.getStartPage()).
                    fetch().
                    into(LoginLogVo.class);
        } else {
            vos = dslContext.select(SYS_USER.ID,
                    SYS_LOGIN_LOG.LOGINIP,
                    SYS_USER.NICKNAME.as("userName"),
                    SYS_LOGIN_LOG.LOGINTIME).
                    from(SYS_LOGIN_LOG).
                    innerJoin(SYS_USER).on(SYS_USER.ID.eq(SYS_LOGIN_LOG.UID)).
                    limit(dto.getPageSize()).
                    offset(dto.getPageSize() * dto.getStartPage()).
                    fetch().
                    into(LoginLogVo.class);
        }


        return vos;
    }

    @Override
    public Integer findUserLoginLogTotalByDto(ParamsDto dto) {
        Integer total;
        if (!StringUtils.isEmpty(dto.getKeyword())) {
            total = dslContext.selectCount().
                    from(SYS_LOGIN_LOG).
                    innerJoin(SYS_USER).on(SYS_USER.ID.eq(SYS_LOGIN_LOG.UID)).
                    where(SYS_USER.NICKNAME.like("%" + dto.getKeyword() + "%")).
                    fetchOne(0, Integer.class);
        } else {
            total = dslContext.selectCount().
                    from(SYS_LOGIN_LOG).
                    innerJoin(SYS_USER).on(SYS_USER.ID.eq(SYS_LOGIN_LOG.UID)).
                    fetchOne(0, Integer.class);
        }

        return total;
    }
}

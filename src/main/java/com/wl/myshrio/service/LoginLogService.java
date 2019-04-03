package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog;
import com.wl.myshrio.model.dto.LoginTotalDto;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.vo.LoginLogVo;

import java.util.List;

public interface LoginLogService {
    void insert(SysLoginLog sysLoginLog);

    Integer findVisitCountByUserId(String uid);

    Integer findUserLoginLogTotalByDto(ParamsDto dto);

    List<LoginTotalDto> findUserLoginTotal();

    List<LoginLogVo> findUserLoginLogByPage(ParamsDto dto);
}

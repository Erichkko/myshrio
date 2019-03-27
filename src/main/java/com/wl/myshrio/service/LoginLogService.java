package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog;

public interface LoginLogService {
    void insert(SysLoginLog sysLoginLog);

    Integer findVisitCountByUserId(String uid);
}

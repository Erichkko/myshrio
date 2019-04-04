package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.tables.daos.SysOperatingRecordDao;
import com.wl.myshrio.generator.jooq.tables.pojos.SysOperatingRecord;
import com.wl.myshrio.service.OperatingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperatingRecordServiceImpl implements OperatingRecordService {

    @Autowired
    SysOperatingRecordDao sysOperatingRecordDao;

    @Override
    public void insert(SysOperatingRecord or) {
        sysOperatingRecordDao.insert(or);
    }
}

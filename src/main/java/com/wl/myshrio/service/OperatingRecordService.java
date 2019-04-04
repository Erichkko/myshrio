package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysOperatingRecord;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.RequstOprDto;
import com.wl.myshrio.model.vo.OperatingRecordVo;

import java.util.List;

public interface OperatingRecordService {

    void  insert(SysOperatingRecord or);

    List<OperatingRecordVo> findOperatingRecordByPage(ParamsDto dto);

    Integer findOperatingRecordTotal(ParamsDto dto);

    List<RequstOprDto> findUserReqTotal();
}

package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysAttributeDetail;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.vo.AttributeDetailVo;

import java.util.List;

public interface AttributeDetailService {
    List<SysAttributeDetail> findAttributesDetailByPage(ParamsDto dto);
    Integer findAttributesDetailTotal(ParamsDto dto);
    Integer addAttributeDetail(AttributeDetailVo vo);
    Integer delAttributeDetails(ParamsDto dto);
    List<SysAttributeDetail> findAttributeDetailByAttrId(ParamsDto dto);

}

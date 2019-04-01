package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysAttribute;
import com.wl.myshrio.model.dto.ParamsDto;

import java.util.List;

public interface AttributeService {
    List<SysAttribute> findAttributesByPage(ParamsDto dto);
    Integer findAttributesTotal(ParamsDto dto);
    Integer addAttributes(SysAttribute attribute);
    Integer delAttributes(ParamsDto attribute);
}

package com.wl.myshrio.controller;


import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.generator.jooq.tables.pojos.SysAttribute;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.service.SysService;
import com.wl.myshrio.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "SysApi/v1")
public class SysController {

    @Autowired
    SysService sysService;
    @GetMapping(value = "findAttributesByPage")
    public String findAttributesByPage(ParamsDto dto){
        dto.setStartPage(dto.getStartPage() - 1);
        List<SysAttribute> list = sysService.findAttributesByPage(dto);
        Integer total = sysService.findAttributesTotal(dto);
        if (null == list || list.size() == 0) {
            return ResultUtil.result(EnumCode.DATA_NULL.getValue(), EnumCode.DATA_NULL.getText());
        }
        return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText(), JSON.toJSON(list),total);
    }
}

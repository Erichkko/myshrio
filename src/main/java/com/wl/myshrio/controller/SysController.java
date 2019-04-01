package com.wl.myshrio.controller;


import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.generator.jooq.tables.pojos.SysAttribute;
import com.wl.myshrio.generator.jooq.tables.pojos.SysAttributeDetail;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.vo.AttributeDetailVo;
import com.wl.myshrio.service.AttributeDetailService;
import com.wl.myshrio.service.AttributeService;
import com.wl.myshrio.service.SysService;
import com.wl.myshrio.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.management.snmp.jvmmib.EnumJvmClassesVerboseLevel;

import javax.xml.ws.Service;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "SysApi/v1")
public class SysController {

    @Autowired
    AttributeService attributeService;

    @Autowired
    AttributeDetailService attributeDetailService;


    @GetMapping(value = "/findAttributesByPage")
    public String findAttributesByPage(ParamsDto dto){
        dto.setStartPage(dto.getStartPage() - 1);
        List<SysAttribute> list = attributeService.findAttributesByPage(dto);
        Integer total = attributeService.findAttributesTotal(dto);
        if (null == list || list.size() == 0) {
            return ResultUtil.result(EnumCode.DATA_NULL.getValue(), EnumCode.DATA_NULL.getText());
        }
        return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText(), JSON.toJSON(list),total);
    }
    @PostMapping(value = "/addAttributes")
    public String addAttributes(SysAttribute attribute){

        Integer integer = attributeService.addAttributes(attribute);
        if (integer == 1){
            return  ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText());
        }else {
            return  ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),EnumCode.INTERNAL_SERVER_ERROR.getText());
        }

    }
    @PostMapping(value = "/delAttributes")
    public String delAttributes(ParamsDto dto){
        Integer integer = attributeService.delAttributes(dto);
        if (integer == 1){
            return  ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText());
        }else {
            return  ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),EnumCode.INTERNAL_SERVER_ERROR.getText());
        }
    }

    @GetMapping(value = "/findAttributesDetailByPage")
    public String findAttributesDetailByPage(ParamsDto dto){
        dto.setStartPage(dto.getStartPage()-1);
        List<SysAttributeDetail> attributesDetailByPage = attributeDetailService.findAttributesDetailByPage(dto);
        if (attributesDetailByPage != null && attributesDetailByPage.size()>0){
          return   ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText(),  JSON.toJSON(attributesDetailByPage),attributeDetailService.findAttributesDetailTotal(dto));
        }else {
           return ResultUtil.result(EnumCode.DATA_NULL.getValue(),EnumCode.DATA_NULL.getText());
        }

    }

    @PostMapping(value = "/addAttributeDetail")
    public String addAttributeDetail(AttributeDetailVo vo){

        Integer result = attributeDetailService.addAttributeDetail(vo);
        if (result == 1){
            return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText());

        }else {
            return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),EnumCode.INTERNAL_SERVER_ERROR.getText());

        }

    }

    @PostMapping(value = "/delAttributeDetails")
    public String delAttributeDetails(ParamsDto dto){
        Integer result = attributeDetailService.delAttributeDetails(dto);
        if (result == 1){
            return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText());

        }else {
            return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),EnumCode.INTERNAL_SERVER_ERROR.getText());

        }
    }
}

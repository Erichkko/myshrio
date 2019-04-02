package com.wl.myshrio.controller;


import com.alibaba.fastjson.JSON;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.generator.jooq.tables.pojos.SysPermission;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.PermisDto;
import com.wl.myshrio.model.vo.PermissionVo;
import com.wl.myshrio.service.PermisService;
import com.wl.myshrio.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "PermisApi/v1")
@RestController
public class PermisController {


    @Autowired
    PermisService permisService;

    @GetMapping(value = "/findBasePermission")
    public String findBasePermission(){

        List<PermisDto> list = permisService.findBasePermission();
        if (list != null&&list.size()>0){
            return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText(), JSON.toJSON(list));
        }else {
           return ResultUtil.result(EnumCode.DATA_NULL.getValue(),EnumCode.DATA_NULL.getText());
        }
    }

    @GetMapping(value = "/findPermissionByPage")
    public String findPermissionByPage(ParamsDto dto){
        dto.setStartPage(dto.getStartPage()-1);
        List<PermissionVo> list = permisService.findPermissionByPage(dto);
        if (list != null&&list.size()>0){
            return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText(), JSON.toJSON(list),permisService.findPermissionTotal(dto));
        }else {
            return ResultUtil.result(EnumCode.DATA_NULL.getValue(),EnumCode.DATA_NULL.getText());
        }
    }
    @GetMapping(value = "/findLastPermissionByType")
    public String findLastPermissionByType(String type){
        ParamsDto dto1 = new ParamsDto();
        dto1.setId(type);
        List<PermissionVo> voList = permisService.findLastPermissionByType(dto1);
        if (voList != null&&voList.size()>0){
            return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText(), JSON.toJSON(voList));
        }else {
            return ResultUtil.result(EnumCode.DATA_NULL.getValue(),EnumCode.DATA_NULL.getText());
        }
    }
}

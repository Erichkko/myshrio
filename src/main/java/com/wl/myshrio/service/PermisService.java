package com.wl.myshrio.service;

import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.PermisDto;
import com.wl.myshrio.model.vo.PermissionVo;

import java.util.List;

public interface PermisService {
    List<PermisDto> findBasePermission();

    List<PermissionVo> findPermissionByPage(ParamsDto dto);


    Integer findPermissionTotal(ParamsDto dto);
}

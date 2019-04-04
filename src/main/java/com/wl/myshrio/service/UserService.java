package com.wl.myshrio.service;

import com.wl.myshrio.generator.jooq.tables.pojos.SysUser;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.UserDto;
import com.wl.myshrio.model.dto.UserInfoDto;
import com.wl.myshrio.model.vo.UserVo;

import java.util.List;

public interface UserService {
    List<UserInfoDto> checkUser(String name,String pass);
    void updateById(SysUser user);
    List<UserDto> findUserByPage(ParamsDto dto);
    Integer findUserTotal(ParamsDto dto) ;
    Object addUser(UserVo userVo);
    Object editUserStatus(ParamsDto userVo);
    Object delUsers(ParamsDto userVo);
}

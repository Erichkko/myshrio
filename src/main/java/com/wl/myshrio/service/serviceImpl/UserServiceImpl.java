package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.generator.jooq.tables.pojos.SysUser;
import com.wl.myshrio.generator.jooq.tables.pojos.SysUserRole;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.UserDto;
import com.wl.myshrio.model.dto.UserInfoDto;
import com.wl.myshrio.model.vo.UserVo;
import com.wl.myshrio.service.UserService;
import com.wl.myshrio.utils.LocalDateUtil;
import com.wl.myshrio.utils.ResultUtil;
import com.wl.myshrio.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.wl.myshrio.generator.jooq.Tables.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DSLContext dslContext;


    @Override
    public List<UserInfoDto> checkUser(String name, String pass) {
        Result<Record9<String, String, Long, String, String, String, String, String, Integer>> fetch = dslContext
                .select(SYS_USER.ID,
                        SYS_USER.NICKNAME,
                        SYS_USER.STATUS,
                        SYS_USER.PSWD,
                        SYS_USER.HEAD_PORTRAITS,
                        SYS_USER.EMAIL,
                        SYS_USER_ROLE.RID,
                        SYS_ROLE.NAME,
                        SYS_ROLE.TYPE)
                .from(SYS_USER)
                .leftJoin(SYS_USER_ROLE).on(SYS_USER.ID.eq(SYS_USER_ROLE.UID))
                .innerJoin(SYS_ROLE).on(SYS_USER_ROLE.RID.eq(SYS_ROLE.ID))
                .where(SYS_USER.NICKNAME.eq(name), SYS_USER.PSWD.eq(pass)).fetch();
        List<UserInfoDto> userInfoDtos = new ArrayList<>();
        for (Record9 record9 : fetch) {
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId(record9.get(SYS_USER.ID));
            userInfoDto.setUsername(record9.get(SYS_USER.NICKNAME));
            userInfoDto.setPassword(record9.get(SYS_USER.PSWD));
            userInfoDto.setUserImg(record9.get(SYS_USER.HEAD_PORTRAITS));
            userInfoDto.setEmail(record9.get(SYS_USER.EMAIL));
            userInfoDto.setRoleid(record9.get(SYS_USER_ROLE.RID));
            userInfoDto.setRoleName(record9.get(SYS_ROLE.NAME));
            userInfoDto.setType(record9.get(SYS_ROLE.TYPE));
            userInfoDto.setState(record9.get(SYS_USER.STATUS) == 0L ? 0 : 1);
            userInfoDtos.add(userInfoDto);

        }


        return userInfoDtos;
    }

    @Override
    public void updateById(SysUser user) {
        int execute = dslContext
                .update(SYS_USER)
                .set(SYS_USER.LAST_LOGIN_TIME, user.getLastLoginTime())
                .where(SYS_USER.ID.eq(user.getId()))
                .execute();
        log.info("根据用户ID更新用户（1：更新success）" + execute);
    }

    @Override
    public List<UserDto> findUserByPage(ParamsDto dto) {
        List<UserDto> userDtos = new ArrayList<>();
        Result<Record10<String, String, String, String, Long, String, LocalDateTime, LocalDateTime, String, Integer>> fetch;

        if (StringUtils.isEmpty(dto.getKeyword())) {
            fetch = dslContext.select(SYS_USER.ID,
                    SYS_USER.EMAIL,
                    SYS_USER.HEAD_PORTRAITS,
                    SYS_USER.PSWD,
                    SYS_USER.STATUS,
                    SYS_USER.NICKNAME,
                    SYS_USER.LAST_LOGIN_TIME,
                    SYS_USER.CREATE_TIME,
                    SYS_ROLE.DESCRIPTION,
                    SYS_ROLE.TYPE
            ).
                    from(SYS_USER).
                    leftJoin(SYS_USER_ROLE).on(SYS_USER.ID.eq(SYS_USER_ROLE.UID)).
                    leftJoin(SYS_ROLE).on(SYS_USER_ROLE.RID.eq(SYS_ROLE.ID)).
                    where(SYS_ROLE.TYPE.eq(dto.getType())).
                    limit(dto.getPageSize()).
                    offset(dto.getStartPage()*dto.getPageSize()).
                    fetch();
        } else {
            fetch = dslContext.select(SYS_USER.ID,
                    SYS_USER.EMAIL,
                    SYS_USER.HEAD_PORTRAITS,
                    SYS_USER.PSWD,
                    SYS_USER.STATUS,
                    SYS_USER.NICKNAME,
                    SYS_USER.LAST_LOGIN_TIME,
                    SYS_USER.CREATE_TIME,
                    SYS_ROLE.DESCRIPTION,
                    SYS_ROLE.TYPE
            ).
                    from(SYS_USER).
                    leftJoin(SYS_USER_ROLE).on(SYS_USER.ID.eq(SYS_USER_ROLE.UID)).
                    leftJoin(SYS_ROLE).on(SYS_USER_ROLE.RID.eq(SYS_ROLE.ID)).
                    where(SYS_ROLE.TYPE.eq(dto.getType())).
                    and(SYS_USER.NICKNAME.like("%" + dto.getKeyword() + "%")).
                    limit(dto.getPageSize()).
                    offset(dto.getStartPage()*dto.getPageSize()).
                    fetch();
        }


        for (Record10 r : fetch) {
            UserDto dto1 = new UserDto();
            dto1.setEmail(r.get(SYS_USER.EMAIL));
            dto1.setCreateTime(LocalDateUtil.localDateTime2Date(r.get((Field<LocalDateTime>) SYS_USER.CREATE_TIME)));
            dto1.setId(r.get(SYS_USER.ID));
            dto1.setLastLoginTime(LocalDateUtil.localDateTime2Date(r.get((Field<LocalDateTime>) SYS_USER.LAST_LOGIN_TIME)));
            dto1.setRole(r.get(SYS_ROLE.DESCRIPTION));
            dto1.setStatus(r.get(SYS_USER.STATUS) == 0L ? 0 : 1);
            dto1.setState((r.get(SYS_USER.STATUS) == 0L ? "有效" : "禁止登陆"));
            dto1.setUserName(r.get(SYS_USER.NICKNAME));

            userDtos.add(dto1);

        }


        return userDtos;
    }

    @Override
    public Integer findUserTotal(ParamsDto dto) {

        Integer count;
        if (StringUtils.isEmpty(dto.getKeyword())) {
            count = dslContext.selectCount(
            ).
                    from(SYS_USER).
                    leftJoin(SYS_USER_ROLE).on(SYS_USER.ID.eq(SYS_USER_ROLE.UID)).
                    leftJoin(SYS_ROLE).on(SYS_USER_ROLE.RID.eq(SYS_ROLE.ID)).
                    where(SYS_ROLE.TYPE.eq(dto.getType())).
                    fetchOne(0, Integer.class);
        } else {
            count = dslContext.selectCount(
            ).
                    from(SYS_USER).
                    leftJoin(SYS_USER_ROLE).on(SYS_USER.ID.eq(SYS_USER_ROLE.UID)).
                    leftJoin(SYS_ROLE).on(SYS_USER_ROLE.RID.eq(SYS_ROLE.ID)).
                    where(SYS_ROLE.TYPE.eq(dto.getType()), SYS_USER.NICKNAME.like("%" + dto.getKeyword() + "%")).
                    fetchOne(0, Integer.class);
        }


        return count;
    }

    @Override
    public Object addUser(UserVo userVo) {
        try {
            SysUser sysUser = new SysUser();
            sysUser.setId(UUIDUtil.getUUID());
            sysUser.setLastLoginTime(LocalDateUtil.date2LocalDateTime(new Date()));
            sysUser.setCreateTime(sysUser.getLastLoginTime());
            sysUser.setEmail(userVo.getEmail());
            sysUser.setHeadPortraits("");
            sysUser.setNickname(userVo.getName());
            sysUser.setPswd(userVo.getPass());
            sysUser.setStatus(!userVo.getStatus() ? 0L : 1L);

            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setId(UUIDUtil.getUUID())
            ;
            sysUserRole.setUid(sysUser.getId());
            sysUserRole.setRid(userVo.getRole());

            int execute1 = dslContext.insertInto(SYS_USER)
                    .set(SYS_USER.ID, sysUser.getId())
                    .set(SYS_USER.STATUS, sysUser.getStatus())
                    .set(SYS_USER.LAST_LOGIN_TIME, sysUser.getLastLoginTime())
                    .set(SYS_USER.PSWD, sysUser.getPswd())
                    .set(SYS_USER.HEAD_PORTRAITS, sysUser.getHeadPortraits())
                    .set(SYS_USER.EMAIL, sysUser.getEmail())
                    .set(SYS_USER.CREATE_TIME, sysUser.getCreateTime())
                    .set(SYS_USER.NICKNAME, sysUser.getNickname()).execute();
            if (execute1 != 1){
                return ResultUtil.result(EnumCode.EXCPTION_ERROR.getValue(), EnumCode.EXCPTION_ERROR.getText());
            }

            int execute = dslContext.insertInto(SYS_USER_ROLE)
                    .set(SYS_USER_ROLE.ID, sysUserRole.getId())
                    .set(SYS_USER_ROLE.RID, sysUserRole.getRid())
                    .set(SYS_USER_ROLE.UID, sysUserRole.getUid()).execute();
            if (execute !=1){
                return ResultUtil.result(EnumCode.EXCPTION_ERROR.getValue(), EnumCode.EXCPTION_ERROR.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.result(EnumCode.EXCPTION_ERROR.getValue(), EnumCode.EXCPTION_ERROR.getText());
        }

        return ResultUtil.result(EnumCode.OK.getValue(), EnumCode.OK.getText());
    }

    @Override
    public Object editUserStatus(ParamsDto userVo) {

        int execute = dslContext.update(SYS_USER).set(SYS_USER.STATUS, userVo.getType() == 0 ? 0L : 1L)
                .where(SYS_USER.ID.eq(userVo.getId())).execute();

        if (execute == 1){
            return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText());
        }else {
            return ResultUtil.result(EnumCode.EXCPTION_ERROR.getValue(),EnumCode.EXCPTION_ERROR.getText());
        }
    }

    @Override
    public Object delUsers(ParamsDto userVo) {


        for (String id :
                userVo.getIds()) {
            dslContext.deleteFrom(SYS_USER).where(SYS_USER.ID.eq(id)).execute();
        }

        return ResultUtil.result(EnumCode.OK.getValue(),EnumCode.OK.getText());
    }
}

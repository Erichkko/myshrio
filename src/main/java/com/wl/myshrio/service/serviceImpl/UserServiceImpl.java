package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.tables.pojos.SysUser;
import com.wl.myshrio.model.dto.UserInfoDto;
import com.wl.myshrio.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record9;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        for (Record9 record9:fetch) {
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId( record9.get(SYS_USER.ID));
            userInfoDto.setRoleName(record9.get( SYS_USER.NICKNAME));
            userInfoDto.setPassword(record9.get( SYS_USER.PSWD));
            userInfoDto.setUserImg(record9.get( SYS_USER.HEAD_PORTRAITS));
            userInfoDto.setEmail(record9.get( SYS_USER.EMAIL));
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
                .set(SYS_USER.ID, user.getId())
                .set(SYS_USER.CREATE_TIME, user.getCreateTime())
                .set(SYS_USER.EMAIL, user.getEmail())
                .set(SYS_USER.HEAD_PORTRAITS, user.getHeadPortraits())
                .set(SYS_USER.LAST_LOGIN_TIME, user.getLastLoginTime())
                .set(SYS_USER.CREATE_TIME, user.getCreateTime())
                .set(SYS_USER.NICKNAME, user.getNickname())
                .set(SYS_USER.PSWD, user.getPswd())
                .set(SYS_USER.STATUS, user.getStatus())
                .where(SYS_USER.ID.eq(user.getId()))
                .execute();
        log.info("根据用户ID更新用户（1：更新success）"+execute);

    }
}

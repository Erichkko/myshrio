package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.pojos.SysPermission;
import com.wl.myshrio.model.dto.RolePermisDto;
import com.wl.myshrio.service.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    DSLContext dslContext;

    @Override
    public List<RolePermisDto> findRolesPermisByFatherId(String fatherId, String rid) {
        Result<Record4<String, String, String, String>> fetch;
        List<RolePermisDto> dtos = new ArrayList<>();
        if (StringUtils.isEmpty(fatherId)) {
            fetch = dslContext.select(
                    Tables.SYS_PERMISSION.ID,
                    Tables.SYS_PERMISSION.ICONCLS,
                    Tables.SYS_PERMISSION.NAME,
                    Tables.SYS_PERMISSION.URL
            ).
                    from(Tables.SYS_PERMISSION).
                    where(Tables.SYS_PERMISSION.FATHERID.eq(0 + "")).
                    fetch();
        } else {
            if (rid == null) {
                fetch = dslContext.select(
                        Tables.SYS_PERMISSION.ID,
                        Tables.SYS_PERMISSION.ICONCLS,
                        Tables.SYS_PERMISSION.NAME,
                        Tables.SYS_PERMISSION.URL
                ).
                        from(Tables.SYS_ROLE_PERMISSION).
                        rightJoin(Tables.SYS_PERMISSION).
                        on(Tables.SYS_ROLE_PERMISSION.PID.eq(Tables.SYS_PERMISSION.ID)).
                        where(Tables.SYS_PERMISSION.FATHERID.eq(fatherId)).
                        fetch();

            } else {
                fetch = dslContext.select(
                        Tables.SYS_PERMISSION.ID,
                        Tables.SYS_PERMISSION.ICONCLS,
                        Tables.SYS_PERMISSION.NAME,
                        Tables.SYS_PERMISSION.URL
                ).
                        from(Tables.SYS_PERMISSION).
                        rightJoin(Tables.SYS_ROLE_PERMISSION).
                        on(Tables.SYS_ROLE_PERMISSION.PID.eq(Tables.SYS_PERMISSION.ID)).
                        where(Tables.SYS_PERMISSION.FATHERID.eq(fatherId), Tables.SYS_ROLE_PERMISSION.RID.eq(rid)).
                        fetch();
            }

        }

        for (int i = 0; i < fetch.size(); i++) {
            Record4<String, String, String, String> r4 = fetch.get(i);
            RolePermisDto dto = new RolePermisDto();
            dto.setId((String) r4.get(0));
            dto.setIconCls(r4.get(Tables.SYS_PERMISSION.ICONCLS));
            dto.setName(r4.get(Tables.SYS_PERMISSION.NAME));
            dto.setUrl(r4.get(Tables.SYS_PERMISSION.URL));
            dtos.add(dto);
        }

        return dtos;
    }
}
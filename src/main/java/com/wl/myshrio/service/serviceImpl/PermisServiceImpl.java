package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.daos.SysPermissionDao;
import com.wl.myshrio.generator.jooq.tables.pojos.SysPermission;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.PermisDto;
import com.wl.myshrio.model.vo.PermissionVo;
import com.wl.myshrio.service.PermisService;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermisServiceImpl implements PermisService {

    @Autowired
    SysPermissionDao sysPermissionDao;

    @Autowired
    DSLContext dslContext;


    @Override
    public List<PermisDto> findBasePermission() {
        ArrayList<PermisDto> permisDtos = new ArrayList<>();


        List<SysPermission> permissions = sysPermissionDao.fetchByFatherid(0 + "");
        if (permissions != null && permissions.size() > 0) {
            for (SysPermission s : permissions) {
                PermisDto dto = new PermisDto();
                dto.setId(s.getId());
                dto.setName(s.getName());
                ArrayList<PermisDto> sonPermisDtos = new ArrayList<>();
                List<SysPermission> sonPermissions = sysPermissionDao.fetchByFatherid(s.getId());
                if (sonPermissions != null && sonPermissions.size() > 0) {
                    for (SysPermission s1 : sonPermissions) {
                        PermisDto dto1 = new PermisDto();
                        dto1.setId(s1.getId());
                        dto1.setName(s1.getName());

                        List<SysPermission> sonSonPermissions = sysPermissionDao.fetchByFatherid(s1.getId());
                        ArrayList<PermisDto> sonSonPermisDtos = new ArrayList<>();
                        if (sonSonPermissions != null && sonSonPermissions.size() > 0) {
                            for (SysPermission s2 : sonSonPermissions) {
                                PermisDto dto2 = new PermisDto();
                                dto2.setId(s2.getId());
                                dto2.setName(s2.getName());
                                sonSonPermisDtos.add(dto2);
                            }
                        }
                        dto1.setChildren(sonSonPermisDtos);
                        sonPermisDtos.add(dto1);
                    }
                }
                dto.setChildren(sonPermisDtos);
                permisDtos.add(dto);

            }
        }
        return permisDtos;
    }

    @Override
    public List<PermissionVo> findPermissionByPage(ParamsDto dto) {
        List<PermissionVo> into = null;
        if (!StringUtils.isEmpty(dto.getKeyword())) {
            into = dslContext.select(
                    DSL.field(DSL.name("A", Tables.SYS_PERMISSION.URL.getName())),
                    DSL.field(DSL.name("A", Tables.SYS_PERMISSION.ID.getName())),
                    DSL.field(DSL.name("A", Tables.SYS_PERMISSION.NAME.getName())),
                    DSL.field(DSL.name("B", Tables.SYS_PERMISSION.NAME.getName())).as("lastPermis"),
                    Tables.SYS_ATTRIBUTE_DETAIL.NAME.as("typeName")).
                    from(Tables.SYS_PERMISSION.as("A")).
                    leftJoin(Tables.SYS_PERMISSION.as("B")).on("B.id = A.fatherId").
                    leftJoin(Tables.SYS_ATTRIBUTE_DETAIL).on("sys_attribute_detail.id = A.type").
                    where(DSL.field(DSL.name("A", Tables.SYS_PERMISSION.NAME.getName())).like("%" + dto.getKeyword() + "%")).
                    limit(dto.getPageSize()).
                    offset(dto.getPageSize() * dto.getStartPage()).
                    fetch().
                    into(PermissionVo.class);


        } else {
            into = dslContext.select(
                    DSL.field(DSL.name("A", Tables.SYS_PERMISSION.URL.getName())),
                    DSL.field(DSL.name("A", Tables.SYS_PERMISSION.ID.getName())),
                    DSL.field(DSL.name("A", Tables.SYS_PERMISSION.NAME.getName())),
                    DSL.field(DSL.name("B", Tables.SYS_PERMISSION.NAME.getName())).as("lastPermis"),
                    Tables.SYS_ATTRIBUTE_DETAIL.NAME.as("typeName")).
                    from(Tables.SYS_PERMISSION.as("A")).
                    leftJoin(Tables.SYS_PERMISSION.as("B")).on("B.id = A.fatherId").
                    leftJoin(Tables.SYS_ATTRIBUTE_DETAIL).on("sys_attribute_detail.id = A.type").
                    limit(dto.getPageSize()).
                    offset(dto.getPageSize() * dto.getStartPage()).
                    fetch().
                    into(PermissionVo.class);


        }
        return into;
    }

    @Override
    public Integer findPermissionTotal(ParamsDto dto) {
        Integer total = 0;
        if (!StringUtils.isEmpty(dto.getKeyword())) {
            total = dslContext.select().
                    from(Tables.SYS_PERMISSION).
                    where(Tables.SYS_PERMISSION.NAME.like("%" + dto.getKeyword() + "%")).
                    fetch().
                    into(SysPermission.class).size();
        } else {
            total = dslContext.select().
                    from(Tables.SYS_PERMISSION).
                    fetch().
                    into(SysPermission.class).size();
        }
        return total;
    }

    @Override
    public List<PermissionVo> findLastPermissionByType(ParamsDto dto) {

        List<PermissionVo> list = dslContext.select(Tables.SYS_PERMISSION.NAME,Tables.SYS_PERMISSION.ID).
                from(Tables.SYS_PERMISSION).
                where(Tables.SYS_PERMISSION.TYPE.eq(dto.getId())).
                fetch().
                into(PermissionVo.class);



        return list;
    }
}

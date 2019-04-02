package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.daos.SysRoleDao;
import com.wl.myshrio.generator.jooq.tables.pojos.SysRole;
import com.wl.myshrio.generator.jooq.tables.pojos.SysRolePermission;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.service.RoleService;
import com.wl.myshrio.utils.UUIDUtil;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.plugin.util.UIUtil;
import sun.tools.jconsole.Tab;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    DSLContext dslContext;

    @Autowired
    SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAllRoles() {
        List<SysRole> into = sysRoleDao.findAll();
        return into;
    }

    @Override
    public List<SysRole> findRoleByPage(ParamsDto dto) {
        List<SysRole> into ;
        if (StringUtils.isEmpty(dto.getKeyword())){
            into = dslContext.select().
                    from(Tables.SYS_ROLE).
                    limit(dto.getPageSize()).
                    offset(dto.getStartPage() * dto.getPageSize()).
                    fetch().
                    into(SysRole.class);
        }else {
            into = dslContext.select().
                    from(Tables.SYS_ROLE).
                    where(Tables.SYS_ROLE.NAME.like("%"+dto.getKeyword()+"%")).
                    limit(dto.getPageSize()).
                    offset(dto.getStartPage() * dto.getPageSize()).
                    fetch().
                    into(SysRole.class);
        }

        return into;
    }

    @Override
    public Integer findRoleTotal(ParamsDto dto) {
        Integer total = 0;
        if (StringUtils.isEmpty(dto.getKeyword())){
            total = sysRoleDao.findAll().size();
        }else {
            total = dslContext.selectCount().
                    from(Tables.SYS_ROLE).
                    where(Tables.SYS_ROLE.NAME.like("%"+dto.getKeyword()+"%")).
                    fetchOne(0,Integer.class);
        }
        return total;
    }

    @Override
    public Integer addRoles(SysRole role) {
        role.setType(2);
        role.setId(UUIDUtil.getUUID());

        Integer flag = 0;
        try {
            sysRoleDao.insert(role);
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public Integer delRoles(ParamsDto dto) {
        Integer flag = 0;

        try {
            sysRoleDao.deleteById(dto.getIds());
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


}

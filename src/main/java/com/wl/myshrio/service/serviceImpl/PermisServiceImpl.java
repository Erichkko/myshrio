package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.tables.daos.SysPermissionDao;
import com.wl.myshrio.generator.jooq.tables.pojos.SysPermission;
import com.wl.myshrio.model.dto.PermisDto;
import com.wl.myshrio.service.PermisService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        List<SysPermission> permissions = sysPermissionDao.fetchByFatherid(0+"");
        if (permissions != null && permissions.size()>0){
            for (SysPermission s : permissions) {
                PermisDto dto = new PermisDto();
                dto.setId(s.getId());
                dto.setName(s.getName());
                ArrayList<PermisDto> sonPermisDtos = new ArrayList<>();
                List<SysPermission> sonPermissions = sysPermissionDao.fetchByFatherid(s.getId());
                if (sonPermissions != null && sonPermissions.size()>0){
                    for (SysPermission s1 : sonPermissions) {
                        PermisDto dto1 = new PermisDto();
                        dto1.setId(s1.getId());
                        dto1.setName(s1.getName());

                        List<SysPermission> sonSonPermissions = sysPermissionDao.fetchByFatherid(s1.getId());
                        ArrayList<PermisDto> sonSonPermisDtos = new ArrayList<>();
                        if (sonSonPermissions !=null&&sonSonPermissions.size()>0){
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
}

package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.daos.SysAttributeDao;
import com.wl.myshrio.generator.jooq.tables.pojos.SysAttribute;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.service.AttributeService;
import com.wl.myshrio.utils.UUIDUtil;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    DSLContext dslContext;

    @Autowired
    SysAttributeDao sysAttributeDao;
    @Override
    public List<SysAttribute> findAttributesByPage(ParamsDto dto) {

        List<SysAttribute> into;
        if (StringUtils.isEmpty(dto.getKeyword())){
            into= dslContext.select().
                    from(Tables.SYS_ATTRIBUTE).
                    limit(dto.getPageSize()).
                    offset(dto.getStartPage()).
                    fetch().
                    into(SysAttribute.class);
        }else {
            into = dslContext.select().
                    from(Tables.SYS_ATTRIBUTE).
                    where(Tables.SYS_ATTRIBUTE.NAME.like("%"+dto.getKeyword()+"%")).
                    limit(dto.getPageSize()).
                    offset(dto.getStartPage()).
                    fetch().
                    into(SysAttribute.class);
        }

        return into;
    }

    @Override
    public Integer findAttributesTotal(ParamsDto dto) {
        Integer count ;
        if (StringUtils.isEmpty(dto.getKeyword())){
            count = dslContext.selectCount().from(Tables.SYS_ATTRIBUTE).fetchOne(0,Integer.class);
        }else {
            count = dslContext.selectCount()
                    .from(Tables.SYS_ATTRIBUTE).
                            where(Tables.SYS_ATTRIBUTE.NAME.like("%"+dto.getKeyword()+"%")).
                            fetchOne(0,Integer.class);
        }
        return count;
    }

    @Override
    public Integer addAttributes(SysAttribute attribute) {

        attribute.setId(UUIDUtil.getUUID());
//        int execute = dslContext.insertInto(Tables.SYS_ATTRIBUTE).set(Tables.SYS_ATTRIBUTE.ID, attribute.getId()).
//                set(Tables.SYS_ATTRIBUTE.NAME, attribute.getName()).execute();
        int execute = 0;

        try {
            sysAttributeDao.insert(attribute);
            execute = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public Integer delAttributes(ParamsDto dto) {
        int flag = 0;
        try {
            sysAttributeDao.deleteById(dto.getIds());
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

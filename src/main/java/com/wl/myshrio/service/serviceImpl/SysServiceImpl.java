package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.pojos.SysAttribute;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.service.SysService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Slf4j
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    DSLContext dslContext;
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
}
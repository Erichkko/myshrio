package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.daos.SysAttributeDetailDao;
import com.wl.myshrio.generator.jooq.tables.pojos.SysAttributeDetail;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.vo.AttributeDetailVo;
import com.wl.myshrio.service.AttributeDetailService;
import com.wl.myshrio.utils.UUIDUtil;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttributeDetailServiceImpl implements AttributeDetailService {

    @Autowired
    SysAttributeDetailDao sysAttributeDetailDao;

    @Autowired
    DSLContext dslContext;

    @Override
    public List<SysAttributeDetail> findAttributesDetailByPage(ParamsDto dto) {
//        sysAttributeDetailDao.fetchByAttrid(dto.getId()).
        List<SysAttributeDetail> datas = dslContext.select().from(Tables.SYS_ATTRIBUTE_DETAIL).where(Tables.SYS_ATTRIBUTE_DETAIL.ATTRID.eq(dto.getId())).
                limit(dto.getPageSize()).
                offset(dto.getStartPage()*dto.getPageSize()).
                fetch().
                into(SysAttributeDetail.class);
        return datas;
    }

    @Override
    public Integer findAttributesDetailTotal(ParamsDto dto) {
        return sysAttributeDetailDao.fetchByAttrid(dto.getId()).size();
    }

    @Override
    public Integer addAttributeDetail(AttributeDetailVo vo) {
        SysAttributeDetail sysAttributeDetail = new SysAttributeDetail();
        sysAttributeDetail.setAttrid(vo.getId());
        sysAttributeDetail.setId(UUIDUtil.getUUID());
        sysAttributeDetail.setName(vo.getName());
        Integer flag = 0;
        try {
            sysAttributeDetailDao.insert(sysAttributeDetail);
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public Integer delAttributeDetails(ParamsDto dto) {
        Integer flag = 0;
        try {
            sysAttributeDetailDao.deleteById(dto.getIds());
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<SysAttributeDetail> findAttributeDetailByAttrId(ParamsDto dto) {
        List<SysAttributeDetail> sysAttributeDetails = sysAttributeDetailDao.fetchByAttrid(dto.getId());
        return sysAttributeDetails;
    }
}

package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.Tables;
import com.wl.myshrio.generator.jooq.tables.daos.SysOperatingRecordDao;
import com.wl.myshrio.generator.jooq.tables.pojos.SysOperatingRecord;
import com.wl.myshrio.model.dto.OperatingRecordDto;
import com.wl.myshrio.model.dto.ParamsDto;
import com.wl.myshrio.model.dto.ReqTotalDto;
import com.wl.myshrio.model.dto.RequstOprDto;
import com.wl.myshrio.model.vo.OperatingRecordVo;
import com.wl.myshrio.service.OperatingRecordService;
import net.sf.ehcache.search.aggregator.Count;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Select;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class OperatingRecordServiceImpl implements OperatingRecordService {

    @Autowired
    SysOperatingRecordDao sysOperatingRecordDao;

    @Autowired
    DSLContext dslContext;

    @Override
    public void insert(SysOperatingRecord or) {
        sysOperatingRecordDao.insert(or);
    }

    @Override
    public List<OperatingRecordVo> findOperatingRecordByPage(ParamsDto dto) {
        List<OperatingRecordVo> list;
        if (StringUtils.isEmpty(dto.getKeyword())) {
            list = dslContext.select(
                    Tables.SYS_OPERATING_RECORD.ID,
                    Tables.SYS_OPERATING_RECORD.REQUESTURL.as("permName"),
                    Tables.SYS_OPERATING_RECORD.REMOTEADDR.as("remoteAddr"),
                    Tables.SYS_OPERATING_RECORD.METHOD.as("method"),
                    Tables.SYS_OPERATING_RECORD.PARAMS.as("params"),
                    Tables.SYS_OPERATING_RECORD.CREATE_TIME.as("createTime"),
                    Tables.SYS_OPERATING_RECORD.FLAG.as("flag"),
                    Tables.SYS_USER.NICKNAME.as("userName")
            ).
                    from(Tables.SYS_OPERATING_RECORD).
                    leftJoin(Tables.SYS_USER).on(Tables.SYS_USER.ID.eq(Tables.SYS_OPERATING_RECORD.UID)).
                    limit(dto.getPageSize()).
                    offset(dto.getPageSize() * dto.getStartPage()).
                    fetch().
                    into(OperatingRecordVo.class);
        } else {
            list = dslContext.select(
                    Tables.SYS_OPERATING_RECORD.ID,
                    Tables.SYS_OPERATING_RECORD.REQUESTURL.as("permName"),
                    Tables.SYS_OPERATING_RECORD.REMOTEADDR.as("remoteAddr"),
                    Tables.SYS_OPERATING_RECORD.METHOD.as("method"),
                    Tables.SYS_OPERATING_RECORD.PARAMS.as("params"),
                    Tables.SYS_OPERATING_RECORD.CREATE_TIME.as("createTime"),
                    Tables.SYS_OPERATING_RECORD.FLAG.as("flag"),
                    Tables.SYS_USER.NICKNAME.as("userName")


            ).
                    from(Tables.SYS_OPERATING_RECORD).
                    leftJoin(Tables.SYS_USER).on(Tables.SYS_USER.ID.eq(Tables.SYS_OPERATING_RECORD.UID)).
                    where(Tables.SYS_OPERATING_RECORD.REQUESTURL.like("%" + dto.getKeyword() + "%")).
                    limit(dto.getPageSize()).
                    offset(dto.getPageSize() * dto.getStartPage()).
                    fetch().
                    into(OperatingRecordVo.class);
        }
        return list;
    }

    @Override
    public Integer findOperatingRecordTotal(ParamsDto dto) {
        Integer total;
        if (StringUtils.isEmpty(dto.getKeyword())) {
            total = dslContext.selectCount().
                    from(Tables.SYS_OPERATING_RECORD).
                    fetchOne(0, Integer.class);
        } else {
            total = dslContext.selectCount().
                    from(Tables.SYS_OPERATING_RECORD).
                    where(Tables.SYS_OPERATING_RECORD.REQUESTURL.like("%" + dto.getKeyword() + "%")).
                    fetchOne(0, Integer.class);
        }
        return total;
    }



    @Override
    public List<RequstOprDto> findUserReqTotal() {

        List<ReqTotalDto> reqList = dslContext.select(Tables.SYS_OPERATING_RECORD.METHOD.as("Na"),
                DSL.count().as("total"),
                DSL.field("1").as("type")).
                from(Tables.SYS_OPERATING_RECORD).
                groupBy(Tables.SYS_OPERATING_RECORD.METHOD).
                unionAll(dslContext.select(Tables.SYS_USER.NICKNAME.as("Na"),
                        DSL.count().as("total"),
                        DSL.field("2").as("type")).
                                from(Tables.SYS_OPERATING_RECORD).
                                innerJoin(Tables.SYS_USER).on(Tables.SYS_USER.ID.eq(Tables.SYS_OPERATING_RECORD.UID)).
                                groupBy(Tables.SYS_USER.NICKNAME)
                                .
                unionAll(
                        dslContext.select(
                                Tables.SYS_OPERATING_RECORD.UID.as("Na"),
                DSL.count(),
                DSL.field("2").as("type")).
                from(Tables.SYS_OPERATING_RECORD).
                where(
                        Tables.SYS_OPERATING_RECORD.UID.isNull()).
                                or(Tables.SYS_OPERATING_RECORD.UID.
                                        notIn(
                                                dslContext.select(Tables.SYS_USER.ID).from(Tables.SYS_USER)
                                        )
                                ).groupBy(Tables.SYS_OPERATING_RECORD.UID)
                )
                ).
                fetch().
                into(ReqTotalDto.class);

        List<RequstOprDto> reqData1 = new ArrayList<>();
        List<RequstOprDto> reqData2 = new ArrayList<>();
        String[] arrNa = new String[reqList.size()];
        RequstOprDto reo = null;
        for (int i = 0, j = reqList.size(); i < j; i++) {
            if (reqList.get(i).getType().equals(1)) {
                // Method
                reo = new RequstOprDto();
                reo.setName(reqList.get(i).getNa());
                reo.setValue(reqList.get(i).getTotal());
                reqData1.add(reo);
            } else {
                // 源
                reo = new RequstOprDto();
                reo.setName(reqList.get(i).getNa());
                reo.setValue(reqList.get(i).getTotal());
                reqData2.add(reo);
            }
            arrNa[i] = reqList.get(i).getNa();
        }

        RequstOprDto r = new RequstOprDto();
        List<RequstOprDto> reqData3 = new ArrayList<>();
        r.setMetlist((ArrayList) reqData1);
        r.setUsrlist((ArrayList) reqData2);
        r.setArrName(arrNa);
        reqData3.add(r);
        return reqData3;
    }
}

package com.zzp.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.provider.entity.TQuoteLogisticsTransport;
import com.zzp.provider.mapper.TQuoteLogisticsTransportMapper;
import com.zzp.provider.service.ITQuoteLogisticsTransportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzp
 * @since 2020-06-23
 */
@Service
public class TQuoteLogisticsTransportServiceImpl extends ServiceImpl<TQuoteLogisticsTransportMapper, TQuoteLogisticsTransport> implements ITQuoteLogisticsTransportService {

    @Autowired
    private TQuoteLogisticsTransportMapper quoteLogisticsTransportMapper;

    @Override
    public List<TQuoteLogisticsTransport> listQuoteLogisticsTransports(String quoterCompanyCode) {
        return quoteLogisticsTransportMapper.listQuoteLogisticsTransports(quoterCompanyCode);
    }
}

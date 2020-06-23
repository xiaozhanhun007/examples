package com.zzp.provider.service.impl;

import com.zzp.provider.entity.TLSResult;
import com.zzp.provider.mapper.TLSResultMapper;
import com.zzp.provider.service.ITLSResultService;
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
public class TLSResultServiceImpl extends ServiceImpl<TLSResultMapper, TLSResult> implements ITLSResultService {

    @Autowired
    private TLSResultMapper lsResultMapper;

    @Override
    public List<TLSResult> listSIds(String inquirerCompanyUid, String quoteSupplierTransportIdArray) {
        return lsResultMapper.listSIds(inquirerCompanyUid, quoteSupplierTransportIdArray);
    }
}

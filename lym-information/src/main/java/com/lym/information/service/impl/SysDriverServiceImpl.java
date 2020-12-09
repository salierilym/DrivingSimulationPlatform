package com.lym.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lym.information.mapper.SysDriverMapper;
import com.lym.information.domain.SysDriver;
import com.lym.information.service.ISysDriverService;

/**
 * 驾驶员Service业务层处理
 *
 * @author lym
 * @date 2020-12-09
 */
@Service
public class SysDriverServiceImpl implements ISysDriverService
{
    @Autowired
    private SysDriverMapper sysDriverMapper;

    /**
     * 查询驾驶员
     *
     * @param id 驾驶员ID
     * @return 驾驶员
     */
    @Override
    public SysDriver selectSysDriverById(Long id)
    {
        return sysDriverMapper.selectSysDriverById(id);
    }

    /**
     * 查询驾驶员列表
     *
     * @param sysDriver 驾驶员
     * @return 驾驶员
     */
    @Override
    public List<SysDriver> selectSysDriverList(SysDriver sysDriver)
    {
        return sysDriverMapper.selectSysDriverList(sysDriver);
    }

    /**
     * 新增驾驶员
     *
     * @param sysDriver 驾驶员
     * @return 结果
     */
    @Override
    public int insertSysDriver(SysDriver sysDriver)
    {
        return sysDriverMapper.insertSysDriver(sysDriver);
    }

    /**
     * 修改驾驶员
     *
     * @param sysDriver 驾驶员
     * @return 结果
     */
    @Override
    public int updateSysDriver(SysDriver sysDriver)
    {
        return sysDriverMapper.updateSysDriver(sysDriver);
    }

    /**
     * 批量删除驾驶员
     *
     * @param ids 需要删除的驾驶员ID
     * @return 结果
     */
    @Override
    public int deleteSysDriverByIds(Long[] ids)
    {
        return sysDriverMapper.deleteSysDriverByIds(ids);
    }

    /**
     * 删除驾驶员信息
     *
     * @param id 驾驶员ID
     * @return 结果
     */
    @Override
    public int deleteSysDriverById(Long id)
    {
        return sysDriverMapper.deleteSysDriverById(id);
    }
}

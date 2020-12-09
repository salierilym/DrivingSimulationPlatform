package com.lym.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lym.data.mapper.SysSimulationdataMapper;
import com.lym.data.domain.SysSimulationdata;
import com.lym.data.service.ISysSimulationdataService;

/**
 * 驾驶数据Service业务层处理
 *
 * @author lym
 * @date 2020-12-07
 */
@Service
public class SysSimulationdataServiceImpl implements ISysSimulationdataService
{
    @Autowired
    private SysSimulationdataMapper sysSimulationdataMapper;

    /**
     * 查询驾驶数据
     *
     * @param id 驾驶数据ID
     * @return 驾驶数据
     */
    @Override
    public SysSimulationdata selectSysSimulationdataById(Long id)
    {
        return sysSimulationdataMapper.selectSysSimulationdataById(id);
    }

    /**
     * 查询驾驶数据列表
     *
     * @param sysSimulationdata 驾驶数据
     * @return 驾驶数据
     */
    @Override
    public List<SysSimulationdata> selectSysSimulationdataList(SysSimulationdata sysSimulationdata)
    {
        return sysSimulationdataMapper.selectSysSimulationdataList(sysSimulationdata);
    }

    /**
     * 新增驾驶数据
     *
     * @param sysSimulationdata 驾驶数据
     * @return 结果
     */
    @Override
    public int insertSysSimulationdata(SysSimulationdata sysSimulationdata)
    {
        return sysSimulationdataMapper.insertSysSimulationdata(sysSimulationdata);
    }

    /**
     * 修改驾驶数据
     *
     * @param sysSimulationdata 驾驶数据
     * @return 结果
     */
    @Override
    public int updateSysSimulationdata(SysSimulationdata sysSimulationdata)
    {
        return sysSimulationdataMapper.updateSysSimulationdata(sysSimulationdata);
    }

    /**
     * 批量删除驾驶数据
     *
     * @param ids 需要删除的驾驶数据ID
     * @return 结果
     */
    @Override
    public int deleteSysSimulationdataByIds(Long[] ids)
    {
        return sysSimulationdataMapper.deleteSysSimulationdataByIds(ids);
    }

    /**
     * 删除驾驶数据信息
     *
     * @param id 驾驶数据ID
     * @return 结果
     */
    @Override
    public int deleteSysSimulationdataById(Long id)
    {
        return sysSimulationdataMapper.deleteSysSimulationdataById(id);
    }
}

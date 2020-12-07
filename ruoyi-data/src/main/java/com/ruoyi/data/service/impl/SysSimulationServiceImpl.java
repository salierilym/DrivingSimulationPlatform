package com.ruoyi.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.data.mapper.SysSimulationMapper;
import com.ruoyi.data.domain.SysSimulation;
import com.ruoyi.data.service.ISysSimulationService;

/**
 * 驾驶实验Service业务层处理
 * 
 * @author lym
 * @date 2020-12-07
 */
@Service
public class SysSimulationServiceImpl implements ISysSimulationService 
{
    @Autowired
    private SysSimulationMapper sysSimulationMapper;

    /**
     * 查询驾驶实验
     * 
     * @param id 驾驶实验ID
     * @return 驾驶实验
     */
    @Override
    public SysSimulation selectSysSimulationById(Long id)
    {
        return sysSimulationMapper.selectSysSimulationById(id);
    }

    /**
     * 查询驾驶实验列表
     * 
     * @param sysSimulation 驾驶实验
     * @return 驾驶实验
     */
    @Override
    public List<SysSimulation> selectSysSimulationList(SysSimulation sysSimulation)
    {
        return sysSimulationMapper.selectSysSimulationList(sysSimulation);
    }

    /**
     * 新增驾驶实验
     * 
     * @param sysSimulation 驾驶实验
     * @return 结果
     */
    @Override
    public int insertSysSimulation(SysSimulation sysSimulation)
    {
        return sysSimulationMapper.insertSysSimulation(sysSimulation);
    }

    /**
     * 修改驾驶实验
     * 
     * @param sysSimulation 驾驶实验
     * @return 结果
     */
    @Override
    public int updateSysSimulation(SysSimulation sysSimulation)
    {
        return sysSimulationMapper.updateSysSimulation(sysSimulation);
    }

    /**
     * 批量删除驾驶实验
     * 
     * @param ids 需要删除的驾驶实验ID
     * @return 结果
     */
    @Override
    public int deleteSysSimulationByIds(Long[] ids)
    {
        return sysSimulationMapper.deleteSysSimulationByIds(ids);
    }

    /**
     * 删除驾驶实验信息
     * 
     * @param id 驾驶实验ID
     * @return 结果
     */
    @Override
    public int deleteSysSimulationById(Long id)
    {
        return sysSimulationMapper.deleteSysSimulationById(id);
    }
}

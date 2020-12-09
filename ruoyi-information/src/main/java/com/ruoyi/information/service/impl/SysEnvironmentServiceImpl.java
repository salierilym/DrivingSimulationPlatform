package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.SysEnvironmentMapper;
import com.ruoyi.information.domain.SysEnvironment;
import com.ruoyi.information.service.ISysEnvironmentService;

/**
 * 实验环境Service业务层处理
 * 
 * @author lym
 * @date 2020-12-09
 */
@Service
public class SysEnvironmentServiceImpl implements ISysEnvironmentService 
{
    @Autowired
    private SysEnvironmentMapper sysEnvironmentMapper;

    /**
     * 查询实验环境
     * 
     * @param id 实验环境ID
     * @return 实验环境
     */
    @Override
    public SysEnvironment selectSysEnvironmentById(Long id)
    {
        return sysEnvironmentMapper.selectSysEnvironmentById(id);
    }

    /**
     * 查询实验环境列表
     * 
     * @param sysEnvironment 实验环境
     * @return 实验环境
     */
    @Override
    public List<SysEnvironment> selectSysEnvironmentList(SysEnvironment sysEnvironment)
    {
        return sysEnvironmentMapper.selectSysEnvironmentList(sysEnvironment);
    }

    /**
     * 新增实验环境
     * 
     * @param sysEnvironment 实验环境
     * @return 结果
     */
    @Override
    public int insertSysEnvironment(SysEnvironment sysEnvironment)
    {
        return sysEnvironmentMapper.insertSysEnvironment(sysEnvironment);
    }

    /**
     * 修改实验环境
     * 
     * @param sysEnvironment 实验环境
     * @return 结果
     */
    @Override
    public int updateSysEnvironment(SysEnvironment sysEnvironment)
    {
        return sysEnvironmentMapper.updateSysEnvironment(sysEnvironment);
    }

    /**
     * 批量删除实验环境
     * 
     * @param ids 需要删除的实验环境ID
     * @return 结果
     */
    @Override
    public int deleteSysEnvironmentByIds(Long[] ids)
    {
        return sysEnvironmentMapper.deleteSysEnvironmentByIds(ids);
    }

    /**
     * 删除实验环境信息
     * 
     * @param id 实验环境ID
     * @return 结果
     */
    @Override
    public int deleteSysEnvironmentById(Long id)
    {
        return sysEnvironmentMapper.deleteSysEnvironmentById(id);
    }
}

package com.ruoyi.information.mapper;

import java.util.List;
import com.ruoyi.information.domain.SysEnvironment;

/**
 * 实验环境Mapper接口
 * 
 * @author lym
 * @date 2020-12-09
 */
public interface SysEnvironmentMapper 
{
    /**
     * 查询实验环境
     * 
     * @param id 实验环境ID
     * @return 实验环境
     */
    public SysEnvironment selectSysEnvironmentById(Long id);

    /**
     * 查询实验环境列表
     * 
     * @param sysEnvironment 实验环境
     * @return 实验环境集合
     */
    public List<SysEnvironment> selectSysEnvironmentList(SysEnvironment sysEnvironment);

    /**
     * 新增实验环境
     * 
     * @param sysEnvironment 实验环境
     * @return 结果
     */
    public int insertSysEnvironment(SysEnvironment sysEnvironment);

    /**
     * 修改实验环境
     * 
     * @param sysEnvironment 实验环境
     * @return 结果
     */
    public int updateSysEnvironment(SysEnvironment sysEnvironment);

    /**
     * 删除实验环境
     * 
     * @param id 实验环境ID
     * @return 结果
     */
    public int deleteSysEnvironmentById(Long id);

    /**
     * 批量删除实验环境
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysEnvironmentByIds(Long[] ids);
}

package com.ruoyi.data.mapper;

import java.util.List;
import com.ruoyi.data.domain.SysSimulation;

/**
 * 驾驶实验Mapper接口
 * 
 * @author lym
 * @date 2020-12-07
 */
public interface SysSimulationMapper 
{
    /**
     * 查询驾驶实验
     * 
     * @param id 驾驶实验ID
     * @return 驾驶实验
     */
    public SysSimulation selectSysSimulationById(Long id);

    /**
     * 查询驾驶实验列表
     * 
     * @param sysSimulation 驾驶实验
     * @return 驾驶实验集合
     */
    public List<SysSimulation> selectSysSimulationList(SysSimulation sysSimulation);

    /**
     * 新增驾驶实验
     * 
     * @param sysSimulation 驾驶实验
     * @return 结果
     */
    public int insertSysSimulation(SysSimulation sysSimulation);

    /**
     * 修改驾驶实验
     * 
     * @param sysSimulation 驾驶实验
     * @return 结果
     */
    public int updateSysSimulation(SysSimulation sysSimulation);

    /**
     * 删除驾驶实验
     * 
     * @param id 驾驶实验ID
     * @return 结果
     */
    public int deleteSysSimulationById(Long id);

    /**
     * 批量删除驾驶实验
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysSimulationByIds(Long[] ids);
}

package com.ruoyi.data.service;

import java.util.List;
import com.ruoyi.data.domain.SysSimulationdata;

/**
 * 驾驶数据Service接口
 * 
 * @author lym
 * @date 2020-12-07
 */
public interface ISysSimulationdataService 
{
    /**
     * 查询驾驶数据
     * 
     * @param id 驾驶数据ID
     * @return 驾驶数据
     */
    public SysSimulationdata selectSysSimulationdataById(Long id);

    /**
     * 查询驾驶数据列表
     * 
     * @param sysSimulationdata 驾驶数据
     * @return 驾驶数据集合
     */
    public List<SysSimulationdata> selectSysSimulationdataList(SysSimulationdata sysSimulationdata);

    /**
     * 新增驾驶数据
     * 
     * @param sysSimulationdata 驾驶数据
     * @return 结果
     */
    public int insertSysSimulationdata(SysSimulationdata sysSimulationdata);

    /**
     * 修改驾驶数据
     * 
     * @param sysSimulationdata 驾驶数据
     * @return 结果
     */
    public int updateSysSimulationdata(SysSimulationdata sysSimulationdata);

    /**
     * 批量删除驾驶数据
     * 
     * @param ids 需要删除的驾驶数据ID
     * @return 结果
     */
    public int deleteSysSimulationdataByIds(Long[] ids);

    /**
     * 删除驾驶数据信息
     * 
     * @param id 驾驶数据ID
     * @return 结果
     */
    public int deleteSysSimulationdataById(Long id);
}

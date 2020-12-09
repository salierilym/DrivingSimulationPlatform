package com.ruoyi.information.service;

import java.util.List;
import com.ruoyi.information.domain.SysDriver;

/**
 * 驾驶员Service接口
 * 
 * @author lym
 * @date 2020-12-09
 */
public interface ISysDriverService 
{
    /**
     * 查询驾驶员
     * 
     * @param id 驾驶员ID
     * @return 驾驶员
     */
    public SysDriver selectSysDriverById(Long id);

    /**
     * 查询驾驶员列表
     * 
     * @param sysDriver 驾驶员
     * @return 驾驶员集合
     */
    public List<SysDriver> selectSysDriverList(SysDriver sysDriver);

    /**
     * 新增驾驶员
     * 
     * @param sysDriver 驾驶员
     * @return 结果
     */
    public int insertSysDriver(SysDriver sysDriver);

    /**
     * 修改驾驶员
     * 
     * @param sysDriver 驾驶员
     * @return 结果
     */
    public int updateSysDriver(SysDriver sysDriver);

    /**
     * 批量删除驾驶员
     * 
     * @param ids 需要删除的驾驶员ID
     * @return 结果
     */
    public int deleteSysDriverByIds(Long[] ids);

    /**
     * 删除驾驶员信息
     * 
     * @param id 驾驶员ID
     * @return 结果
     */
    public int deleteSysDriverById(Long id);
}

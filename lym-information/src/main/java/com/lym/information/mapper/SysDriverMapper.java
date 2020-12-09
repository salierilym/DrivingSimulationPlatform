package com.lym.information.mapper;

import java.util.List;
import com.lym.information.domain.SysDriver;

/**
 * 驾驶员Mapper接口
 *
 * @author lym
 * @date 2020-12-09
 */
public interface SysDriverMapper
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
     * 删除驾驶员
     *
     * @param id 驾驶员ID
     * @return 结果
     */
    public int deleteSysDriverById(Long id);

    /**
     * 批量删除驾驶员
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDriverByIds(Long[] ids);
}

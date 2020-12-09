package com.lym.information.service;

import java.util.List;
import com.lym.information.domain.SysCar;

/**
 * 车辆参数Service接口
 *
 * @author lym
 * @date 2020-12-09
 */
public interface ISysCarService
{
    /**
     * 查询车辆参数
     *
     * @param id 车辆参数ID
     * @return 车辆参数
     */
    public SysCar selectSysCarById(Long id);

    /**
     * 查询车辆参数列表
     *
     * @param sysCar 车辆参数
     * @return 车辆参数集合
     */
    public List<SysCar> selectSysCarList(SysCar sysCar);

    /**
     * 新增车辆参数
     *
     * @param sysCar 车辆参数
     * @return 结果
     */
    public int insertSysCar(SysCar sysCar);

    /**
     * 修改车辆参数
     *
     * @param sysCar 车辆参数
     * @return 结果
     */
    public int updateSysCar(SysCar sysCar);

    /**
     * 批量删除车辆参数
     *
     * @param ids 需要删除的车辆参数ID
     * @return 结果
     */
    public int deleteSysCarByIds(Long[] ids);

    /**
     * 删除车辆参数信息
     *
     * @param id 车辆参数ID
     * @return 结果
     */
    public int deleteSysCarById(Long id);
}

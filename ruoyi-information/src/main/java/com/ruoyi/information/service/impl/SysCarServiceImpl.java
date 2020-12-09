package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.SysCarMapper;
import com.ruoyi.information.domain.SysCar;
import com.ruoyi.information.service.ISysCarService;

/**
 * 车辆参数Service业务层处理
 * 
 * @author lym
 * @date 2020-12-09
 */
@Service
public class SysCarServiceImpl implements ISysCarService 
{
    @Autowired
    private SysCarMapper sysCarMapper;

    /**
     * 查询车辆参数
     * 
     * @param id 车辆参数ID
     * @return 车辆参数
     */
    @Override
    public SysCar selectSysCarById(Long id)
    {
        return sysCarMapper.selectSysCarById(id);
    }

    /**
     * 查询车辆参数列表
     * 
     * @param sysCar 车辆参数
     * @return 车辆参数
     */
    @Override
    public List<SysCar> selectSysCarList(SysCar sysCar)
    {
        return sysCarMapper.selectSysCarList(sysCar);
    }

    /**
     * 新增车辆参数
     * 
     * @param sysCar 车辆参数
     * @return 结果
     */
    @Override
    public int insertSysCar(SysCar sysCar)
    {
        return sysCarMapper.insertSysCar(sysCar);
    }

    /**
     * 修改车辆参数
     * 
     * @param sysCar 车辆参数
     * @return 结果
     */
    @Override
    public int updateSysCar(SysCar sysCar)
    {
        return sysCarMapper.updateSysCar(sysCar);
    }

    /**
     * 批量删除车辆参数
     * 
     * @param ids 需要删除的车辆参数ID
     * @return 结果
     */
    @Override
    public int deleteSysCarByIds(Long[] ids)
    {
        return sysCarMapper.deleteSysCarByIds(ids);
    }

    /**
     * 删除车辆参数信息
     * 
     * @param id 车辆参数ID
     * @return 结果
     */
    @Override
    public int deleteSysCarById(Long id)
    {
        return sysCarMapper.deleteSysCarById(id);
    }
}

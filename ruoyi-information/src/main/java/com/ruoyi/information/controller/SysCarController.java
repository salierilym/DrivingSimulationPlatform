package com.ruoyi.information.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.information.domain.SysCar;
import com.ruoyi.information.service.ISysCarService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆参数Controller
 * 
 * @author lym
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/information/car")
public class SysCarController extends BaseController
{
    @Autowired
    private ISysCarService sysCarService;

    /**
     * 查询车辆参数列表
     */
    @PreAuthorize("@ss.hasPermi('information:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCar sysCar)
    {
        startPage();
        List<SysCar> list = sysCarService.selectSysCarList(sysCar);
        return getDataTable(list);
    }

    /**
     * 导出车辆参数列表
     */
    @PreAuthorize("@ss.hasPermi('information:car:export')")
    @Log(title = "车辆参数", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCar sysCar)
    {
        List<SysCar> list = sysCarService.selectSysCarList(sysCar);
        ExcelUtil<SysCar> util = new ExcelUtil<SysCar>(SysCar.class);
        return util.exportExcel(list, "car");
    }

    /**
     * 获取车辆参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:car:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysCarService.selectSysCarById(id));
    }

    /**
     * 新增车辆参数
     */
    @PreAuthorize("@ss.hasPermi('information:car:add')")
    @Log(title = "车辆参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCar sysCar)
    {
        return toAjax(sysCarService.insertSysCar(sysCar));
    }

    /**
     * 修改车辆参数
     */
    @PreAuthorize("@ss.hasPermi('information:car:edit')")
    @Log(title = "车辆参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCar sysCar)
    {
        return toAjax(sysCarService.updateSysCar(sysCar));
    }

    /**
     * 删除车辆参数
     */
    @PreAuthorize("@ss.hasPermi('information:car:remove')")
    @Log(title = "车辆参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysCarService.deleteSysCarByIds(ids));
    }
}

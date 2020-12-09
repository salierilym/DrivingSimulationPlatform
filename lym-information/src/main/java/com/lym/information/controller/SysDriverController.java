package com.lym.information.controller;

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
import com.lym.common.annotation.Log;
import com.lym.common.core.controller.BaseController;
import com.lym.common.core.domain.AjaxResult;
import com.lym.common.enums.BusinessType;
import com.lym.information.domain.SysDriver;
import com.lym.information.service.ISysDriverService;
import com.lym.common.utils.poi.ExcelUtil;
import com.lym.common.core.page.TableDataInfo;

/**
 * 驾驶员Controller
 *
 * @author lym
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/information/driver")
public class SysDriverController extends BaseController
{
    @Autowired
    private ISysDriverService sysDriverService;

    /**
     * 查询驾驶员列表
     */
    @PreAuthorize("@ss.hasPermi('information:driver:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDriver sysDriver)
    {
        startPage();
        List<SysDriver> list = sysDriverService.selectSysDriverList(sysDriver);
        return getDataTable(list);
    }

    /**
     * 导出驾驶员列表
     */
    @PreAuthorize("@ss.hasPermi('information:driver:export')")
    @Log(title = "驾驶员", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysDriver sysDriver)
    {
        List<SysDriver> list = sysDriverService.selectSysDriverList(sysDriver);
        ExcelUtil<SysDriver> util = new ExcelUtil<SysDriver>(SysDriver.class);
        return util.exportExcel(list, "driver");
    }

    /**
     * 获取驾驶员详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:driver:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysDriverService.selectSysDriverById(id));
    }

    /**
     * 新增驾驶员
     */
    @PreAuthorize("@ss.hasPermi('information:driver:add')")
    @Log(title = "驾驶员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDriver sysDriver)
    {
        return toAjax(sysDriverService.insertSysDriver(sysDriver));
    }

    /**
     * 修改驾驶员
     */
    @PreAuthorize("@ss.hasPermi('information:driver:edit')")
    @Log(title = "驾驶员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDriver sysDriver)
    {
        return toAjax(sysDriverService.updateSysDriver(sysDriver));
    }

    /**
     * 删除驾驶员
     */
    @PreAuthorize("@ss.hasPermi('information:driver:remove')")
    @Log(title = "驾驶员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysDriverService.deleteSysDriverByIds(ids));
    }
}

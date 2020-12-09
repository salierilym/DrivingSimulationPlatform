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
import com.lym.information.domain.SysEnvironment;
import com.lym.information.service.ISysEnvironmentService;
import com.lym.common.utils.poi.ExcelUtil;
import com.lym.common.core.page.TableDataInfo;

/**
 * 实验环境Controller
 *
 * @author lym
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/information/environment")
public class SysEnvironmentController extends BaseController
{
    @Autowired
    private ISysEnvironmentService sysEnvironmentService;

    /**
     * 查询实验环境列表
     */
    @PreAuthorize("@ss.hasPermi('information:environment:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysEnvironment sysEnvironment)
    {
        startPage();
        List<SysEnvironment> list = sysEnvironmentService.selectSysEnvironmentList(sysEnvironment);
        return getDataTable(list);
    }

    /**
     * 导出实验环境列表
     */
    @PreAuthorize("@ss.hasPermi('information:environment:export')")
    @Log(title = "实验环境", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysEnvironment sysEnvironment)
    {
        List<SysEnvironment> list = sysEnvironmentService.selectSysEnvironmentList(sysEnvironment);
        ExcelUtil<SysEnvironment> util = new ExcelUtil<SysEnvironment>(SysEnvironment.class);
        return util.exportExcel(list, "environment");
    }

    /**
     * 获取实验环境详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:environment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysEnvironmentService.selectSysEnvironmentById(id));
    }

    /**
     * 新增实验环境
     */
    @PreAuthorize("@ss.hasPermi('information:environment:add')")
    @Log(title = "实验环境", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysEnvironment sysEnvironment)
    {
        return toAjax(sysEnvironmentService.insertSysEnvironment(sysEnvironment));
    }

    /**
     * 修改实验环境
     */
    @PreAuthorize("@ss.hasPermi('information:environment:edit')")
    @Log(title = "实验环境", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysEnvironment sysEnvironment)
    {
        return toAjax(sysEnvironmentService.updateSysEnvironment(sysEnvironment));
    }

    /**
     * 删除实验环境
     */
    @PreAuthorize("@ss.hasPermi('information:environment:remove')")
    @Log(title = "实验环境", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysEnvironmentService.deleteSysEnvironmentByIds(ids));
    }
}

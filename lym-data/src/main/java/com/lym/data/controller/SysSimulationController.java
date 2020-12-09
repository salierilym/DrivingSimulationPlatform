package com.lym.data.controller;

import java.util.List;

import com.lym.data.domain.SysSimulation;
import com.lym.data.service.ISysSimulationService;
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
import com.lym.common.utils.poi.ExcelUtil;
import com.lym.common.core.page.TableDataInfo;

/**
 * 驾驶实验Controller
 *
 * @author lym
 * @date 2020-12-07
 */
@RestController
@RequestMapping("/data/simulation")
public class SysSimulationController extends BaseController
{
    @Autowired
    private ISysSimulationService sysSimulationService;

    /**
     * 查询驾驶实验列表
     */
    @PreAuthorize("@ss.hasPermi('data:simulation:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSimulation sysSimulation)
    {
        startPage();
        List<SysSimulation> list = sysSimulationService.selectSysSimulationList(sysSimulation);
        return getDataTable(list);
    }

    /**
     * 导出驾驶实验列表
     */
    @PreAuthorize("@ss.hasPermi('data:simulation:export')")
    @Log(title = "驾驶实验", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysSimulation sysSimulation)
    {
        List<SysSimulation> list = sysSimulationService.selectSysSimulationList(sysSimulation);
        ExcelUtil<SysSimulation> util = new ExcelUtil<SysSimulation>(SysSimulation.class);
        return util.exportExcel(list, "simulation");
    }

    /**
     * 获取驾驶实验详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:simulation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysSimulationService.selectSysSimulationById(id));
    }

    /**
     * 新增驾驶实验
     */
    @PreAuthorize("@ss.hasPermi('data:simulation:add')")
    @Log(title = "驾驶实验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSimulation sysSimulation)
    {
        return toAjax(sysSimulationService.insertSysSimulation(sysSimulation));
    }

    /**
     * 修改驾驶实验
     */
    @PreAuthorize("@ss.hasPermi('data:simulation:edit')")
    @Log(title = "驾驶实验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSimulation sysSimulation)
    {
        return toAjax(sysSimulationService.updateSysSimulation(sysSimulation));
    }

    /**
     * 删除驾驶实验
     */
    @PreAuthorize("@ss.hasPermi('data:simulation:remove')")
    @Log(title = "驾驶实验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysSimulationService.deleteSysSimulationByIds(ids));
    }
}

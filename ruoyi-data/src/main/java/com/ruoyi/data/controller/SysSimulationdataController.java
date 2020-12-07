package com.ruoyi.data.controller;

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
import com.ruoyi.data.domain.SysSimulationdata;
import com.ruoyi.data.service.ISysSimulationdataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 驾驶数据Controller
 * 
 * @author lym
 * @date 2020-12-07
 */
@RestController
@RequestMapping("/data/simulationdata")
public class SysSimulationdataController extends BaseController
{
    @Autowired
    private ISysSimulationdataService sysSimulationdataService;

    /**
     * 查询驾驶数据列表
     */
    @PreAuthorize("@ss.hasPermi('data:simulationdata:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSimulationdata sysSimulationdata)
    {
        startPage();
        List<SysSimulationdata> list = sysSimulationdataService.selectSysSimulationdataList(sysSimulationdata);
        return getDataTable(list);
    }

    /**
     * 导出驾驶数据列表
     */
    @PreAuthorize("@ss.hasPermi('data:simulationdata:export')")
    @Log(title = "驾驶数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysSimulationdata sysSimulationdata)
    {
        List<SysSimulationdata> list = sysSimulationdataService.selectSysSimulationdataList(sysSimulationdata);
        ExcelUtil<SysSimulationdata> util = new ExcelUtil<SysSimulationdata>(SysSimulationdata.class);
        return util.exportExcel(list, "simulationdata");
    }

    /**
     * 获取驾驶数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:simulationdata:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysSimulationdataService.selectSysSimulationdataById(id));
    }

    /**
     * 新增驾驶数据
     */
    @PreAuthorize("@ss.hasPermi('data:simulationdata:add')")
    @Log(title = "驾驶数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSimulationdata sysSimulationdata)
    {
        return toAjax(sysSimulationdataService.insertSysSimulationdata(sysSimulationdata));
    }

    /**
     * 修改驾驶数据
     */
    @PreAuthorize("@ss.hasPermi('data:simulationdata:edit')")
    @Log(title = "驾驶数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSimulationdata sysSimulationdata)
    {
        return toAjax(sysSimulationdataService.updateSysSimulationdata(sysSimulationdata));
    }

    /**
     * 删除驾驶数据
     */
    @PreAuthorize("@ss.hasPermi('data:simulationdata:remove')")
    @Log(title = "驾驶数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysSimulationdataService.deleteSysSimulationdataByIds(ids));
    }
}

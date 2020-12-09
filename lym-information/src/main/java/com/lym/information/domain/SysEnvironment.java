package com.lym.information.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lym.common.annotation.Excel;
import com.lym.common.core.domain.BaseEntity;

/**
 * 实验环境对象 sys_environment
 *
 * @author lym
 * @date 2020-12-09
 */
public class SysEnvironment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 实验环境名称 */
    @Excel(name = "实验环境名称")
    private String envName;

    /** 地图名称 */
    @Excel(name = "地图名称")
    private String mapName;

    /** 工程背景 */
    @Excel(name = "工程背景")
    private String envBackground;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEnvName(String envName)
    {
        this.envName = envName;
    }

    public String getEnvName()
    {
        return envName;
    }
    public void setMapName(String mapName)
    {
        this.mapName = mapName;
    }

    public String getMapName()
    {
        return mapName;
    }
    public void setEnvBackground(String envBackground)
    {
        this.envBackground = envBackground;
    }

    public String getEnvBackground()
    {
        return envBackground;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("envName", getEnvName())
            .append("mapName", getMapName())
            .append("envBackground", getEnvBackground())
            .toString();
    }
}

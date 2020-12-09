package com.lym.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lym.common.annotation.Excel;
import com.lym.common.core.domain.BaseEntity;

/**
 * 驾驶实验对象 sys_simulation
 *
 * @author lym
 * @date 2020-12-07
 */
public class SysSimulation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 驾驶员编号 */
    @Excel(name = "驾驶员编号")
    private Long did;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String cartype;

    /** 实验环境 */
    @Excel(name = "实验环境")
    private String environment;

    /** 实验备注 */
    @Excel(name = "实验备注")
    private String envRemark;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String starttime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDid(Long did)
    {
        this.did = did;
    }

    public Long getDid()
    {
        return did;
    }
    public void setCartype(String cartype)
    {
        this.cartype = cartype;
    }

    public String getCartype()
    {
        return cartype;
    }
    public void setEnvironment(String environment)
    {
        this.environment = environment;
    }

    public String getEnvironment()
    {
        return environment;
    }
    public void setEnvRemark(String envRemark)
    {
        this.envRemark = envRemark;
    }

    public String getEnvRemark()
    {
        return envRemark;
    }
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }

    public String getStarttime()
    {
        return starttime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("did", getDid())
            .append("cartype", getCartype())
            .append("environment", getEnvironment())
            .append("envRemark", getEnvRemark())
            .append("starttime", getStarttime())
            .toString();
    }
}

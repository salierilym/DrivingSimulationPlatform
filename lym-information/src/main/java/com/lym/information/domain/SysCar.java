package com.lym.information.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lym.common.annotation.Excel;
import com.lym.common.core.domain.BaseEntity;

/**
 * 车辆参数对象 sys_car
 *
 * @author lym
 * @date 2020-12-09
 */
public class SysCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 车辆名称 */
    @Excel(name = "车辆名称")
    private String carName;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String carType;

    /** 车辆全长(m) */
    @Excel(name = "车辆全长(m)")
    private String carLength;

    /** 车辆总宽(m) */
    @Excel(name = "车辆总宽(m)")
    private String carWidth;

    /** 车辆总高(m) */
    @Excel(name = "车辆总高(m)")
    private String carHeight;

    /** 车辆轴距(m) */
    @Excel(name = "车辆轴距(m)")
    private String carWheelbase;

    /** 车辆最大扭矩(Nm) */
    @Excel(name = "车辆最大扭矩(Nm)")
    private String carMaxtorque;

    /** 车辆最高转速(r/min) */
    @Excel(name = "车辆最高转速(r/min)")
    private String carMaxrpm;

    /** 车辆差速器类型 */
    @Excel(name = "车辆差速器类型")
    private String carDifferential;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCarName(String carName)
    {
        this.carName = carName;
    }

    public String getCarName()
    {
        return carName;
    }
    public void setCarType(String carType)
    {
        this.carType = carType;
    }

    public String getCarType()
    {
        return carType;
    }
    public void setCarLength(String carLength)
    {
        this.carLength = carLength;
    }

    public String getCarLength()
    {
        return carLength;
    }
    public void setCarWidth(String carWidth)
    {
        this.carWidth = carWidth;
    }

    public String getCarWidth()
    {
        return carWidth;
    }
    public void setCarHeight(String carHeight)
    {
        this.carHeight = carHeight;
    }

    public String getCarHeight()
    {
        return carHeight;
    }
    public void setCarWheelbase(String carWheelbase)
    {
        this.carWheelbase = carWheelbase;
    }

    public String getCarWheelbase()
    {
        return carWheelbase;
    }
    public void setCarMaxtorque(String carMaxtorque)
    {
        this.carMaxtorque = carMaxtorque;
    }

    public String getCarMaxtorque()
    {
        return carMaxtorque;
    }
    public void setCarMaxrpm(String carMaxrpm)
    {
        this.carMaxrpm = carMaxrpm;
    }

    public String getCarMaxrpm()
    {
        return carMaxrpm;
    }
    public void setCarDifferential(String carDifferential)
    {
        this.carDifferential = carDifferential;
    }

    public String getCarDifferential()
    {
        return carDifferential;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carName", getCarName())
            .append("carType", getCarType())
            .append("carLength", getCarLength())
            .append("carWidth", getCarWidth())
            .append("carHeight", getCarHeight())
            .append("carWheelbase", getCarWheelbase())
            .append("carMaxtorque", getCarMaxtorque())
            .append("carMaxrpm", getCarMaxrpm())
            .append("carDifferential", getCarDifferential())
            .toString();
    }
}

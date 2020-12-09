package com.lym.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lym.common.annotation.Excel;
import com.lym.common.core.domain.BaseEntity;

/**
 * 驾驶数据对象 sys_simulationdata
 *
 * @author lym
 * @date 2020-12-07
 */
public class SysSimulationdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 驾驶实验表编号 */
    @Excel(name = "驾驶实验表编号")
    private Long sid;

    /** x坐标 */
    @Excel(name = "x坐标")
    private Long locX;

    /** y坐标 */
    @Excel(name = "y坐标")
    private Long locY;

    /** z坐标 */
    @Excel(name = "z坐标")
    private Long locZ;

    /** 车速 */
    @Excel(name = "车速")
    private Long speed;

    /** x方向速度 */
    @Excel(name = "x方向速度")
    private Long vx;

    /** y方向速度 */
    @Excel(name = "y方向速度")
    private Long vy;

    /** z方向速度 */
    @Excel(name = "z方向速度")
    private Long vz;

    /** 加速度 */
    @Excel(name = "加速度")
    private Long a;

    /** x方向加速度 */
    @Excel(name = "x方向加速度")
    private Long ax;

    /** y方向加速度 */
    @Excel(name = "y方向加速度")
    private Long ay;

    /** z方向加速度 */
    @Excel(name = "z方向加速度")
    private Long az;

    /** 档位 */
    @Excel(name = "档位")
    private Long gear;

    /** 转速 */
    @Excel(name = "转速")
    private Long rpm;

    /** 行驶里程 */
    @Excel(name = "行驶里程")
    private Long traveledDistance;

    /** 时间戳 */
    @Excel(name = "时间戳")
    private String simulationTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSid(Long sid)
    {
        this.sid = sid;
    }

    public Long getSid()
    {
        return sid;
    }
    public void setLocX(Long locX)
    {
        this.locX = locX;
    }

    public Long getLocX()
    {
        return locX;
    }
    public void setLocY(Long locY)
    {
        this.locY = locY;
    }

    public Long getLocY()
    {
        return locY;
    }
    public void setLocZ(Long locZ)
    {
        this.locZ = locZ;
    }

    public Long getLocZ()
    {
        return locZ;
    }
    public void setSpeed(Long speed)
    {
        this.speed = speed;
    }

    public Long getSpeed()
    {
        return speed;
    }
    public void setVx(Long vx)
    {
        this.vx = vx;
    }

    public Long getVx()
    {
        return vx;
    }
    public void setVy(Long vy)
    {
        this.vy = vy;
    }

    public Long getVy()
    {
        return vy;
    }
    public void setVz(Long vz)
    {
        this.vz = vz;
    }

    public Long getVz()
    {
        return vz;
    }
    public void setA(Long a)
    {
        this.a = a;
    }

    public Long getA()
    {
        return a;
    }
    public void setAx(Long ax)
    {
        this.ax = ax;
    }

    public Long getAx()
    {
        return ax;
    }
    public void setAy(Long ay)
    {
        this.ay = ay;
    }

    public Long getAy()
    {
        return ay;
    }
    public void setAz(Long az)
    {
        this.az = az;
    }

    public Long getAz()
    {
        return az;
    }
    public void setGear(Long gear)
    {
        this.gear = gear;
    }

    public Long getGear()
    {
        return gear;
    }
    public void setRpm(Long rpm)
    {
        this.rpm = rpm;
    }

    public Long getRpm()
    {
        return rpm;
    }
    public void setTraveledDistance(Long traveledDistance)
    {
        this.traveledDistance = traveledDistance;
    }

    public Long getTraveledDistance()
    {
        return traveledDistance;
    }
    public void setSimulationTime(String simulationTime)
    {
        this.simulationTime = simulationTime;
    }

    public String getSimulationTime()
    {
        return simulationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sid", getSid())
            .append("locX", getLocX())
            .append("locY", getLocY())
            .append("locZ", getLocZ())
            .append("speed", getSpeed())
            .append("vx", getVx())
            .append("vy", getVy())
            .append("vz", getVz())
            .append("a", getA())
            .append("ax", getAx())
            .append("ay", getAy())
            .append("az", getAz())
            .append("gear", getGear())
            .append("rpm", getRpm())
            .append("traveledDistance", getTraveledDistance())
            .append("simulationTime", getSimulationTime())
            .toString();
    }
}

package com.lym.information.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lym.common.annotation.Excel;
import com.lym.common.core.domain.BaseEntity;

/**
 * 驾驶员对象 sys_driver
 *
 * @author lym
 * @date 2020-12-09
 */
public class SysDriver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 驾驶员姓名 */
    @Excel(name = "驾驶员姓名")
    private String driverName;

    /** 驾驶员性别 */
    @Excel(name = "驾驶员性别")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer age;

    /** 驾龄 */
    @Excel(name = "驾龄")
    private Integer drivingAge;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String tel;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mail;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDriverName(String driverName)
    {
        this.driverName = driverName;
    }

    public String getDriverName()
    {
        return driverName;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Integer getAge()
    {
        return age;
    }
    public void setDrivingAge(Integer drivingAge)
    {
        this.drivingAge = drivingAge;
    }

    public Integer getDrivingAge()
    {
        return drivingAge;
    }
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Date getBirthday()
    {
        return birthday;
    }
    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getTel()
    {
        return tel;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getMail()
    {
        return mail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("driverName", getDriverName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("drivingAge", getDrivingAge())
            .append("birthday", getBirthday())
            .append("tel", getTel())
            .append("mail", getMail())
            .append("remark", getRemark())
            .toString();
    }
}

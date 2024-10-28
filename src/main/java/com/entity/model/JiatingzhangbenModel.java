package com.entity.model;

import com.entity.JiatingzhangbenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 家庭账本
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-27
 */
public class JiatingzhangbenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 家庭名称
     */
    private String jtTypes;


    /**
     * 收入支出名称
     */
    private String zbname;


    /**
     * 支出收入类型
     */
    private Integer leixingTypes;


    /**
     * 金额
     */
    private Double expense;


    /**
     * 家庭成员
     */
    private Integer yonghuId;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date riqiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：家庭名称
	 */
    public String getJtTypes() {
        return jtTypes;
    }


    /**
	 * 设置：家庭名称
	 */
    public void setJtTypes(String jtTypes) {
        this.jtTypes = jtTypes;
    }
    /**
	 * 获取：收入支出名称
	 */
    public String getZbname() {
        return zbname;
    }


    /**
	 * 设置：收入支出名称
	 */
    public void setZbname(String zbname) {
        this.zbname = zbname;
    }
    /**
	 * 获取：支出收入类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }


    /**
	 * 设置：支出收入类型
	 */
    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 获取：金额
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 设置：金额
	 */
    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 获取：家庭成员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：家庭成员
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：日期
	 */
    public Date getRiqiTime() {
        return riqiTime;
    }


    /**
	 * 设置：日期
	 */
    public void setRiqiTime(Date riqiTime) {
        this.riqiTime = riqiTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

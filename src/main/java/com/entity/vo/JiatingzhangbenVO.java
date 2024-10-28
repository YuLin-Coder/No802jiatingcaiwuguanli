package com.entity.vo;

import com.entity.JiatingzhangbenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 家庭账本
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-27
 */
@TableName("jiatingzhangben")
public class JiatingzhangbenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 家庭名称
     */

    @TableField(value = "jt_types")
    private String jtTypes;


    /**
     * 收入支出名称
     */

    @TableField(value = "zbname")
    private String zbname;


    /**
     * 支出收入类型
     */

    @TableField(value = "leixing_types")
    private Integer leixingTypes;


    /**
     * 金额
     */

    @TableField(value = "expense")
    private Double expense;


    /**
     * 家庭成员
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "riqi_time")
    private Date riqiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：家庭名称
	 */
    public String getJtTypes() {
        return jtTypes;
    }


    /**
	 * 获取：家庭名称
	 */

    public void setJtTypes(String jtTypes) {
        this.jtTypes = jtTypes;
    }
    /**
	 * 设置：收入支出名称
	 */
    public String getZbname() {
        return zbname;
    }


    /**
	 * 获取：收入支出名称
	 */

    public void setZbname(String zbname) {
        this.zbname = zbname;
    }
    /**
	 * 设置：支出收入类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }


    /**
	 * 获取：支出收入类型
	 */

    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 设置：金额
	 */
    public Double getExpense() {
        return expense;
    }


    /**
	 * 获取：金额
	 */

    public void setExpense(Double expense) {
        this.expense = expense;
    }
    /**
	 * 设置：家庭成员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：家庭成员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：日期
	 */
    public Date getRiqiTime() {
        return riqiTime;
    }


    /**
	 * 获取：日期
	 */

    public void setRiqiTime(Date riqiTime) {
        this.riqiTime = riqiTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

package com.entity.model;

import com.entity.TongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 通知
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-27
 */
public class TongzhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 通知标题
     */
    private String gname;


    /**
     * 通知类型
     */
    private Integer lxTypes;


    /**
     * 通知日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date riqiTime;


    /**
     * 通知内容
     */
    private String tongzhiContent;


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
	 * 获取：通知标题
	 */
    public String getGname() {
        return gname;
    }


    /**
	 * 设置：通知标题
	 */
    public void setGname(String gname) {
        this.gname = gname;
    }
    /**
	 * 获取：通知类型
	 */
    public Integer getLxTypes() {
        return lxTypes;
    }


    /**
	 * 设置：通知类型
	 */
    public void setLxTypes(Integer lxTypes) {
        this.lxTypes = lxTypes;
    }
    /**
	 * 获取：通知日期
	 */
    public Date getRiqiTime() {
        return riqiTime;
    }


    /**
	 * 设置：通知日期
	 */
    public void setRiqiTime(Date riqiTime) {
        this.riqiTime = riqiTime;
    }
    /**
	 * 获取：通知内容
	 */
    public String getTongzhiContent() {
        return tongzhiContent;
    }


    /**
	 * 设置：通知内容
	 */
    public void setTongzhiContent(String tongzhiContent) {
        this.tongzhiContent = tongzhiContent;
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

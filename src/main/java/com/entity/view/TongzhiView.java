package com.entity.view;

import com.entity.TongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-27
 */
@TableName("tongzhi")
public class TongzhiView extends TongzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 通知类型的值
		*/
		private String lxValue;



	public TongzhiView() {

	}

	public TongzhiView(TongzhiEntity tongzhiEntity) {
		try {
			BeanUtils.copyProperties(this, tongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 通知类型的值
			*/
			public String getLxValue() {
				return lxValue;
			}
			/**
			* 设置： 通知类型的值
			*/
			public void setLxValue(String lxValue) {
				this.lxValue = lxValue;
			}







}

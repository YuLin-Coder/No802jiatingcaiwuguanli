package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.entity.JiatingzhangbenEntity;

import java.util.List;
import java.util.Map;

/**
 * 家庭账本 服务类
 * @author 
 * @since 2021-03-27
 */
public interface JiatingzhangbenService extends IService<JiatingzhangbenEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

    List<YonghuEntity> selectBaobiao(YonghuEntity user);
}
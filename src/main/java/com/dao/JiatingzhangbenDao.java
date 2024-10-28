package com.dao;

import com.entity.JiatingzhangbenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.YonghuEntity;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiatingzhangbenView;

/**
 * 家庭账本 Dao 接口
 *
 * @author 
 * @since 2021-03-27
 */
public interface JiatingzhangbenDao extends BaseMapper<JiatingzhangbenEntity> {

   List<JiatingzhangbenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

    List<YonghuEntity> selectBaobiao(@Param("params")YonghuEntity user);
}

package com.service.impl;

import com.entity.YonghuEntity;
import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.JiatingzhangbenDao;
import com.entity.JiatingzhangbenEntity;
import com.service.JiatingzhangbenService;
import com.entity.view.JiatingzhangbenView;

/**
 * 家庭账本 服务实现类
 * @author 
 * @since 2021-03-27
 */
@Service("jiatingzhangbenService")
@Transactional
public class JiatingzhangbenServiceImpl extends ServiceImpl<JiatingzhangbenDao, JiatingzhangbenEntity> implements JiatingzhangbenService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiatingzhangbenView> page =new Query<JiatingzhangbenView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

    @Override
    public List<YonghuEntity> selectBaobiao(YonghuEntity user) {
        return baseMapper.selectBaobiao(user);
    }


}

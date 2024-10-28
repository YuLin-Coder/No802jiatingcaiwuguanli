package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiatingzhangbenEntity;

import com.service.JiatingzhangbenService;
import com.entity.view.JiatingzhangbenView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 家庭账本
 * 后端接口
 * @author
 * @email
 * @date 2021-03-27
*/
@RestController
@Controller
@RequestMapping("/jiatingzhangben")
public class JiatingzhangbenController {
    private static final Logger logger = LoggerFactory.getLogger(JiatingzhangbenController.class);

    @Autowired
    private JiatingzhangbenService jiatingzhangbenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            YonghuEntity user = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
            if(user == null){
                return R.error();
            }
            params.put("jtTypes",user.getJtTypes());
        }
        PageUtils page = jiatingzhangbenService.queryPage(params);

        //字典表数据转换
        List<JiatingzhangbenView> list =(List<JiatingzhangbenView>)page.getList();
        for(JiatingzhangbenView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端列表
    */
    @RequestMapping("/baobiao")
    public R baobiao(HttpServletRequest request){
        YonghuEntity user = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
        if(user == null){
            return R.error();
        }
        jiatingzhangbenService.selectBaobiao(user);
        return R.ok();
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiatingzhangbenEntity jiatingzhangben = jiatingzhangbenService.selectById(id);
        if(jiatingzhangben !=null){
            //entity转view
            JiatingzhangbenView view = new JiatingzhangbenView();
            BeanUtils.copyProperties( jiatingzhangben , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiatingzhangben.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiatingzhangbenEntity jiatingzhangben, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiatingzhangben:{}",this.getClass().getName(),jiatingzhangben.toString());
        Wrapper<JiatingzhangbenEntity> queryWrapper = new EntityWrapper<JiatingzhangbenEntity>()
            .eq("jt_types", jiatingzhangben.getJtTypes())
            .eq("zbname", jiatingzhangben.getZbname())
            .eq("leixing_types", jiatingzhangben.getLeixingTypes())
            .eq("yonghu_id", jiatingzhangben.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiatingzhangbenEntity jiatingzhangbenEntity = jiatingzhangbenService.selectOne(queryWrapper);
        YonghuEntity yonghu = yonghuService.selectById(jiatingzhangben.getYonghuId());
        jiatingzhangben.setJtTypes(yonghu.getJtTypes());
        if(jiatingzhangbenEntity==null){
            jiatingzhangben.setCreateTime(new Date());
            jiatingzhangbenService.insert(jiatingzhangben);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiatingzhangbenEntity jiatingzhangben, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiatingzhangben:{}",this.getClass().getName(),jiatingzhangben.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiatingzhangbenEntity> queryWrapper = new EntityWrapper<JiatingzhangbenEntity>()
            .notIn("id",jiatingzhangben.getId())
            .andNew()
            .eq("jt_types", jiatingzhangben.getJtTypes())
            .eq("zbname", jiatingzhangben.getZbname())
            .eq("leixing_types", jiatingzhangben.getLeixingTypes())
            .eq("yonghu_id", jiatingzhangben.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiatingzhangbenEntity jiatingzhangbenEntity = jiatingzhangbenService.selectOne(queryWrapper);
                jiatingzhangben.setRiqiTime(new Date());
        if(jiatingzhangbenEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiatingzhangben.set
            //  }
            jiatingzhangbenService.updateById(jiatingzhangben);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiatingzhangbenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}


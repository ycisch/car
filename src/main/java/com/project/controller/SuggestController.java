package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.model.Suggest;
import com.project.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: car
 * @description: 建议
 * @author: Administrator
 * @create: 2020-03-31 21:14
 */
@RequestMapping("Suggest")
@Controller
public class SuggestController {
    private Map<String , Object > result = new HashMap<>();

    @Autowired
    private SuggestService suggestService;


    /**
     *@Description: 跳转需求页面显示页面
     *@Param: [modelAndView]
     *@return: org.springframework.web.servlet.ModelAndView
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @ResponseBody
    @RequestMapping("goSuggestList")
    public ModelAndView goSuggestList(ModelAndView modelAndView){
        modelAndView.setViewName("suggest/goSuggestList");
        return modelAndView;
    }


    /**
     *@Description: 添加建议
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("insertSuggest")
    @ResponseBody
    public Map<String , Object > insertSuggest(Suggest suggest){
        if(suggestService.insertSuggest(suggest) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 删除建议
     *@Param: [ids]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("deleteSuggest")
    @ResponseBody
    public Map<String,Object> deleteSuggest(@RequestParam(value = "ids[]", required = true) Integer[] ids){

        if(suggestService.deleteSuggest(ids) > 0){
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "删除失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 修改建议
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/3/7
     */
    @RequestMapping("updateSuggest")
    @ResponseBody
    public Map<String,Object>updateSuggest(Suggest suggest){
        if(suggestService.updateSuggest(suggest) > 0){
            result.put("success", true);
        }
        else {
            result.put("success", false);
            result.put("msg", "修改失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     *@Description: 查询建议
     *@Param: [driver]
     *@return: java.util.Map<java.lang.String,java.lang.Object>
     *@Author: Administrator
     *@date: 2020/4/2
     */
    @RequestMapping("getSuggestList")
    @ResponseBody
    public Map<String,Object>findAllSuggest(Integer page, Integer rows,Suggest suggest){
        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //查询公告信息
        List<Suggest> list = suggestService.findAllSuggest(suggest);
        //封装信息列表
        PageInfo<Suggest> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Suggest> suggestList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", suggestList);
        return result;
    }
}

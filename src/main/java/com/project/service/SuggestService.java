package com.project.service;

import com.project.model.Suggest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public interface SuggestService {

    /**
     *@Description: 查看所有建议
     *@Param: [suggest]
     *@return: java.util.List<com.project.model.Suggest>
     *@Author: Administrator
     *@date: 2020/3/30
     */
    List<Suggest> findAllSuggest(Suggest suggest);

    /**
     *@Description: 添加建议
     *@Param: [suggest]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int insertSuggest(Suggest suggest);

    /**
     *@Description: 修改建议
     *@Param: [suggest]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int updateSuggest(Suggest suggest);

    /**
     *@Description: 删除建议
     *@Param: [ids]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int deleteSuggest(Integer[] ids);
}

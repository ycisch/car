package com.project.service.impl;

import com.project.mapper.SuggestMapper;
import com.project.model.Suggest;
import com.project.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: car
 * @description:
 * @author: Administrator
 * @create: 2020-03-29 23:32
 */
@Service
public class SuggestServiceImpl implements SuggestService {

    @Autowired
    SuggestMapper suggestMapper;
    @Override
    public List<Suggest> findAllSuggest(Suggest suggest) {
        return suggestMapper.findAllSuggest(suggest);
    }

    @Override
    public int insertSuggest(Suggest suggest) {
        return suggestMapper.insertSuggest(suggest);
    }

    @Override
    public int updateSuggest(Suggest suggest) {
        return suggestMapper.updateSuggest(suggest);
    }

    @Override
    public int deleteSuggest(Integer[] ids) {
        return suggestMapper.deleteSuggest(ids);
    }
}

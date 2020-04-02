package com.project.service.impl;

import com.project.mapper.DemandMapper;
import com.project.model.Demand;
import com.project.service.DemandService;
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
public class DemandServiceImpl implements DemandService {

    @Autowired
    DemandMapper demandMapper;

    @Override
    public List<Demand> findALlDemand(Demand demand) {
        return demandMapper.findALlDemand(demand);
    }

    @Override
    public int insertDemand(Demand demand) {
        return demandMapper.insertDemand(demand);
    }
}

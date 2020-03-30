package com.project.mapper;

import com.project.model.Order;
import com.project.model.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: car
 * @description: 记录Mapper
 * @author: Administrator
 * @create: 2020-03-29 23:18
 */
@Mapper
public interface RecordMapper {
    /**
     *@Description: 查看所有记录信息
     *@Param: [record]
     *@return: java.util.List<com.project.model.Order>
     *@Author: Administrator
     *@date: 2020/3/30
     */
    List<Order> findAllRecord(Record record);

    /**
     *@Description: 添加记录信息
     *@Param: [record]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int insertRecord(Record record);

    /**
     *@Description: 修改记录信息
     *@Param: [record]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int updateRecord(Record record);

    /**
     *@Description: 删除记录信息
     *@Param: [ids]
     *@return: int
     *@Author: Administrator
     *@date: 2020/3/30
     */
    int deleteRecord(Integer[] ids);
}

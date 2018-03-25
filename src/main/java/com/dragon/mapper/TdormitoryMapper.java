package com.dragon.mapper;

import com.dragon.pojo.Tdormitory;
import com.dragon.pojo.TdormitoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdormitoryMapper {
    int countByExample(TdormitoryExample example);

    int deleteByExample(TdormitoryExample example);

    int deleteByPrimaryKey(Integer dormitoryid);

    int insert(Tdormitory record);

    int insertSelective(Tdormitory record);

    List<Tdormitory> selectByExample(TdormitoryExample example);

    Tdormitory selectByPrimaryKey(Integer dormitoryid);

    int updateByExampleSelective(@Param("record") Tdormitory record, @Param("example") TdormitoryExample example);

    int updateByExample(@Param("record") Tdormitory record, @Param("example") TdormitoryExample example);

    int updateByPrimaryKeySelective(Tdormitory record);

    int updateByPrimaryKey(Tdormitory record);
}
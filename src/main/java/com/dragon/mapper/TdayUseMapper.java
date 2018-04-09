package com.dragon.mapper;

import com.dragon.pojo.TdayUse;
import com.dragon.pojo.TdayUseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TdayUseMapper {
    int countByExample(TdayUseExample example);

    int deleteByExample(TdayUseExample example);

    int insert(TdayUse record);

    int insertSelective(TdayUse record);

    List<TdayUse> selectByExample(TdayUseExample example);

    int updateByExampleSelective(@Param("record") TdayUse record, @Param("example") TdayUseExample example);

    int updateByExample(@Param("record") TdayUse record, @Param("example") TdayUseExample example);
}
package com.dragon.mapper;

import com.dragon.pojo.TmonUse;
import com.dragon.pojo.TmonUseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmonUseMapper {
    int countByExample(TmonUseExample example);

    int deleteByExample(TmonUseExample example);

    int insert(TmonUse record);

    int insertSelective(TmonUse record);

    List<TmonUse> selectByExample(TmonUseExample example);

    int updateByExampleSelective(@Param("record") TmonUse record, @Param("example") TmonUseExample example);

    int updateByExample(@Param("record") TmonUse record, @Param("example") TmonUseExample example);
}
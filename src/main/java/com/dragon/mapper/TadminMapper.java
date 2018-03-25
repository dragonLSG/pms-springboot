package com.dragon.mapper;

import com.dragon.pojo.Tadmin;
import com.dragon.pojo.TadminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TadminMapper {
    int countByExample(TadminExample example);

    int deleteByExample(TadminExample example);

    int deleteByPrimaryKey(String account);

    int insert(Tadmin record);

    int insertSelective(Tadmin record);

    List<Tadmin> selectByExample(TadminExample example);

    Tadmin selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") Tadmin record, @Param("example") TadminExample example);

    int updateByExample(@Param("record") Tadmin record, @Param("example") TadminExample example);

    int updateByPrimaryKeySelective(Tadmin record);

    int updateByPrimaryKey(Tadmin record);
}
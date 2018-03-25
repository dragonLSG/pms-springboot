package com.dragon.mapper;

import com.dragon.pojo.Tuser;
import com.dragon.pojo.TuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TuserMapper {
    int countByExample(TuserExample example);

    int deleteByExample(TuserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    List<Tuser> selectByExample(TuserExample example);

    Tuser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Tuser record, @Param("example") TuserExample example);

    int updateByExample(@Param("record") Tuser record, @Param("example") TuserExample example);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
}
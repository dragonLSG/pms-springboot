package com.dragon.mapper;

import com.dragon.pojo.Tuser;
import com.dragon.pojo.TuserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TuserMapper {
    int countByExample(TuserExample example);

    int deleteByExample(TuserExample example);

    int deleteByPrimaryKey(String account);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    List<Tuser> selectByExample(TuserExample example);

    Tuser selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") Tuser record, @Param("example") TuserExample example);

    int updateByExample(@Param("record") Tuser record, @Param("example") TuserExample example);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
}
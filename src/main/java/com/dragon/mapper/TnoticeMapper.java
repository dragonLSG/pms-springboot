package com.dragon.mapper;

import com.dragon.pojo.Tnotice;
import com.dragon.pojo.TnoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TnoticeMapper {
    int countByExample(TnoticeExample example);

    int deleteByExample(TnoticeExample example);

    int deleteByPrimaryKey(Integer noticid);

    int insert(Tnotice record);

    int insertSelective(Tnotice record);

    List<Tnotice> selectByExample(TnoticeExample example);

    Tnotice selectByPrimaryKey(Integer noticid);

    int updateByExampleSelective(@Param("record") Tnotice record, @Param("example") TnoticeExample example);

    int updateByExample(@Param("record") Tnotice record, @Param("example") TnoticeExample example);

    int updateByPrimaryKeySelective(Tnotice record);

    int updateByPrimaryKey(Tnotice record);
}
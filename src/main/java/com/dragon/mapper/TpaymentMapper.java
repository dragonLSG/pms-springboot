package com.dragon.mapper;

import com.dragon.pojo.Tpayment;
import com.dragon.pojo.TpaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpaymentMapper {
    int countByExample(TpaymentExample example);

    int deleteByExample(TpaymentExample example);

    int deleteByPrimaryKey(Long paymentid);

    int insert(Tpayment record);

    int insertSelective(Tpayment record);

    List<Tpayment> selectByExample(TpaymentExample example);

    Tpayment selectByPrimaryKey(Long paymentid);

    int updateByExampleSelective(@Param("record") Tpayment record, @Param("example") TpaymentExample example);

    int updateByExample(@Param("record") Tpayment record, @Param("example") TpaymentExample example);

    int updateByPrimaryKeySelective(Tpayment record);

    int updateByPrimaryKey(Tpayment record);
}
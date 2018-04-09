package com.dragon.service.impl;

import java.util.List;

import com.dragon.mapper.TdormitoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.common.DataList;
import com.dragon.common.PageInf;
import com.dragon.pojo.Tdormitory;
import com.dragon.pojo.TdormitoryExample;
import com.dragon.pojo.TdormitoryExample.Criteria;
import com.dragon.service.DormService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DormServiceImpl implements DormService{

	@Autowired
	private TdormitoryMapper dormMapper;
	private String dormNameTrim;
	
	@Override
	public DataList findDormByArgs(Integer pageNum, Integer pageSize, String dormName)
			throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		
		TdormitoryExample example = new TdormitoryExample();
		Criteria criteria = example.createCriteria();
		if(dormName != null && dormName != ""){
			criteria.andDormitorynameLike("%"+dormName+"%");
		}
		
		List<Tdormitory> list = dormMapper.selectByExample(example);
		PageInfo<Tdormitory> pageinf = new PageInfo<Tdormitory>(list);
		
		return new DataList(list,new PageInf(pageinf));
	}

	@Override
	public Integer delDorm(String dormIds) throws Exception {

		if(null == dormIds){
			return 0;
		}
		String[] dorms = dormIds.split(",");
		int num = 0;
		for (String id : dorms) {
			num += dormMapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
		return num;
	}
}

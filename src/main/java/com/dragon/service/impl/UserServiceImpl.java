package com.dragon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.common.DataList;
import com.dragon.common.PageInf;
import com.dragon.common.UserPageInf;
import com.dragon.mapper.TuserMapper;
import com.dragon.pojo.Tuser;
import com.dragon.pojo.TuserExample;
import com.dragon.pojo.TuserExample.Criteria;
import com.dragon.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TuserMapper mapper;

	@Override
	public DataList findUsersByArgs(UserPageInf userPageInf) throws Exception {
		
		String username = userPageInf.getUsername();
		String account = userPageInf.getAccount();
		String dormitoryname = userPageInf.getDormitoryname();
		Byte status = userPageInf.getStatus();
		/* 分页 */
		PageHelper.startPage(userPageInf.getPageNum(), userPageInf.getPageSize());

		TuserExample example = new TuserExample();
		Criteria criteria = example.createCriteria();
		if (username != null && !"".equals(username)) {
			criteria.andUsernameEqualTo(username);
		}
		if (account != null && !"".equals(account)) {
			criteria.andAccountEqualTo(account);
		}
		if (dormitoryname != null && !"".equals(dormitoryname)) {
			criteria.andDormitorynameEqualTo(dormitoryname);
		}
		if (status != null && status != 2) {
			criteria.andStatusEqualTo(status);
		}
		
		List<Tuser> list = mapper.selectByExample(example);
		PageInfo<Tuser> pageinfo = new PageInfo<Tuser>(list);
		
		return new DataList(list, new PageInf(pageinfo));
	}

}

package com.dragon.service.impl;

import java.util.List;

import com.dragon.mapper.TuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.common.DataList;
import com.dragon.common.PageInf;
import com.dragon.common.model.User;
import com.dragon.pojo.Tuser;
import com.dragon.pojo.TuserExample;
import com.dragon.pojo.TuserExample.Criteria;
import com.dragon.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TuserMapper userMapper;

	@Override
	public DataList findUsersByArgs(User user) throws Exception {
		
		String username = user.getUsername();
		String account = user.getAccount();
		String dormitoryname = user.getDormitoryname();
		Byte status = user.getStatus();
		/* 分页 */
		PageHelper.startPage(user.getPageNum(), user.getPageSize());

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
		List<Tuser> list = userMapper.selectByExample(example);
		PageInfo<Tuser> pageinfo = new PageInfo<Tuser>(list);
		
		return new DataList(list, new PageInf(pageinfo));
	}

	@Override
	public Integer delUser(String accounts) throws Exception {

		if(null == accounts){
			return 0;
		}
		String[] dorms = accounts.split(",");
		int num = 0;
		for (String id : dorms) {
			num += userMapper.deleteByPrimaryKey(id);
		}
		return num;
	}
}

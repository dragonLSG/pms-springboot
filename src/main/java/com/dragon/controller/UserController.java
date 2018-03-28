package com.dragon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.common.DataList;
import com.dragon.common.PMSResult;
import com.dragon.common.UserPageInf;
import com.dragon.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping()
	public PMSResult listUsersByArgs(UserPageInf userPageInf){
		DataList list = null;
		try {
			list = userService.findUsersByArgs(userPageInf);
		} catch (Exception e) {
			return PMSResult.Fail();
		}
		return PMSResult.Ok(list,"success");
	}
	
}

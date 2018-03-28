package com.dragon.service;

import com.dragon.common.DataList;
import com.dragon.common.UserPageInf;

public interface UserService {

	DataList findUsersByArgs(UserPageInf userPageInf) throws Exception;
}

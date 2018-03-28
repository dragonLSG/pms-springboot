package com.dragon.common;

import com.dragon.pojo.Tuser;

public class UserPageInf extends Tuser{

	private Integer pageNum;
	private Integer pageSize;

	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}

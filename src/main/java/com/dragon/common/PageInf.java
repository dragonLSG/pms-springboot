package com.dragon.common;

import com.github.pagehelper.PageInfo;

public class PageInf {
	
	private long totalNum; //总记录数
	private long totalPageNum;	//总页数
	
	public PageInf(PageInfo pageInfo) {
		super();
		this.totalNum = pageInfo.getTotal();
		this.totalPageNum = (long) Math.ceil((double)this.totalNum/pageInfo.getPageSize());
	}
	public long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	public long getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(long totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	
}

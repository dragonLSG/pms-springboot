package com.dragon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.common.DataList;
import com.dragon.common.PMSResult;
import com.dragon.service.DormService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dorm")
public class DormController {
	@Autowired
	private DormService dormService;

	/**
	 * 查询 宿舍列表
	 * @param pageNum
	 * @param pageSize
	 * @param dormId
	 * @param dormName
	 * @return
	 */
	@ApiOperation(value = "获取宿舍列表", notes = "根据url的参数来获取宿舍列表")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "pageNum", value = "当前页码", dataType = "Long", paramType = "query"),
		@ApiImplicitParam(name = "pageSize", value = "每页行数", dataType = "Long", paramType = "query"),
		@ApiImplicitParam(name = "dormName", value = "宿舍名", dataType = "String", paramType = "query") 
	})
	@GetMapping()
	public PMSResult findDormByArgs(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "12") Integer pageSize,
			@RequestParam(value = "dormName", required = false) String dormName) {
		DataList list = null;
		try {
			list = dormService.findDormByArgs(pageNum, pageSize,dormName);
		} catch (Exception e) {
			e.printStackTrace();
			return PMSResult.Fail();
		}
		return PMSResult.Ok(list, "获取成功");
	}
	
	@ApiOperation(value = "删除宿舍", notes = "删除dormId对应的宿舍")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "dormId", 	value = "宿舍号", dataType = "String", paramType = "query"),
	})
	@DeleteMapping("/{dormId}")
	public PMSResult deleteDorm(
			@PathVariable(value = "dormId" ) String dormId){
		Integer num = null;
		try {
			num = dormService.delDorm(dormId);
		} catch (Exception e) {
			e.printStackTrace();
			return PMSResult.Fail();
		}
		return PMSResult.Ok(num, "获取成功");
	}
	
	@ApiOperation(value = "添加宿舍", notes = "添加新的宿舍")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "dormId", 	value = "宿舍号", dataType = "String", paramType = "query"),
	})
	@PutMapping("/{dormId}")
	public PMSResult addDorm(){
		
		
		return null;
	}
	

}

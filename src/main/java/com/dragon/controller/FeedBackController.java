package com.dragon.controller;

import com.dragon.common.DataList;
import com.dragon.common.PMSResult;
import com.dragon.common.model.FeedBack;
import com.dragon.service.FeedBackService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService service;

    @ApiOperation(value = "获取通告列表", notes = "根据分页来获取通告列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页行数", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "反馈标题", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "查询起始日期", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "查询结束日期", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "处理状态", dataType = "String", paramType = "query")
    })
    @GetMapping
    public PMSResult getFeedBackList(FeedBack feedBack){
        DataList list = null;

        try {
            list = service.getFeedbacks(feedBack);
        } catch (Exception e) {
            e.printStackTrace();
            PMSResult.Fail();
        }

        return  PMSResult.Ok(list,"success");
    }


}

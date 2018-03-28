var dormName = "";
var id = 1;
var ajaxPageInf;
var defaultIndex = [ 1, 2, 3, 4, 5 ]
$(function() {

    /*全选按钮*/
    $(".module_table thead tr th input:checkbox").click(function() {
        if ($(this).is(':checked')) {
            $("#table_" + id + " tbody input[type=checkbox]").prop("checked", true);
        } else {
            $("#table_" + id + " tbody input[type=checkbox]").prop("checked", false);
        }
    });

    /*更改每页行数，刷新列表*/
    $(".SelectEvenNum select").change(function() {

        switch (parseInt(id)) {
            case 1:
                break;
            case 2:
            	resetPagination(id, 2, defaultIndex)
            	showtable_2(getSearchUserInf("sect"),"reload")
                break;
            case 3:
                resetPagination(id, 2, defaultIndex)
                showtable_3(getPageInf(id), dormName, "reload");
                break;
            case 4:
                break;
            case 5:
                break;
        }
    });

    /* 切换menu */
    $(".ripple").click(function() {

        /*设置菜单栏切换*/
        $(".ripple").each(function() {
            $(this).removeClass("active").css({
                "background-color" : "white"
            });
        });
        $(this).addClass("active").css({
            "background-color" : "#F6F4F0"
        });

        removeALlContent();

        var menu_id = $(this).attr("id");
        id = menu_id.split("_")[1];
        switch (parseInt(id)) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                resetPagination(id, 2, defaultIndex)
                showtable_3(getPageInf(id), dormName, "reload");
                break;
            case 4:
                break;
            case 5:
                break;
        }
        $("#contentPanel > #module_" + id).css({
            "display" : "block"
        });

    });

    /********************用户管理**********************/
    /* 查询用户 */
    $("#module_2 .serchBar .btn").click(function(){
    	
        showtable_2(getSearchUserInf(),"reload");
        	
    })


    /********************宿舍管理**********************/

    /*批量删除宿舍*/
    $("#deleteBtn3").click(function() {
        var selectDormIds = "";
        var trs = $("#table_3 tbody tr");
        trs.each(function(i, item) {
            if ($(item).find("input:eq(0)").is(':checked')) {
                selectDormIds += $(item).children("td:eq(1)").text() + ",";
            }
        })
        if ("" == selectDormIds) {
            alert("请先选中要删除的记录")
            return;
        }
        selectDormIds = selectDormIds.substring(0, selectDormIds.length - 1);
        delDorm(selectDormIds)
    })

    /*查询宿舍*/
    $("#module_3 .serchBar .panel-body .btn").click(function() {
        /*select条件查询*/
        dormName = "%";
        if ($(this).is($("#module_3 .serchBar .panel-body .btn").eq(0))) {
            $("#module_3 .serch_table select option:selected").each(function(i, item) {
                dormName += item.text
            })
            dormName += $("#module_3 .serch_table input:eq(0)").val()
        }
        /*input条件查询*/
        else {
            dormName += $("#module_3 .serch_table input:eq(1)").val()
        }
        dormName += "%";
        resetPagination(id, 2, defaultIndex);
        showtable_3(getPageInf(id), dormName, "reset");
    });

    /*分页控制，下一页，上一页，最后一页。。*/
    $(".bar_3 .pagination li").click(function() {
        var pageNum = getPageInf(id).pageNum;
        var totalNum = ajaxPageInf.totalPageNum
        var selectText = $(this).find("a").text();
        if (selectText != pageNum) {
            /* 第一页 */
            if (selectText == "«") {
                resetPagination(id, 2, defaultIndex)
            }
            /* 最后一页 */
            else if (selectText == "»") {
                var index = totalNum % 5;
                index = index == 0 ? 4 : index - 1;
                var args = new Array()
                var i;
                for (i = 0; i < 5; i++) {
                    args[i] = totalNum - index + i
                }
                resetPagination(id, index + 2, args)
            }
            /* 上一页 */
            else if (selectText == "‹") {
                if (pageNum <= 5) {
                    return false;
                } else {
                    var args = new Array();
                    var links = $(".bar_3 .pagination li").find("a");
                    args[0] = links[2].innerHTML
                    args[1] = links[3].innerHTML
                    args[2] = links[4].innerHTML
                    args[3] = links[5].innerHTML
                    args[4] = links[6].innerHTML
                    var i;
                    for (i = 0; i < 5; i++) {
                        if (args[i] != "") {
                            args[i] = parseInt(args[i]) - 5;
                        }
                    }
                    resetPagination(id, 2, args)
                }
            }
            /* 下一页 */
            else if (selectText == "›") {
                if (pageNum > totalNum - 5) {
                    return false;
                } else {
                    var args = new Array();
                    var links = $(".bar_3 .pagination li").find("a");
                    args[0] = links[2].innerHTML
                    args[1] = links[3].innerHTML
                    args[2] = links[4].innerHTML
                    args[3] = links[5].innerHTML
                    args[4] = links[6].innerHTML
                    var i;
                    for (i = 0; i < 5; i++) {
                        if (args[i] != "") {
                            args[i] = parseInt(args[i]) + 5;
                        }
                    }
                    resetPagination(id, 2, args)
                }
            } else {
                $(".bar_3 .pagination li").removeClass("active");
                $(this).addClass("active");
            }
            showtable_3(getPageInf(id), dormName, "reset");
        }
    })

    /*遮盖层*/
    $("#module_3").mLoading({
        text : "", //加载文字，默认值：加载中...
        icon : "", //加载图标，默认值：一个小型的base64的gif图片
        html : false, //设置加载内容是否是html格式，默认值是false
        content : "", //忽略icon和text的值，直接在加载框中显示此值
        mask : true //是否显示遮罩效果，默认显示
    });

    /********************通告管理**********************/
})



/****************************公共function**********************************/
/*获取分页信息*/
function getPageInf(module_id) {
    var pageNum = $(".bar_" + module_id + " .pagination").find("li.active").text();
    var pageSize = $(".bar_" + module_id + " .SelectEvenNum select").find("option:selected").text();

    var pageInf = {
        pageNum : pageNum,
        pageSize : pageSize
    }
    return pageInf;
}

/*设置分页状态，args[0]~args[4]页，activeIndex页active*/
function resetPagination(id, activeIndex, args) {
    var li = $(".bar_" + id + " .pagination li");
    li.removeClass("active");
    li[activeIndex].className = "active"
    var links = $(li).find("a");
    links[2].innerHTML = args[0]
    links[3].innerHTML = args[1]
    links[4].innerHTML = args[2]
    links[5].innerHTML = args[3]
    links[6].innerHTML = args[4]
}

/* 隐藏内容区域 */
function removeALlContent() {
    $("#contentPanel").children().each(function() {
        $(this).css({
            "display" : "none"
        });
    });
}

/*****************************用户管理function********************************/
function getSearchUserInf(option){
	var pageInf = getPageInf(2);
    var username = "";
    var account = "";
    var	dormname = "";
    var status = "2";
	if(option == "sect"){
		var inputs = $("#module_2 .serch_table input");
	    username = inputs.eq(0).val();
	    account = inputs.eq(1).val();
	    dormname = inputs.eq(2).val();
	    status = $("#module_2 .serch_table select option:selected").eq(0).attr("id");
	}
    var userSearchInf = {pageNum:pageInf.pageNum,pageSize:pageInf.pageSize,
        username:username,account:account,dormitoryname:dormname,status:status}
    return userSearchInf;
}

function showtable_2(args,option){
	
	$("#table_2 tbody").empty(); //清空tbody
    $("#table_2 thead input[type=checkbox]").prop("checked", false);
    $.ajax({
        type : 'GET',
        url : '/user',
        dataType : 'json',
        timeout : '10000',
        data : args,
        success : function(result, status) {
        	if (status == "success" && result != null) {
                var trs = null;
                var data = result.data;
                if (option == "reload") {
                    $.each(data.data, function(key, value) {
                    	var stat_str = value.status == 1 ? "在校":"离校";
                        trs += "<tr><td><input type='checkbox'></td><td>" + value.account +
                            "</td><td>" + value.username + "</td><td>" + value.dormitoryname +
                            "</td><td>" + value.mobile + "</td><td>" + value.email +
                            "</td><td>" + stat_str + "</td><td><a href='javascript:delUser(" + value.dormitoryid +
                            ")'>删除</a><a href='#'>编辑</a></td></tr>"

                    })
                    $("#table_2 tbody").append(trs);
                } else if (option == "reset") {
                    var trs = $("#table_2 tbody tr");
                    var len = trs.length;
                    var i;
                    for (i = 0; i < len; i++) {
                        var tds = trs[i].childNodes;
                        if (typeof (data.data[i]) != "undefined") {
                            tds[0].innerHTML = "<input type='checkbox'>"
                            tds[1].innerHTML = data.data[i].dormitoryid;
                            tds[2].innerHTML = data.data[i].dormitoryname;
                            tds[3].innerHTML = data.data[i].balance;
                            tds[4].innerHTML = "<a href='javascript:void(0);' onclick='delDorm(" + data.data[i].dormitoryid + ")'>删除</a><a href='#'>编辑</a>"
                        } else {
                            tds[0].innerHTML = ""
                            tds[1].innerHTML = ""
                            tds[2].innerHTML = ""
                            tds[3].innerHTML = ""
                            tds[4].innerHTML = ""
                        }
                    }
                }
                ajaxPageInf = data.pageInf;
                $(".bar_2 .sumNum").text("共" + ajaxPageInf.totalNum + "条数据");
            }
        }
    })
}

/*****************************宿舍管理function********************************/

/*删除宿舍*/
function delDorm(dormIds) {
    if (!confirm("确定删除选中的记录么？")) {
        return;
    }
    $("#module_3").mLoading("show");
    var url = "/dorm/" + dormIds;
    $.ajax({
        type : 'delete',
        url : url,
        dataType : 'json',
        timeout : '10000',
        success : function(data, status) {
            if (status == "success") {
                alert("共" + data.data + "条记录，删除成功!")
                showtable_3(getPageInf(id), dormName, "reset");
            }
        }
    })
    $("#module_3").mLoading("hide");
}

/*获取宿舍列表*/
function showtable_3(pageInf, dormName, option) {
    if (option == "reload") {
        $("#module_3").mLoading("show");
        $("#table_3 tbody").empty(); //清空tbody
    }
    $("#table_3 thead input[type=checkbox]").prop("checked", false);
    var args = {
        pageNum : pageInf.pageNum,
        pageSize : pageInf.pageSize,
        dormName : dormName
    }
    $.ajax({
        type : 'GET',
        url : '/dorm',
        data : args,
        dataType : 'json',
        timeout : '10000',
        success : function(result, status) {
            if (status == "success" && result != null) {
                var trs = null;
                var data = result.data;
                if (option == "reload") {
                    $.each(data.data, function(key, value) {
                        trs += "<tr><td><input type='checkbox'></td><td>" + value.dormitoryid +
                            "</td><td>" + value.dormitoryname + "</td><td>" + value.balance +
                            "</td><td><a href='javascript:delDorm(" + value.dormitoryid +
                            ")'>删除</a><a href='#'>编辑</a></td></tr>"

                    })
                    $("#table_3 tbody").append(trs);
                } else if (option == "reset") {
                    var trs = $("#table_3 tbody tr");
                    var len = trs.length;
                    var i;
                    for (i = 0; i < len; i++) {
                        var tds = trs[i].childNodes;
                        if (typeof (data.data[i]) != "undefined") {
                            tds[0].innerHTML = "<input type='checkbox'>"
                            tds[1].innerHTML = data.data[i].dormitoryid;
                            tds[2].innerHTML = data.data[i].dormitoryname;
                            tds[3].innerHTML = data.data[i].balance;
                            tds[4].innerHTML = "<a href='javascript:void(0);' onclick='delDorm(" + data.data[i].dormitoryid + ")'>删除</a><a href='#'>编辑</a>"
                        } else {
                            tds[0].innerHTML = ""
                            tds[1].innerHTML = ""
                            tds[2].innerHTML = ""
                            tds[3].innerHTML = ""
                            tds[4].innerHTML = ""
                        }
                    }
                }
                ajaxPageInf = data.pageInf;
                $(".bar_3 .sumNum").text("共" + ajaxPageInf.totalNum + "条数据");
                $("#module_3").mLoading("hide");
            }
        },
        error : function(status) {
            $("#module_3").mLoading("hide");
            alert("请求失败！")
        }
    });
}
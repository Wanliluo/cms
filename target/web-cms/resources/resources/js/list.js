var setting = {
    data: {  
        simpleData: {  
            enable: true  
        }  
    } ,
    async: {
        enable: true,
        type: "get",
        url:"http://localhost:8080/category/ajax/list",
        autoParam:["id", "name=n", "level=lv"],
        otherParam:{"otherParam":"zTreeAsyncTest"},
        dataFilter: filter
    }
};

function filter(treeId, parentNode, childNodes) {
    if (!childNodes) return null;
    for (var i=0, l=childNodes.length; i<l; i++) {
        childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
    }
    return childNodes;
}

//分页
var pageIndex = 0;     //页面索引初始值
var pageSize = 10;     //每页显示条数初始化，修改显示条数，修改这里即可
var IsInit = true;//初始化
$(document).ready(function(){
    var dataCount = $("#count").val();

    //初始生成树
	$.fn.zTree.init($("#treeDemo"), setting);
    //初始化分页数据
    //InitData(0);

    // 创建分页
    console.log(dataCount);
    var initPagination = function(Count){
        $("#Pagination").pagination(Count, {
            num_edge_entries: 2, //边缘页数
            num_display_entries: 4, //主体页数
            callback: pageselectCallback,
            items_per_page: pageSize, //每页显示
            current_page: pageIndex,   //当前页索引
            prev_text: "<前一页",
            next_text: "后一页>"
        });
    };
    initPagination(dataCount);
    //定义回调函数
    function pageselectCallback(page_index, jq){
        if (IsInit) {
            InitData(page_index + 1);
        }else{
            search(page_index);
        }

        return false;
    };

    //定义初始函数
    function InitData(pageIndex) {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/article/ajax/list",
            dataType: "json",
            async: false,
            data: "page=" + (pageIndex),//pageIndex(页面索引)
            success : function(rs){
                $("#count").val(rs.dataCount);
                $('#resText').empty();
                var html = '';
                $.each(rs.data, function(i, n) {
                    html += '<tr><td class="none">' + n.id + '</td><td>'+ n.categoryName + '</td><td>' + n.title + '</td><td>' + n.weight + '</td><td>' + n.clicks + '</td><td>' + n.author + '</td><td>' + n.time + '</td><td></a><a target="blank" href="http://localhost:8080/article/todetail/' + n.id + '"><i></i>' +"查看"+ '<a id="alter" href="javascript:;"><i></i>' +"修改" +'</a><a href="javascript:;" id="del"><i></i>删除</a></td></tr>';
                });
                $('#resText').html(html);
            }
        });
    }

    //条件查询
    $("#search").click(function() {
    	var column = $(this).siblings("select").children('option:selected').val();
    	var value = $(this).prev().val();
        search(pageIndex,{categoryId:column,title:value,page:pageIndex + 1});
    });
    //ztree条件搜索
    $("#treeDemo").delegate("a", "click", function() {
        var text = $(this).text();
        search(pageIndex,{categoryName:text,page:pageIndex + 1});
    });
    function search(pageIndex,data) {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/article/ajax/list",
            dataType: "json",
            data: data,
            success : function(rs){
                if (IsInit) {
                    initPagination(rs.dataCount);
                    IsInit = false;
                }
                $('#resText').empty();
                var html = '';
                $.each(rs.data, function(i, n) {
                    html += '<tr><td class="none">' + n.id + '</td><td>'+ n.categoryName + '</td><td>' + n.title + '</td><td>' + n.weight + '</td><td>' + n.clicks + '</td><td>' + n.author + '</td><td>' + n.time + '</td><td></a><a target="blank" href="http://localhost:8080/article/todetail/' + n.id + '"><i></i>' +"查看"+ '<a id="alter" href="javascript:;"><i></i>' +"修改" +'</a><a href="javascript:;" id="del"><i></i>删除</a></td></tr>';
                });
                $('#resText').html(html);
            }
        });
    }

    
    //选项卡
    $(".listTab").click(function() {
    	$(this).addClass("current").next().text("文章添加").removeClass("current");
    	$(".articleList,.addTab").show();
    	$(".articleAdd,.articleAlter").hide();
    });
    $(".addTab").click(function() {
    	$(this).addClass("current").prev().removeClass("current");
    	$(".articleAdd").show();
    	$(".articleList,.articleAlter").hide();
    });

    //    删除
    $("tbody").delegate("#del", "click", function() {
        var _confirm = confirm('确定要删除吗？');
        var deltest = $(this).parents('tr');
        var id = deltest.children("td:first-child").text();
        if(_confirm){
            $.ajax({
                type: "get",
                url: "http://localhost:8080/article/ajax/delete",
                dataType: "json",
                data: "id=" + id,
                success : function(data){
                    if(data.code == 1){
                        deltest.remove();
                    }else{
                        alert("删除失败，请重试");
                    }
                    InitData(0);
                }
            });
        }
    });

    //修改
    $("tbody").delegate("#alter", "click", function() {
        $(".addTab").text("文章修改").addClass("current").prev().removeClass("current");
        $(".articleAlter").show();
        $(".articleList,.articleAdd").hide();
        var id = $(this).parents('tr').children("td:first-child").text();
        $.ajax({
            type: "get",
            url: "http://localhost:8080/article/ajax/toupdate",
            dataType: "json",
            data: "id=" + id,
            success : function(rs){
                var colVal = rs.data.categoryName;
                $(".articleAlter select option").each(function(){
                    if($(this).text() == colVal){
                        $(this).attr("selected",true);
                    }
                });
                $(".articleAlter input[name=articleId]").val(rs.data.id);
                $(".articleAlter input[type=text]").val(rs.data.title);
                $(".articleAlter textarea").val(rs.data.content);
            }
        });
    });
});
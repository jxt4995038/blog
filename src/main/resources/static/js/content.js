//加载内容的时候加载左侧内容以及右侧内容
$(document).ready(function(){
    //加载左侧内容
    loadContentLeft();
    //加载右侧内容
    loadContentRright();
    //加载博文内容
    initBlogList();
});

function loadContentLeft(){
    $("#content_left").load("http://127.0.0.1:8088/toHtml/content_left")
}

function loadContentRright(){
    $("#content_right").load("http://127.0.0.1:8088/toHtml/content_right")
}

function initBlogList(){
    //1、隐藏回复框的div
    // $("#reply").hide();
    // $("#replyInfo").hide();
    //2 设置右侧博客的内容
    var blogType = $("#blogType").val();
    var pageIndex = $("#pageIndex").val();
    var pageSize = $("#pageSize").val();

    $.ajax({
        url:"http://127.0.0.1:8088/blog/showBlogs",
        data:{"blogTypeIds":blogType,"pageIndex":pageIndex,"pageSize":pageSize},
        type:"post",
        dataType:"json",
        success:function(result){
            var htmlInfo = ""
            //将内容放到内容框中
            if (result.data.length==0){
                htmlInfo+="没有该类型的博文";
            }else {
                for(var i =0;i<result.data.length;i++){
                    var obj =  (result.data)[i];
                    htmlInfo += "<div class='panel panel-default'>" +
                        "                    <div class='panel-heading'>" +
                        "                    <a href='#' onclick= 'showInfo("+obj.id+")' >"+obj.title+"</a>" +
                        "                    </div>" +
                        "                    <div class='panel-body'>" +
                        "                    <p>"+obj.contentHtml+"</p>" +
                        "                    <p class='pull-right'>" +
                        "                    <span>标签：<a href='#'>"+obj.typeId+"</a></span>" +
                        "                <span>发布日期："+obj.createTime+"</span>" +
                        "                </p>" +
                        "                </div>" +
                        "                </div>"
                }
            }
            $("#blogInfo").html(htmlInfo);
            //是否显示分页栏
            if(result.data.length>=pageSize){
                $("#page").show();
            }
        },
        error:function (result) {
            alert(result);
        }
    })
}

//根据标题显示博文的具体内容
function showInfo(id){
    //1、显示回复框
    $("#reply").show();
    $("#replyInfo").show();
    //2、查询某篇博客
    $.ajax({
        url:"http://127.0.0.1:8088/blog/showBlogById",
        type:"post",
        data:{"id":id},
        dataType:"json",
        success:function(data){
            // 1 查询
            var info = ""
            info +="<div class='panel panel-default' id='blogContent'><div class='panel-heading'><a href='#' onclick='showInfo("+id+")'>";
            info += data.data.title;
            info += "</a>";
            info +="</div><div class='panel-body'><p>"
            info+=data.data.contentHtml;
            info+="</p><p class='pull-right'><span>标签：<a href='#' onclick='initBlogList("+data.data.typeId+")'>"+data.data.typeId+"</a></span>"+
                "<span>发布日期："+data.data.createTime+"</span>"+
                "</p></div></div>"
            //追加一个隐藏表单，存博客id的值
            info+="<input type='hidden' id='blogId' value='"+id+"' />"

            $("#blogInfo").html(info);

            // 2 显示回复框
            $("#replyInfo").load("http://127.0.0.1:8088/toHtml/replyInfo");
        },
        error:function(result){
            alert("error");
        }
    })
}

//提交回复
function submitReply(data_html,data_text){
    if (data_text == "Please input ..."||$.trim(data_text) ==""){
        alert("请输入评论内容")
    }else {
        var blogId = $("#blogId").val();
        //TODO userId暂时是写死的
        $.ajax({
            url:"http://127.0.0.1:8088/blogReply/addReply",
            data:{"blogId":blogId,"data_html":data_html,"userId":0},
            type:"post",
            success:function(result){
                //添加成功后查询该评论，并将倒序评论显示出来

            },
            error:function(){
                alert("error");
            }
        })
    }
}


//查看某博客的回复内容
function showReplyByBlogId(id){
    $.ajax({
        url:"http://127.0.0.1:8088/blogReply/showReplyByBlogId",
        data:{"blogId":blogId},
        type:"post",
        dataType:"json",
        success:function(result){

        },
        error:function(result){

        }

    })
}




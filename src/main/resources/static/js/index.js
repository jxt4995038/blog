//设置首页内容部分div的高度
function setHeight(){
    //设置首页左侧div的高度=右侧div的高度
    var right_height = $("#content_right").height();
    $("#content_left").height(right_height);
    //设置左侧各个部分内容所占左侧div的百分比

    //头像占40% 推荐占40% 统计占20%
    $("#content_left_top").height(right_height*0.4);
    $("#content_left_middle").height(right_height*0.4);
    $("#content_left_foot").height(right_height*0.2);
}


//根据标题显示博文的具体内容
function showInfo(){
     //获取左侧div的高度，使右侧div高度等于左侧div高度
     var leftHeight = $("#content_left").height();
     $.ajax({
         url:"http://47.93.247.41:8088/blog-1.0-SNAPSHOT/test?id=1",
         type:"get",
         dataType:"json",
         success:function(data){
             //将查询到的结果放到右侧的div中
            var info = ""
            info +="<div class='panel panel-default' id='blogContent'><div class='panel-heading'><a href='#' onclick='showInfo()'>";
            info += data.data.id;
            info += "</a>";
            info +="</div><div class='panel-body'><p>"
            info+=data.data.name;
            info+="</p><p class='pull-right'><span>标签：<a href='#'>JAVA</a></span>"+
                             "<span>发布日期：2017-09-09 12:00:00</span>"+
                         "</p></div></div>"
             $("#content_right").html(info);
             var right_height = $("#content_right").height();
             if(right_height<leftHeight){
                $("#content_right").height(leftHeight);
                $("#blogContent").height(leftHeight-20);
             }
             else{
                $("#content_left").height(right_height);
                //头像占40% 推荐占40% 统计占20%
                $("#content_left_top").height(right_height*0.4);
                $("#content_left_middle").height(right_height*0.4);
                $("#content_left_foot").height(right_height*0.2);
             }



         },
         error:function(XMLHttpRequest, textStatus, errorThrown){
            alert("error");
         }
     })
}
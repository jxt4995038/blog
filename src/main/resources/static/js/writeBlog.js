function initWriteBlogType(){
    alert("进入了查询博客类型的方法")
    $.ajax({
        url:url_server+"blogType/showAllTypesWithoutMapping",
        type:"post",
        dataType:"json",
        success:function (result) {
            console.info(result.data.length);
            var htmlInfo = "";
            for (var i =0;i<result.data.length;i++){
                var obj = (result.data)[i];
                var id = obj.key;
                var typeName = obj.value;
                htmlInfo+="<option id = '"+id+"'>"+typeName+"</option>"
            }
            $("#blogType").html(htmlInfo);
        },
        error:function(){
            alert("the page of writeBlog has a error status")
        }
    })
}

function submitBlog(data_html,data_text){
    var blogTitle = $("#blogTitle").val();
    //TODO 创建博文的userId先写死
    var createUserId = 1;
    //TODO 博文类型先写死
    var blogType = 1;

    if($.trim(blogTitle)==""){
        alert("请输入标题");
        $("#blogTitle").addClass("has-error");
    }else if (data_text == "Please input ..."||$.trim(data_text) ==""){
        //校验有没有输入
            alert("请输入内容")
    }else {
        $.ajax({
            url:url_server+"blog/blogAdd",
            type:"post",
            dataType:"json",
            data:{"data_html":data_html,"data_text":data_text,"blogTitle":blogTitle,"createUserId":1,"blogType":1},
            success:function(result){
                alert("success");
                //清除内容
                $("#blogTitle").val("");
                editor.txt.text("Please input ...");
            },
            error:function(){
                alert("error")
            }

        })
    }



}
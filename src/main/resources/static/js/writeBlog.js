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
            url:"http://127.0.0.1:8088/blog/blogAdd",
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
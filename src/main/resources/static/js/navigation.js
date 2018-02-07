//初始化导航栏
function initNavBar(){
    var blogType = $("#blogType").val();
    var pageIndex = $("#pageIndex").val();
    var pageSize = $("#pageSize").val();

    $.ajax({
        url:"http://127.0.0.1:8088/blogType/showAllTypes",
        type:"post",
        data:{},
        success:function(result){
            var htmlInfo = "<nav class='navbar navbar-default' role='navigation'>" +
                "<div class='container-fluid'>" +
                "<div class='navbar-header'>" +
                "<a class='navbar-brand' href='#' onclick='initBlogList()'>首页</a>" +
                "</div>" +
                "<div id='navBar'>" +
                "<ul class='nav navbar-nav'>";
            for(var key in result.data ){
                if((result.data)[key] instanceof Array){
                    var name = key.split(",")[1];
                    var id = key.split(",")[0];
                    htmlInfo+="<li class='dropdown'>" +
                        "<a href='initBlogList(id)' class='dropdown-toggle' data-toggle='dropdown'>"+name+"<b class='caret'></b></a>" +
                        "<ul class='dropdown-menu'>";
                    for (var j =0;j<(result.data)[key].length;j++){
                        for (var innerKey in (result.data)[key][j]){
                            id = innerKey;
                            name = ((result.data)[key][j])[innerKey];
                            htmlInfo+="<li><a href='#' onclick=loadContent("+id+")>"+name+"</a></li>"
                            // alert("id="+id+",name="+name);
                        }
                    }
                    htmlInfo+="</ul></li>"
                }else {
                    var id = key.split(",")[0];
                    var name = key.split(",")[1];
                    htmlInfo+="<li><a href='#' onclick=loadContent("+id+")>"+name+"</a></li>"
                    // alert("id="+id+",name="+name);
                }
            }
            htmlInfo+="<li><a href='#' onclick='loadWriteBlog()'>写博客</a></li>"
            $("#navigation").html(htmlInfo);
        },
        error:function(result){
            alert("error")
        }
    })
}
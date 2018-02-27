function initIndex(){

    //初始化导航栏
    initNavBar();
    //显示博文列表及内容
    loadContent();
}

function  loadContent(id) {
    $("#content").load("http://127.0.0.1:8088/toHtml/content")
}

function loadWriteBlog(){
    $("#content").load("http://127.0.0.1:8088/toHtml/writeBlog")
}
function initIndex(){

    //初始化导航栏
    initNavBar();
    //显示博文列表及内容
    loadContent();
}

function  loadContent(id) {
    $("#content").load(url_server+"toHtml/content")
}

function loadWriteBlog(){
    $("#content").load(url_server+"toHtml/writeBlog")
}
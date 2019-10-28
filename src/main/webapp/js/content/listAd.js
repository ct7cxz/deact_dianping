/*删除广告*/
function adDelete(id,pageCurrent) {
    var val = $("#path").val();
    var choice = confirm("是否要删除!");
    if(choice){
        console.log(pageCurrent);
        location.href=val+"/ad/adDelete?id="+id+"&pageCurrent="+pageCurrent;
    }
}

/*展示要修改的广告*/
function adUpdate(id) {
    var val = $("#path").val();
    location.href=val+"/ad/showAdUpdate?id="+id;
}

//跳转到新增广告界面
function toAdd() {
    var val = $("#path").val();
    console.log(val+"/ad/saveAd");
    /*location.href=val+"/ad/saveAd";*/
}

//分页跳转
function forward(pageCurrent) {
    var val = $("#path").val();
    location.href=val+"/ad/listAd?page.pageCurrent="+pageCurrent;
}
/*提示信息*/
$(function () {
    var message = $("#message").val();
    common.showMessage(message);
})

/*分页查询*/
function search(path) {
    $("#mainForm").attr("action",path+"/ad/listAd");
    console.log(path+"/ad/listAd");
    $("#mainForm").submit();
}

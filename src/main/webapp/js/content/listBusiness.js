function forward(pageCurrent) {
    var path=$("#path").val();
    location.href=path+"/business/listBusiness?page.pageCurrent="+pageCurrent;
}
/*提示信息*/
$(function () {
    var message = $("#message").val();
    common.showMessage(message);
})

/*获得修改用户的初始信息*/
function updateBusiness(id) {
    var path=$("#path").val();
    $("#method").attr("value","GET");
    $("#mainForm").attr("method","get");
    $("#mainForm").attr("action",path+"/business/"+id);
    $("#mainForm").submit();
}

/*删除用户信息*/
function deleteBusiness(id,pageCurrent) {
    var path=$("#path").val();
    $("#method").attr("value","DELETE");
    $("#mainForm").attr("action",path+"/business/"+id+"/"+pageCurrent);
    $("#mainForm").submit();
}
/*分页查询*/
function search() {
    var path=$("#path").val();
    $("#mainForm").attr("action",path+"/business/listBusiness");
    $("#mainForm").submit();
}
/*
//表单校验
$(function () {
    $("#mainForm").validate({
        rules: {
            title: "required",
            subtitle: "required"
        },
        message: {
            title: "请输入标题",
            subtitle: "请输入副标题"
        }
    });
})
*/

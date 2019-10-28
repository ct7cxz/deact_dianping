/*将请求转发新增商户信息界面*/
function addBusiness() {
    var path = $("#path").val();
    $("#mainForm").attr("action", path + "/business/addBusiness");
    $("#mainForm").submit();
}

/*返回修改商户信息界面*/
function back(path) {
    location.href=path+"/business/listBusiness";
}

/*响应信息*/
$(function () {
    var message = $("#message").val();
    common.showMessage(message);
})
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
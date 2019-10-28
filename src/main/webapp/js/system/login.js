$(function () {
    $("#mainForm").validate({
        rules:{
            name:"required",
            password:"required",
        },
        message:{
            name:"请输入用户名",
            password:"请输入密码",
        }
    })
})
function sub() {
    if($("#password").val()){
        $("#password_md5").val($("#password").val());
    }
    $("#mainForm").submit();
}

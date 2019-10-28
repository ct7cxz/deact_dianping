$(function () {
    var message = $("#message").val();
    common.showMessage(message);
})

function addAd() {
    $("#mainForm").submit();
}

function back(val) {
    location.href=val+"/ad/listAd";
}

//表单的详细校验信息
$(function () {
    $("#mainForm").validate({
        rules:{
            title:"required",
            link:"url",
            weight:{
                required:true,
                digits:true,
                maxlength:5
            }
        },
        message:{
            title:"请输入标题",
            link:"请输入有效链接",
        }
    });
})
function check() {
    $("#mainForm").submit();
}
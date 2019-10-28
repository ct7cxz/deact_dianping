$(function () {
    $("#mainForm").validate({
        rules:{
            title:"required",
            imgFile:"required",
            link:"url",
            weight:{
                required:true,
                digits:true,
                maxlength:5
            }
        },
        message:{
            title:"请输入标题",
            imgFile:"请上传图片",
            link:"请输入有效链接",
        }
    });
})
function back(val) {
    location.href=val+"/ad/listAd";
}
function check() {
    $("#mainForm").submit();
}
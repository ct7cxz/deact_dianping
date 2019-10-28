/*提交表单到商户修改controller*/
function updateBusiness() {
    var id = $("#id").val();
    var path = $("#path").val();
    $("#forward").attr("value","PUT");
    $("#mainForm").attr("action",path+"/business/"+id);
    $("#mainForm").submit();
}

/*返回到列表界面*/
function back(path) {
    $("#forward").attr("value","POST");
    $("#mainForm").attr("action",path+"/business/listBusiness");
    $("#mainForm").submit();
}
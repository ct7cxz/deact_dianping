<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
</head>
<%--新增广告界面--%>
<body style="background: #e1e9eb;">
<form id="mainForm" method="post" enctype="multipart/form-data">
    <div class="right">
        <div class="current">当前位置：<a href="###">内容管理</a> &gt; 广告管理</div>
        <div class="rightCont">
            <p class="g_title fix">新增广告</p>
            <table class="tab1" width="100%">
                <tbody>
                <tr>
                    <td align="right" width="10%">标题<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="title" placeholder="请输入广告标题" name="title" class="allInput" style="width:100%;"
                               type="text"/>
                    </td>
                    <td align="right" width="10%">上传图片<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="img_file_name" name="img_file_name" class="allInput" style="width:100%;"
                               type="file"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">链接地址<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="link" name="link" placeholder="http://www.imooc.com/wap/index" class="allInput"
                               style="width:100%;" type="text"/>
                    </td>
                    <td align="right" width="10%">权重(越大越靠前)<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="weight" placeholder="请输入图片权重（数字）" name="weight" class="allInput" style="width:100%;"
                               type="text"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 30px;">
                <input class="tabSub" value="保     存" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="tabSub" value="返     回" type="button"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>
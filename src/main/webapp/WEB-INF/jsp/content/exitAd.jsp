<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 19-10-2
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/common/validate.css"/>
    <script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/messages_zh.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/common.js"></script>
    <script type="text/javascript" src="${basePath}/js/content/adExit.js"></script>

</head>
<%--修改广告界面--%>
<body style="background: #e1e9eb;">
<form id="mainForm" method="post" enctype="multipart/form-data" action="${basePath}/ad/updateAd" id="addForm">
    <div class="right">
        <div class="current">当前位置：<a href="###">内容管理</a> &gt; 广告管理</div>
        <div class="rightCont">
            <p class="g_title fix">新增广告</p>
            <table class="tab1" width="100%">
                <tbody>
                <tr>
                    <td align="right" width="10%">标题<font color="red">*</font>：</td>
                    <td width="30%">
                        <input name="id" value="${ad.id}" type="hidden">
                        <input id="title" value="${ad.title}" name="title" class="allInput" style="width:100%;" type="text"/>
                    </td>
                    <td align="right" width="10%">上传图片<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="imgFile" name="imgFile" class="allInput" style="width:100%;" type="file"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">链接地址<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="link" name="link" value="${ad.link}" class="allInput"
                               style="width:100%;" type="text"/>
                    </td>
                    <td align="right" width="10%">权重(越大越靠前)<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="weight" value="${ad.weight}" name="weight" class="allInput" style="width:100%;" type="text"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 30px;">
                <input class="tabSub" value="保     存" type="submit" onclick="addAd()"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="tabSub" value="返     回" type="button" onclick="back('${basePath}')"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>

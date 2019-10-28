<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="${basePath}/js/content/exitBusiness.js"></script>
</head>
<%--修改商户界面--%>
<body style="background: #e1e9eb;">
<form id="mainForm" method="post" enctype="multipart/form-data" action="${basePath}/ad/updateAd" id="addForm">
    <input id="id" name="id" value="${business.id}" type="hidden">
    <input id="path" value="${basePath}" type="hidden">
    <input name="_method" type="hidden" id="forward">
    <div class="right">
        <div class="current">当前位置：<a href="###">商户管理</a> &gt; 修改商户</div>
        <div class="rightCont">
            <p class="g_title fix">修改商户</p>
            <table class="tab1" width="100%">
                <tbody>
                <tr>
                    <td align="right" width="10%">标题<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="title" value="${business.title}" name="title" class="allInput" style="width:100%;"
                               type="text"/>
                    </td>
                    <td align="right" width="10%">副标题<font color="red">*</font>：</td>
                    <td width="30%">
                        <input id="subtitle" value="${business.subTitle}" name="subTitle" class="allInput"
                               style="width:100%;" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">城市<font color="red">*</font>：</td>
                    <td width="30%">
                        <select name="city">
                            <c:forEach items="${citys}" var="city">
                                <option value="${city.code}">${city.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td align="right" width="10%">类别<font color="red">*</font>：</td>
                    <td width="30%">
                        <select name="category">
                            <c:forEach items="${categorys}" var="category">
                                <option value="${category.code}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">上传图片<font color="red">*</font>：</td>
                    <td width="30%">
                        <input type="file" name="file">
                        <input type="hidden" name="imgFileName" value="${business.imgFileName}">
                    </td>
                    <td>
                        <a href="#">查看图片</a>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">价格（单位：元）<font color="red">*</font>：</td>
                    <td width="30%">
                        <input type="text" name="price" value="${business.price}" class="allInput"
                               style="width:100%;">
                    </td>
                    <td align="right" width="10%">距离（单位：米）<font color="red">*</font>：</td>
                    <td width="30%">
                        <input type="text" name="distance" value="${business.distance}" class="allInput"
                               style="width:100%;">
                    </td>
                </tr>
                <tr>
                    <td align="right" width="10%">描述<font color="red">*</font>：</td>
                    <td>
                        <textarea name="descs" style="width:200%;">${business.desc}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 30px;">
                <input class="tabSub" value="保     存" type="button" onclick="updateBusiness()"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="tabSub" value="返     回" type="button" onclick="back('${basePath}')"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>

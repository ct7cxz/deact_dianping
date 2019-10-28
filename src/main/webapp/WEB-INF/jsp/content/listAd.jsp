<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
    <script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${basePath}/js/content/listAd.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/common.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="" id="mainForm" method="post">
    <input type="hidden" value="${pageCode.msg}" id="message"/>
    <div class="right">
        <div class="current">当前位置：<a href="#">内容管理</a> &gt; 新增广告</div>
        <div class="rightCont">
            <p class="g_title fix">广告列表</p>
            <table class="tab1">
                <tbody>
                <tr>
                    <td align="right" width="80">标题：</td>
                    <td>
                        <input id="title" name="title" class="allInput" type="text"/>
                    </td>
                    <td style="text-align: right;" width="150">
                        <input class="tabSub" value="查询" onclick="search('${basePath}')" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="tabSub" value="添加" onclick="window.location.href='${basePath}/index/addAd'" type="button"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="zixun fix">
                <table class="tab2" width="100%">
                    <tbody>
                    <tr>
                        <th>序号</th>
                        <th>标题</th>
                        <th>链接地址</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${list}" var="ad" varStatus="i">
                        <tr>
                            <td>${i.count+(page.pageCurrent)*page.pageNumber}</td>
                            <td>${ad.title}</td>
                            <td>${ad.link}</td>
                            <td>
                                <a href="javascript:void(0);" onclick="adUpdate('${ad.id}')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="javascript:void(0);" onclick="adDelete('${ad.id}','${page.pageCurrent}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <input type="hidden" value="${basePath}" id="path"/>
                <!-- 分页 -->
                <t:page page="${page}" jsMethodName="forward"></t:page>
            </div>
        </div>
    </div>
</form>
</body>
</html>
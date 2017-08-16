<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="css/jeui.css"  media="all">
    <link rel="stylesheet" href="css/admin.css"  media="all">
    
</head>
<body class="loginbox">
    <div class="je-login"></div>
    <div class="je-logincon">
        <div class="logo"></div>
        <p class="logtext">欢迎登录后台管理系统</p><p style="color:red;">${message }</p>
        <form:form action=""  commandName="user" method="POST" id="url_id"> 
        <p class="je-pb10"><form:input path="username" class="userinp" placeholder="请输入用户名" /><form:errors path="username" cssClass="error"/></p>
        <p class="je-pb10"><form:password path="password" class="userinp" placeholder="请输入密码" /><form:errors path="password" cssClass="error"/></p>
        <p class="je-pt10"><form:button class="userbtn" name="button">确 认 登 录</form:button></p>
        </form:form>
    </div>
</body>
</html>
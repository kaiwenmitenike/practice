<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <title>je-table</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/jeui.css"  media="all">
    <script type="text/javascript" src="js/modules/jquery.min.js"></script>
    <script type="text/javascript" src="js/modules/jeTable.js"></script>
    <script type="text/javascript" src="js/userdata.js"></script>
    <script type="text/javascript" src="englishJs/readArticle.js"></script>
    <style>
        .je-field .je-btn {
            margin: 0 7px 10px 0;
        }
        .wordlist{
        	color:#BBFF00;
        }
    </style>
</head>
  
  <body>
  <div class="je-p20">
    <input type="hidden" value="<%=request.getContextPath() %>" id="context_path"/>
    <input type="hidden" value="<%=request.getParameter("id") %>" id="articleId"/>
    <blockquote class="je-quote je-f16">
    		<span class="wordlist">英文作文</span>
    </blockquote>
    	<input type="hidden" value="1" name="status" id="statusId"/>
     <div class="je-form-pane">
    <div class="je-form-item">
        <label class="je-label je-f14">英文作文标题</label>
        <div class="je-inputbox">
            <input type="text" name="title" id="title" autocomplete="off" placeholder="请输入英文作文标题" class="je-input" readonly>
        </div>
    </div>
    </div>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14">英文作文文章</label>
        <textarea placeholder="请输入英文作文文章" name="article" id="article" class="je-textarea2" readonly></textarea>
        <textarea placeholder="请输入英文作文文章" name="article" id="article2" class="je-textarea2" readonly></textarea>
        </div>
    </div>
 </div>
  </body>
</html>

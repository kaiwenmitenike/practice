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
    <script type="text/javascript" src="englishJs/addArtice.js"></script>
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
    <blockquote class="je-quote je-f16">
    		<span class="wordlist">英文作文</span>
    		<button class="je-btn je-bg-native je-rdu" id="addArticle">添加英文作文</button>
    		<button class="je-btn je-bg-native je-rdu"  id="updateArticle">修改英文作文</button>
    		<label class="je-label je-f14">下拉选择</label>
    		<select id="zh_en">
            <option value="en">中文->英文</option>
            <option value="zh">英文->中文</option>
		</select>
    </blockquote>
    <form action="" id="article_id">
    	<input type="hidden" value="<%=request.getParameter("id") %>" name="id" id="articleId"/>
     <div class="je-form-pane">
    <div class="je-form-item">
        <label class="je-label je-f14">英文作文标题</label>
        <div class="je-inputbox">
            <input type="text" name="title" id="title" autocomplete="off" placeholder="请输入英文作文标题" class="je-input">
        </div>
    </div>
    </div>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14">英文作文文章</label>
        <textarea placeholder="请输入英文作文文章" name="article" id="article1" class="je-textarea2" onkeyup="translation();"></textarea>
        <textarea name="translate" id="article2" class="je-textarea2" readonly></textarea>
        </div>
    </div>
    <div class="je-form-pane">
    <div class="je-form-item">
        <label class="je-label je-f14">作者</label>
        <div class="je-inputbox">
            <input type="text" name="author" id="author" autocomplete="off" placeholder="请输入作者" class="je-input">
        </div>
    </div>
    </div>
    </form>
 </div>
  </body>
</html>

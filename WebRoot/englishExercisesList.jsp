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
    <script type="text/javascript" src="englishJs/englishExercisesList.js"></script>
    <style>
        .je-field .je-btn {
            margin: 0 7px 10px 0;
        }
        .wordlist{
        	color:#BBFF00;
        }
        .divcss{
        	 overflow:scroll;
        	 width:300px;
        	 height:30px;
        	 overflow-y:auto;
        	 overflow-x:auto
        }
       	.bodyAll {
			position:fixed;
			top: 0px;
			right:0px;
			bottom:0px;
			filter: alpha(opacity=60);
			background-color: #777;
			left: 0px;
			display:none;
			opacity:0.6;
			-moz-opacity:0.1;
		}
    </style>
</head>
  
  <body>
  <div class="bodyAll">
  	<table class="je-table">
        <thead>
        <tr>
            <th></th>
            <th style="width:300px;">试题</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
            <th>正确答案</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        	<tr>
            <th></th>
            <th style="width:300px;">试题</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
            <th>正确答案</th>
            <th>操作</th>
        </tr>
        </tbody>
    </table>
    <input type="button" value="确定" onclick="queren();"/>
  </div>
  <div class="je-p20">
    <input type="hidden" value="<%=request.getContextPath() %>" id="context_path"/>
    <blockquote class="je-quote je-f16">
    		<span class="wordlist">英文单词与句子列表</span>
     		<input type="button" class="je-btn je-bg-native je-rdu" onclick="checkAll();" value="全选"/>
            <input type="button" class="je-btn je-bg-native je-rdu" onclick="deleteAll();" value="删除"/>
            <input type="button" class="je-btn je-bg-native je-rdu" onclick="addExercises();" value="添加习题"/>
    </blockquote>
    <table class="je-table">
        <thead>
        <tr>
            <th></th>
            <th style="width:300px;">试题</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
            <th>正确答案</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="englishTable_id">
        </tbody>
    </table>
    <div id="count_id" class="je-datatable-page" ></div>
</div>
  </body>
</html>

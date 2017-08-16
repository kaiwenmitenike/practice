<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <title>je-form</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/jeui.css"  media="all">
	<link type="text/css" rel="stylesheet" href="jedate/skin/jedate.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="englishJs/studyEnglishWords.js"></script>
    <script type="text/javascript" src="jedate/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="jedate/jquery.jedate.js"></script>
    <style type="text/css">
    	.wordlist{
        	color:#BBFF00;
        }
        .timeClass{
        	color:#DAA520;
        }
        .divcss{
        	 overflow:scroll;
        	 width:300px;
        	 height:30px;
        	 overflow-y:auto;
        	 overflow-x:auto
        }
    </style>
</head>
<body>
<div class="je-p20">
    <input type="hidden" value="<%=request.getContextPath() %>" id="context_path"/>
    <blockquote class="je-quote je-f16">
   			<span class="wordlist">随机抽取10个单词</span>	
			<span class="timeClass">开始时间:</span><input class="datainp wicon je-rdu" id="startTime" type="text" placeholder="YYYY-MM" value=""  readonly>
			<span class="timeClass">结束时间:</span><input class="datainp wicon je-rdu" id="endTime" type="text" placeholder="YYYY-MM" value=""  readonly>
    		<button class="je-btn je-bg-green je-rdu" onclick="randomWords();">查询</button>
    </blockquote>
    <div>
    <table class="je-table">
        <thead>
        <tr>
            <th>序号</th>
            <th>英文单词</th>
            <th>英文汉译</th>
            <th>英文句子</th>
            <th>句子汉译</th>
        </tr>
        </thead>
         <tbody id="englishWords">
        </tbody>
    </table>
    </div>
    <div id="inputId">
    	
    </div>
</div>
</body>
</html>

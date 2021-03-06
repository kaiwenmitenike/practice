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
    <script type="text/javascript" src="englishJs/addRead.js"></script>
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
    		<span class="wordlist">阅读理解填空</span>
    		<button class="je-btn je-bg-native je-rdu" onclick="addAnswer();">添加选项</button>
    		<button class="je-btn je-bg-native je-rdu" onclick="reduceAnswer();">减去选项</button>
    		<button class="je-btn je-bg-native je-rdu" onclick="addProtype();">添加阅读理解填空</button>
    </blockquote>
    <form action="" id="protype_id">
    	<input type="hidden" value="1" name="status" id="statusId"/>
     <div class="je-form-pane">
    <div class="je-form-item">
        <label class="je-label je-f14">阅读理解标题</label>
        <div class="je-inputbox">
            <input type="text" name="title" id="title" autocomplete="off" placeholder="请输入阅读理解标题" class="je-input">
        </div>
    </div>
    </div>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14">阅读理解文章</label>
        <textarea placeholder="请输入阅读理解文章" name="protype" id="protype" class="je-textarea"></textarea>
        </div>
    </div>
    </form>
    <form action="" id="protypeAnswer_id">
    <div id="answer_id"></div>
     </form>
 </div>
  </body>
</html>

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
    <script type="text/javascript" src="englishJs/allEnglishExercise.js"></script>
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
    		<span class="wordlist">英文练习题</span>
    </blockquote>
    <div id="exercises_id">
    
    </div>
    <div id="count_id" class="je-datatable-page" ></div>
</div>
  </body>
</html>

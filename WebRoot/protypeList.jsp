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
    <script type="text/javascript" src="englishJs/protypeList.js"></script>
    <style>
        .je-field .je-btn {
            margin: 0 7px 10px 0;
        }
        .wordlist{
        	color:#BBFF00;
        }
        .divcss{
        	 width:300px;
        	 height:30px;
        }
    </style>
</head>
  
  <body>
  <div class="je-p20">
    <input type="hidden" value="<%=request.getContextPath() %>" id="context_path"/>
    <input type="hidden" value="<%=request.getParameter("status") %>" id="statusId"/>
    <blockquote class="je-quote je-f16">
    		<span class="wordlist">完型填空</span>
    </blockquote>
     <table class="je-table">
        <thead>
        <tr>
            <th>标题</th>
            <th style="width:300px;">试题</th>
            <th>添加时间</th>
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

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
    <script type="text/javascript" src="englishJs/protype.js"></script>
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
    <input type="hidden" value="<%=request.getParameter("id") %>" id="protype_id"/>
    <input type="hidden" value="<%=request.getParameter("status") %>" id="status_id"/>
    <blockquote class="je-quote je-f16">
    		<span class="wordlist" id="protype_read"></span>
    </blockquote>
     <div class="je-form-pane">
    <div class="je-form-item">
        <label class="je-label je-f14" id="protype_read_title"></label>
        <div class="je-inputbox">
            <input type="text" name="title" id="title" autocomplete="off" placeholder="请输入完型标题" class="je-input" readonly>
        </div>
    </div>
    </div>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14" id="protype_read_article"></label>
        <textarea placeholder="请输入完型文章" name="protype" id="protype" class="je-textarea" readonly></textarea>
        </div>
    </div>
    <table class="je-table">
        <tbody id="englishTable_id">
        </tbody>
    </table>
    
 </div>
  </body>
</html>

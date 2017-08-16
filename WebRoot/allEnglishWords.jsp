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
    <script type="text/javascript" src="englishJs/allEnglishWords.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <style>
        .je-field .je-btn {
            margin: 0 7px 10px 0;
        }
        .wordlist{
        	color:#BBFF00;
        }
        .divcss{
        	 overflow:scroll;
        	 width:150px;
        	 height:30px;
        	 overflow-y:auto;
        	 overflow-x:auto
        }
        .upload_file{
        	position:absolute;
        	z-index:2;
        	left:0;
        	top:0;
        	right:0;
        	background-color:#000;
        	opacity:0.5;
        	margin:1px 1px;
        	display:none;
        	width:100%;
        	height:100%;
        	text-align:center;
        }
        .close_upload_file{
        	position:absolute !important;
        	left:30%;
        	top:0px;
        	z-index:3;
        	border:1px solid #ff6600;
        	background-color:#fff;
        	margin:100px auto;
        	padding:0px;
        	display:none;
        	width:400px;
        	height:300px;
        	text-align:right;
        }
    </style>
</head>
  
  <body>
  <div class="je-p20">
    <input type="hidden" value="<%=request.getContextPath() %>" id="context_path"/>
    <blockquote class="je-quote je-f16">
    		<span class="wordlist">英文单词与句子列表</span>
     		<input type="button" class="je-btn je-bg-native je-rdu" onclick="checkAll();" value="全选"/>
            <input type="button" class="je-btn je-bg-native je-rdu" onclick="deleteAll();" value="删除"/>
            <input type="button" class="je-btn je-bg-native je-rdu" onclick="studyEnglish();" value="增强记忆"/>
            <input type="button" class="je-btn je-bg-native je-rdu" onclick="excelEnglish();" value="导出excel"/>
            <input type="file" class="je-btn je-bg-native je-rdu" name="excelFile" id="excelFileId"/>
            <input type="button" class="je-btn je-bg-native je-rdu" onclick="getExcelEnglish();" value="导入excel"/>
    </blockquote>
    <table class="je-table">
        <thead>
        <tr>
            <th></th>
            <th>英文单词</th>
            <th>英文汉译</th>
            <th>英文句子</th>
            <th>句子汉译</th>
            <th>添加时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="englishTable_id">
        </tbody>
    </table>
    <div id="count_id" class="je-datatable-page" ></div>
    
</div>

<input type="hidden" id="url_id" value="<%=request.getContextPath() %>"/>
<div id="ceng" class="upload_file"> 
</div>

<div id="close" class="close_upload_file" style="background: rgba(226, 221, 177, 0.71);">
<a href="#" onclick="ShowDiv()">关闭</a>

<div style="text-align:center;">
<input type="file" name="myfile" id="upload"/>
<input type="button" value="upload" onclick="upload();"/>
</div>
</div>
<input type="hidden" id="uploadId" />
  </body>
</html>

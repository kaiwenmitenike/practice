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
    <script type="text/javascript" src="js/modules/jquery.min.js"></script>
    <script type="text/javascript" src="js/modules/jeCheck.js"></script>
    <script type="text/javascript" src="js/modules/jeSelect.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="englishJs/addEnglishWords.js"></script>
</head>
<body>
<div class="je-p20">
    <input type="hidden" value="<%=request.getContextPath() %>" id="context_path"/>
    <blockquote class="je-quote je-f16 addShow-exercises">
        添加英语单词与句子
    </blockquote>
    <blockquote class="je-quote je-f16 updateShow-exercises">
        修改英语单词与句子
    </blockquote>
    <form action="" id="englishForm_id">
    <input type="hidden" value="<%=request.getParameter("id") %>" name="id" id="word_id"/>
    <div class="je-form-pane">
        <label class="je-label je-f14">英文单词</label>
        <div class="je-inputbox">
            <input type="text" name="englishWords" id="englishWords" autocomplete="off" placeholder="请输入单词" class="je-input">
        </div>
    </div>
    <div class="je-form-pane">
        <label class="je-label je-f14">英文汉译</label>
        <div class="je-inputbox">
            <input type="text" name="englishMean" id="englishMean" autocomplete="off" placeholder="请输入英文汉译" class="je-input">
        </div>
    </div>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14">英文例句</label>
        <textarea placeholder="请输入英文例句" name="englishPhrases" id="englishPhrases" class="je-textarea" onkeyup="translation();"></textarea>
        </div>
    </div>
        <div class="je-form-text">
        <label class="je-label je-f14">例句翻译</label>
        <textarea placeholder="请输入例句翻译" name="phrasesMean" id="phrasesMean" class="je-textarea" readonly></textarea>
   		</div>
    </form>
        <div class="je-w33 je-dib addShow-exercises">
            <button class="je-btn je-f14" id="englishAdd_id">添加单词</button>
        </div>
        <div class="je-w33 je-dib updateShow-exercises">
            <button class="je-btn je-f14" id="englishUpdate_id">修改单词</button>
        </div>
    </div>
    
</body>
</html>

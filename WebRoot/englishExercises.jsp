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
    <script type="text/javascript" src="englishJs/englishExercises.js"></script>
    <style type="text/css">
    	
    </style>
</head>
<body>
<div class="je-p20">
    <input type="hidden" value="<%=request.getContextPath() %>" id="context_path"/>
    <blockquote class="je-quote je-f16 addShow-exercises">
        添加英语练习题
    </blockquote>
     <blockquote class="je-quote je-f16 updateShow-exercises">
        修改英语练习题
    </blockquote>
    <form action="" id="englishExercisesForm_id">
    <input type="hidden" value="<%=request.getParameter("id")%>" name="id" id="exercises_id"/>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14">英文试题</label>
        <textarea placeholder="请输入英文试题" name="exercises" id="exercises" class="je-textarea"></textarea>
        </div>
    </div>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14">第一个答案</label>
        <textarea placeholder="请输入第一个答案" name="firstAnswer" id="firstAnswer" class="je-textarea"></textarea>
        </div>
    </div>
    <div class="je-form-pane">
        <div class="je-form-text">
        <label class="je-label je-f14">第二个答案</label>
        <textarea placeholder="请输入第二个答案" name="secondAnswer" id="secondAnswer" class="je-textarea"></textarea>
        </div>
    </div>
        <div class="je-form-text">
        <label class="je-label je-f14">第三个答案</label>
        <textarea placeholder="请输入第三个答案" name="thirdAnswer" id="thirdAnswer" class="je-textarea"></textarea>
   		</div>
   		<div class="je-form-text">
        <label class="je-label je-f14">第四个答案</label>
        <textarea placeholder="请输入第四个答案" name="fourthAnswer" id="fourthAnswer" class="je-textarea"></textarea>
   		</div>
   		<div class="je-form-text">
        <label class="je-label je-f14">正确答案</label>
        <select name="trueAnswer" id="trueAnswer">
        	<option value="A">A</option>
        	<option value="B">B</option>
        	<option value="C">C</option>
        	<option value="D">D</option>
        </select>
   		</div>
    </form>
        <div class="je-w33 je-dib addShow-exercises">
            <button class="je-btn je-f14" id="englishExercisesAdd_id">添加试题</button>
        </div>
        <div class="je-w33 je-dib updateShow-exercises">
            <button class="je-btn je-f14" id="englishExercisesUpdate_id">修改试题</button>
        </div>
    </div>
    
</body>
</html>

var pageCount=1;
$(function(){
	queryExercise(1,pageCount);
	$("#nextPage").click(function(){
		nextPage(pageCount);
	});
	$("#upPage").click(function(){
		upPage(pageCount);
	});
});
var countNum;
var pageNum=1;
function queryExercise(pageNum,pageCount){
	$.ajax({
		url:"exercises/english",
		data:{"pageNum":pageNum,"pageCount":pageCount},
		type:"GET",
		dataType:"json",
		success:function(data){
			countNum = data.page.count;
			pageNum = data.page.page;
			var html='';
			$.each(data.list,function(e,info){
				html+='<div class="je-form-text">'+
			        '<label class="je-label je-f14">练习题</label>'+
			        '<textarea placeholder="练习题" id="trueAnswer" class="je-textarea" readonly>'+info.exercises+'</textarea>'+
			   	'</div>';
			    html+='<label><input name="answer" type="radio" value="A" />A、'+info.FIRST_ANSWER+'</label> ';
			    html+='<label><input name="answer" type="radio" value="B" />B、'+info.SECOND_ANSWER+'</label> ';
			    html+='<label><input name="answer" type="radio" value="C" />C、'+info.THIRD_ANSWER+'</label> ';
			    html+='<label><input name="answer" type="radio" value="D" />D、'+info.FOURTH_ANSWER+'</label> '+
			    	  '<input type="button" onclick="answer(\''+info.TRUE_ANSWER+'\')" value="确定选择"/><span id="exercise_'+e+'"></span>';
			});
			$("#count_id").html("<span class='pagecount'>共<em>"+data.page.count+"</em>条数据</span><span class='datacount'>共<em>"
					+data.page.countPage+"</em>页</span><span class='datacount'>当前为第<em>"+data.page.page+"</em>页</span>"
					+"<a data-page='3' href='javascript:;' class='flip' title='上一页' onclick='firstPage();'>首页</a>"
					+"<a data-page='3' href='javascript:;' class='flip' title='上一页' onclick='upPage();'>上一页</a>"
					+"<a data-page='3' href='javascript:;' class='flip' title='下一页' onclick='nextPage();'>下一页</a>"
					+"<a data-page='3' href='javascript:;' class='flip' title='尾页' onclick='lastPage();'>尾页</a>"
					+"<span>转到<input type='text' class='gopage' id='pageId'/><button type='button' onclick='goPage();' class='gobtn'>Go</button></span>");
			$("#exercises_id").html(html);
		}
	});
}

function firstPage(){
	pageNum=1;
	queryExercise(pageNum,pageCount);
}
function upPage(){
	if(pageNum>1){
		pageNum--;
	}else{
		alert("当前为第一页");
		return;
	}
	queryExercise(pageNum,pageCount);
}


function nextPage(){
	var lastPage = countNum%pageCount==0?parseInt(countNum/pageCount):parseInt(countNum/pageCount+1);
	if(pageNum<lastPage){
		pageNum++;
	}else{
		alert("当前为最后一页");
		return;
	}
	queryExercise(pageNum,pageCount);
}

function lastPage(){
	pageNum= countNum%pageCount==0?parseInt(countNum/pageCount):parseInt(countNum/pageCount+1);
	queryExercise(pageNum,pageCount);
}

function goPage(){
	pageNum = $("#pageId").val();
	var countPage = countNum%pageCount==0?parseInt(countNum/pageCount):parseInt(countNum/pageCount+1);
	if(pageNum>countPage||pageNum<1){
		alert("抱歉,请填入正确页数");
		return;
	}
	queryExercise(pageNum,pageCount);
}
function answer(trueAnswer){
	var valAnswer = $("input[type='radio']:checked").val();
	if(valAnswer==null){
		alert("请选择一个选项");
		return;
	}
	if(valAnswer==trueAnswer){
		alert("恭喜你,答对了");
	}else{
		alert("很抱歉,答案为"+trueAnswer);
	}
}


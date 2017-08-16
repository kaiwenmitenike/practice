$(function(){
	queryAnswer();
	if($("#status_id").val()==0){
		$("#protype_read").html("完型填空");
		$("#protype_read_title").html("完型标题");
		$("#protype_read_article").html("完型文章");
	}else if($("#status_id").val()==1){
		$("#protype_read").html("阅读理解");
		$("#protype_read_title").html("阅读理解标题");
		$("#protype_read_article").html("阅读理解文章");
	}
});

function queryAnswer(){
	$.ajax({
		url:"answer/protype",
		type:"GET",
		data:{"id":$("#protype_id").val()},
		dataType:"json",
		success:function(data){
			var html = "";
			$.each(data.list,function(e,info){
				$("#title").val(info.title);
				document.getElementById("protype").innerHTML=info.protype;
				html+='<tr><th><label><input name="answer'+(e+1)+'" type="radio" value="A" />A、'+info.FIRST_ANSWER+'</label></th>';
			    html+='<th><label><input name="answer'+(e+1)+'" type="radio" value="B" />B、'+info.SECOND_ANSWER+'</label></th>';
			    html+='<th><label><input name="answer'+(e+1)+'" type="radio" value="C" />C、'+info.THIRD_ANSWER+'</label></th>';
			    html+='<th><label><input name="answer'+(e+1)+'" type="radio" value="D" />D、'+info.FOURTH_ANSWER+'</label></th>'+
			    '<th><input type="button" onclick="answer(\''+info.TRUE_ANSWER+'\','+(e+1)+')" value="确定选择"/><span id="exercise_'+e+'"></span></th></tr>';
			});
			$("#englishTable_id").html(html);
		}
	});
}
function answer(trueAnswer,num){
	var valAnswer = $("input[name='answer"+num+"']:checked").val();
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

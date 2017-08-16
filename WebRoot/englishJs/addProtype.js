$(function(){
	
});

function addAnswer(){
	$("#answer_id").append('<div id="lineId">A:<input type="text" name="firstAnswer" id="firstAnswer" autocomplete="off" placeholder="请输入A答案" class="je-input">'+
   	'&nbsp;&nbsp;&nbsp;B:<input type="text" name="secondAnswer" id="secondAnswer" autocomplete="off" placeholder="请输入B答案" class="je-input">'+
   	'&nbsp;&nbsp;&nbsp;C:<input type="text" name="thirdAnswer" id="thirdAnswer" autocomplete="off" placeholder="请输入C答案" class="je-input">'+
   	'&nbsp;&nbsp;&nbsp;D:<input type="text" name="fourthAnswer" id="fourthAnswer" autocomplete="off" placeholder="请输入D答案" class="je-input">'+
    '&nbsp;&nbsp;&nbsp;<label class="je-label je-f14">正确答案</label>'+
    '<select class="myselect" name="trueAnswer" id="myselect">'+
    '<option value="A">A</option>'+
    '<option value="B">B</option>'+
    '<option value="C">C</option>'+
    '<option value="D">D</option>'+
    '</select></div>');
}

function reduceAnswer(){
	$("#lineId").remove();
}

var status;
function addProtype(){
	if($("#title").val()==''){
		alert("请输入完型标题");
		return;
	}
	if($("#protype").val()==''){
		alert("请输入完型文章");
		return;
	}
	if($("#answer_id").html()==null||$("#answer_id").html()==""){
		alert("请添加选项");
		return;
	}
	$.ajax({
		url:"protype/english",
		data:$("#protype_id").serialize(),
		dataType:"json",
		type:"POST",
		success:function(data){
			if(data.status==200){
				status=data.status;
				protypeAnswer(data.protypeId);
			}else{
				alert(data.message);
				return;
			}
		}
	});
}

function protypeAnswer(protypeId){
	$.ajax({
		url:"answer/protype/"+protypeId,
		type:"POST",
		data:$("#protypeAnswer_id").serialize(),
		dataType:"json",
		success:function(data){
			if(data.status==200){
				alert(data.message);
				location.reload();
			}else{
				alert(data.message);
			}
		}
	});
}
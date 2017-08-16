$(function(){
	if($("#exercises_id").val()=='null'){
		$(".addShow-exercises").show();
		$(".updateShow-exercises").hide();
	}else{
		$(".addShow-exercises").hide();
		$(".updateShow-exercises").show();
		getExerises();
	}
	$("#englishExercisesAdd_id").click(function(){

		if ($("#exercises").val() == "") {
			alert("请填写英文试题");
			return;
		}
		if ($("#firstAnswer").val() == "") {
			alert("请填写答案A");
			return;
		}
		if ($("#secondAnswer").val() == "") {
			alert("请填写答案B");
			return;
		}
		if ($("#thirdAnswer").val() == "") {
			alert("请填写答案C");
			return;
		}
		if ($("#fourthAnswer").val() == "") {
			alert("请填写答案D");
			return;
		}
		if ($("#trueAnswer").val() == "") {
			alert("请填写正确答案");
			return;
		}
		addExercises();
	});
	$("#englishExercisesUpdate_id").click(function(){

		if ($("#exercises").val() == "") {
			alert("请填写英文试题");
			return;
		}
		if ($("#firstAnswer").val() == "") {
			alert("请填写答案A");
			return;
		}
		if ($("#secondAnswer").val() == "") {
			alert("请填写答案B");
			return;
		}
		if ($("#thirdAnswer").val() == "") {
			alert("请填写答案C");
			return;
		}
		if ($("#fourthAnswer").val() == "") {
			alert("请填写答案D");
			return;
		}
		if ($("#trueAnswer").val() == "") {
			alert("请填写正确答案");
			return;
		}
		updateExercises();
	});
});


function addExercises(){
	$.ajax({
		url:"exercises/english",
		data:$("#englishExercisesForm_id").serialize(),
		type:"POST",
		dataType:"json",
		success:function(data){
			if(data.status==200){
				alert(data.message);
				var yesNo=confirm("请问是否继续添加练习题");
				if(yesNo==true){
					location.reload();
				}else{
					location.href=$("#context_path").val()+"/englishExercisesList.jsp";
				}
			}else{
				alert(data.message);
			}
		}
	});
}

function getExerises(){
	$.ajax({
		url:"exercises/english/"+$("#exercises_id").val(),
		type:"GET",
		dataType:"json",
		success:function(data){
			document.getElementById("exercises").innerText=data.list.exercises;
			document.getElementById("firstAnswer").innerText=data.list.firstAnswer;
			document.getElementById("secondAnswer").innerText=data.list.secondAnswer;
			document.getElementById("thirdAnswer").innerText=data.list.thirdAnswer;
			document.getElementById("fourthAnswer").innerText=data.list.fourthAnswer;
			document.getElementById("trueAnswer").innerText=data.list.trueAnswer;
		}
	});
}

function updateExercises(){
	$.ajax({
		url:"exercises/englishUpdate",
		data:$("#englishExercisesForm_id").serialize(),
		type:"POST",
		dataType:"json",
		success:function(data){
			if(data.status==200){
				alert(data.message);
				location.href=$("#context_path").val()+"/englishExercisesList.jsp";
			}else{
				alert(data.message);
			}
		}
	});

}
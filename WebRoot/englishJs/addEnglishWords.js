$(function() {
	if($("#word_id").val()=='null'){
		$(".addShow-exercises").show();
		$(".updateShow-exercises").hide();
	}else{
		$(".addShow-exercises").hide();
		$(".updateShow-exercises").show();
		getExerisesWord();
	}
	$("#englishUpdate_id").click(function(){
		if ($("input[name='englishWords']").val() == "") {
			alert("请填写英语单词");
			return;
		}
		if ($("input[name='englishMean']").val() == "") {
			alert("请填写单词汉译");
			return;
		}
		if ($("#englishPhrases").val() == "") {
			alert("请填写英语句子");
			return;
		}
		if ($("#phrasesMean").val() == "") {
			alert("请填写句子汉译");
			return;
		}
		updateEnglishWord();
	});
	
	$("#englishAdd_id").click(function() {
		if ($("input[name='englishWords']").val() == "") {
			alert("请填写英语单词");
			return;
		}
		if ($("input[name='englishMean']").val() == "") {
			alert("请填写单词汉译");
			return;
		}
		if ($("#englishPhrases").val() == "") {
			alert("请填写英语句子");
			return;
		}
		if ($("#phrasesMean").val() == "") {
			alert("请填写句子汉译");
			return;
		}
		addEnglishWord();
	});
});

function addEnglishWord() {
	$.ajax({
		url : "word/english",
		data : $("#englishForm_id").serialize(),
		type : "POST",
		dataType : "json",
		success : function(data) {
			if (data.status = 200) {
				alert(data.message);
				var yesNo=confirm("是否继续添加?");
				if(yesNo==true){
					location.reload();
				}else{
					location.href=$("#context_path").val()+"/allEnglishWords.jsp";
				}
			} else {
				alert(data.message);
			}
		}
	});
}

function updateEnglishWord(){
	$.ajax({
		url : "word/englishUpdate",
		data : $("#englishForm_id").serialize(),
		type : "POST",
		dataType : "json",
		success : function(data) {
			if (data.status = 200) {
				alert(data.message);
				location.href=$("#context_path").val()+"/allEnglishWords.jsp";
			} else {
				alert(data.message);
			}
		}
	});
}

function getExerisesWord(){
	$.ajax({
		url:"word/english/"+$("#word_id").val(),
		type:"GET",
		dataType:"json",
		success:function(data){
			$("#englishWords").val(data.list.englishWords);
			$("#englishMean").val(data.list.englishMean);
			document.getElementById("englishPhrases").innerText=data.list.englishPhrases;
			document.getElementById("phrasesMean").innerText=data.list.phrasesMean;
		}
	});
}

function translation(){
	$.ajax({
		url:"translation/english",
		type:"POST",
		data:{"article":$("#englishPhrases").val(),"en_ch":"zh"},
		dataType:"json",
		success:function(data){
			$.each(data,function(e,info){
				document.getElementById("phrasesMean").innerHTML=info.dst;
				status=info.status;
			})
		}
	});
}
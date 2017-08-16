$(function(){
	if($("#articleId").val()=="null"){
		$("#updateArticle").hide();
		$("#addArticle").click(function(){
			addArticle();
		});
	}else{
		$("#addArticle").hide();
		article();
		$("#updateArticle").click(function(){
			updateArticle();
		});
	}
});
var status;
function article(){
	$.ajax({
		url:"article/english/"+$("#articleId").val(),
		type:"GET",
		dataType:"json",
		success:function(data){
			$("#title").val(data.list.title);
			document.getElementById("article1").innerText=data.list.article;
			document.getElementById("article2").innerText=data.list.translate;
			$("#author").val(data.list.author);
		}
	});
}

function updateArticle(){
	if($("#title").val()==""){
		alert("请输入英文作文标题");
		return;
	}
	if($("#article1").val()==""){
		alert("请输入英文作文文章");
		return;
	}
	if($("#author").val()==""){
		alert("请输入作者");
		return;
	}
	if(status==500){
		alert("网络异常");
		return;
	}
	$.ajax({
		url:"article/english/updateArticle",
		data:$("#article_id").serialize(),
		dataType:"json",
		type:"POST",
		success:function(data){
			if(data.status==200){
				alert(data.message);
				location.href=$("#context_path").val()+"/readList.jsp";
			}else{
				alert(data.message);
			}
		}
	});

}


function addArticle(){
	if($("#title").val()==""){
		alert("请输入英文作文标题");
		return;
	}
	if($("#article1").val()==""){
		alert("请输入英文作文文章");
		return;
	}
	if($("#author").val()==""){
		alert("请输入作者");
		return;
	}
	if(status==500){
		alert("网络异常");
		return;
	}
	$.ajax({
		url:"article/english",
		data:$("#article_id").serialize(),
		dataType:"json",
		type:"POST",
		success:function(data){
			if(data.status==200){
				var yesNo = confirm(data.message+"是否继续添加?");
				if(yesNo==true){
					location.reload();
				}else{
					location.href=$("#context_path").val()+"/readList.jsp";
				}
				
			}else{
				alert(data.message);
			}
		}
	});
}

function translation(){
	$.ajax({
		url:"translation/english",
		type:"POST",
		data:{"article":$("#article1").val(),"en_ch":$("#zh_en").val()},
		dataType:"json",
		success:function(data){
			$.each(data,function(e,info){
				document.getElementById("article2").innerHTML=info.dst;
				status=info.status;
			})
		}
	});
}
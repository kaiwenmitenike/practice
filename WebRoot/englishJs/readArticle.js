$(function(){
	article();
});

function article(){
	$.ajax({
		url:"article/english/"+$("#articleId").val(),
		type:"GET",
		dataType:"json",
		success:function(data){
			$("#title").val(data.list.title);
			document.getElementById("article").innerText=data.list.article;
			document.getElementById("article2").innerText=data.list.translate;
		}
	});
}
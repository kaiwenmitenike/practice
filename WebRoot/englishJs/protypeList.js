var pageCount=5;
$(function() {
	queryEnglishWord(1,pageCount);
	$("#nextPage").click(function(){
		nextPage(pageCount);
	});
	$("#upPage").click(function(){
		upPage(pageCount);
	});
});
var countNum;
var pageNum=1;
function queryEnglishWord(pageNum,pageCount){
	$.ajax({
		url:"protype/english",
		data:{"pageNum":pageNum,"pageCount":pageCount,"status":$("#statusId").val()},
		type:"GET",
		dataType:"json",
		success:function(data){
			countNum = data.page.count;
			pageNum = data.page.page;
			var _html='';
			$.each(data.list,function(e,info){
				_html +='<tr>'+
						'<th>'+info.title+'</th>'+
						'<th><div class="divcss">'+info.protype+'</div></th>'+
						'<th>'+info.add_time+'</th>'+
						'<th><button class="je-btn je-bg-green je-btn-small" value="查看详情" onclick="queryProtypeById(\''+info.id+'\');"><i class="je-icon"></i></button>'+
						'<button class="je-btn je-bg-green je-btn-small" value="删除" onclick="deleteExerises(\''+info.id+'\');"><i class="je-icon"></i></button></th>'+
						'</tr>';
			});
			$("#count_id").html("<span class='pagecount'>共<em>"+data.page.count+"</em>条数据</span><span class='datacount'>共<em>"
					+data.page.countPage+"</em>页</span><span class='datacount'>当前为第<em>"+data.page.page+"</em>页</span>"
					+"<a data-page='3' href='javascript:;' class='flip' title='上一页' onclick='firstPage();'>首页</a>"
					+"<a data-page='3' href='javascript:;' class='flip' title='上一页' onclick='upPage();'>上一页</a>"
					+"<a data-page='3' href='javascript:;' class='flip' title='下一页' onclick='nextPage();'>下一页</a>"
					+"<a data-page='3' href='javascript:;' class='flip' title='尾页' onclick='lastPage();'>尾页</a>"
					+"<span>转到<input type='text' class='gopage' id='pageId'/><button type='button' onclick='goPage();' class='gobtn'>Go</button></span>");
			$("#englishTable_id").html(_html);
		}
	});
}

function firstPage(){
	pageNum=1;
	queryEnglishWord(pageNum,pageCount);
}
function upPage(){
	if(pageNum>1){
		pageNum--;
	}else{
		alert("当前为第一页");
		return;
	}
	queryEnglishWord(pageNum,pageCount);
}


function nextPage(){
	var lastPage = countNum%pageCount==0?parseInt(countNum/pageCount):parseInt(countNum/pageCount+1);
	if(pageNum<lastPage){
		pageNum++;
	}else{
		alert("当前为最后一页");
		return;
	}
	queryEnglishWord(pageNum,pageCount);
}

function lastPage(){
	pageNum= countNum%pageCount==0?parseInt(countNum/pageCount):parseInt(countNum/pageCount+1);
	queryEnglishWord(pageNum,pageCount);
}

function goPage(){
	pageNum = $("#pageId").val();
	var countPage = countNum%pageCount==0?parseInt(countNum/pageCount):parseInt(countNum/pageCount+1);
	if(pageNum>countPage||pageNum<1){
		alert("抱歉,请填入正确页数");
		return;
	}
	queryEnglishWord(pageNum,pageCount);
}

function deleteExerises(exercise_id){
	var yesNo = confirm("您确定删除吗?");
	if(yesNo==true){
		$.ajax({
			url:"protype/english/"+exercise_id,
			type:"DELETE",
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
	}else{
		return;
	}
}

function queryProtypeById(protypeId){
	this.location.href=$("#context_path").val()+"/protype.jsp?id="+protypeId+"&status=0";
}

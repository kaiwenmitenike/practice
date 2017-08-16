var pageCount=4;
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
		url:"word/english",
		data:{"pageNum":pageNum,"pageCount":pageCount},
		type:"GET",
		dataType:"json",
		success:function(data){
			countNum = data.page.count;
			pageNum = data.page.page;
			var _html='';
			$.each(data.list,function(e,info){
				_html +='<tr>'+
						'<td><input type="checkbox" name="wordALL" value="'+info.id+'"/></td>'+
						'<td>'+info.english_words+'</td>'+
						'<td><div class="divcss">'+info.english_mean+'</div></td>'+
						'<td><div class="divcss">'+info.english_phrases+'</div></td>'+
						'<td><div class="divcss">'+info.phrases_mean+'</div></td>'+
						'<td>'+info.add_time+'</td>'+
						'<th><button class="je-btn je-bg-green je-btn-small" onclick="getExerises(\''+info.id+'\');">修改</button>'+
						'<button class="je-btn je-bg-green je-btn-small" value="删除" onclick="deleteExerises(\''+info.id+'\');">删除</button>'+
						'<button class="je-btn je-bg-green je-btn-small" value="上传图片" onclick="upPictures(\''+info.id+'\');">上传图片</button>'+
						'<button class="je-btn je-bg-green je-btn-small" value="上传图片" onclick="getPictures(\''+info.id+'\');">查看图片</button></th>'+
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

var id='';
function checkAll(){
	var all = document.getElementsByName("wordALL");
	for(var i =0;i<all.length;i++){
		all[i].checked=true;
	}
}

function deleteAll(){
	id='';
	var obj=document.getElementsByName('wordALL'); //选择所有name="'test'"的对象，返回数组 
	//取到对象数组后，我们来循环检测它是不是被选中 
	for(var i=0; i<obj.length; i++){ 
		if(obj[i].checked){
			id+=obj[i].value+','; //如果选中，将value添加到变量s中 
		} 
	} 
	if(id!=null&&id!=''){
		var yesNo = confirm("您确定删除吗?");
		if(yesNo==true){
			$.ajax({
				url:"word/english/"+id,
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
	}else{
		alert("请至少选择一个");
	}
}

function deleteExerises(word_id){
		var yesNo = confirm("您确定删除吗?");
		if(yesNo==true){
			$.ajax({
				url:"word/english/"+word_id,
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

function excelEnglish(){
	location.href=$("#context_path").val()+"/word/english/excel/"+pageNum+"/"+pageCount;
}

function upPictures(id){
	document.getElementById('ceng').style.display='block';
    document.getElementById('close').style.display='block';
    $("#uploadId").val(id);
}
function upload(){
	 $.ajaxFileUpload({
	      url : $("#url_id").val()+"/upload/english/"+$("#uploadId").val(),//后台请求地址
	      type: 'post',//请求方式 当要提交自定义参数时，这个参数要设置成post
	      secureuri : false,//是否启用安全提交，默认为false。 
	      fileElementId : 'upload',// 需要上传的文件域的ID，即<input type="file">的ID。
	      dataType : 'text/html',//服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。如果json返回的带pre,这里修改为json即可解决。
	      success : function (data) {//提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
	         var jsonData = eval("["+data+"]");
	         alert(jsonData[0].message);
	      },
	      error : function (s,json, status, e) {//提交失败自动执行的处理函数。
	         
	      }
	    });
	 ShowDiv();
}

function getExcelEnglish(){
	$.ajaxFileUpload({
	      url : $("#url_id").val()+"/word/getExcel",//后台请求地址
	      type: 'post',//请求方式 当要提交自定义参数时，这个参数要设置成post
	      secureuri : false,//是否启用安全提交，默认为false。 
	      fileElementId : 'excelFileId',// 需要上传的文件域的ID，即<input type="file">的ID。
	      dataType : 'json',//服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。如果json返回的带pre,这里修改为json即可解决。
	      success : function (json, status) {//提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
	         alert(json.retMsg);
	      },
	      error : function (json, status, e) {//提交失败自动执行的处理函数。
	         
	      }
	    });
	location.reload();
}

function getPictures(id){
	$.ajax({
		url:"upload/picture",
		type:"GET",
		data:{"id":id},
		dataType:"json",
		success:function(data){
			var urlPath = $("#url_id").val();
			urlPath = urlPath.substring(0, urlPath.lastIndexOf("english"));
			window.open(urlPath+data.list.upload_path);
		}
	});
}

function studyEnglish(){
	location.href=$("#context_path").val()+"/studyEnglishWords.jsp";
}

function addEnglishExercises(){
	this.location.href=$("#context_path").val()+"/englishExercises.jsp";
}
function getExerises(word_id){
	this.location.href=$("#context_path").val()+"/addEnglishWords.jsp?id="+word_id;
}
function ShowDiv()
{
        document.getElementById('ceng').style.display='none';
        document.getElementById('close').style.display='none';
}

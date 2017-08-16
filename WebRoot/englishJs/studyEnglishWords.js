$(function(){
	
});

function randomWords(){
	$.ajax({
		url:"word/english/study",
		data:{"startTime":$("#startTime").val(),"endTime":$("#endTime").val()},
		type:"GET",
		dataType:"json",
		success:function(data){
			if(data.status==400){
				alert(data.message);
				return;
			}else{
				var _englishWord='';
				var inputText='';
				$.each(data.list,function(e,info){
					_englishWord+='<tr><th>'+(e+1)+'<input type="hidden" id="'+(e+1)+"_english"+'" value="'+info.id+'"></th>'
								 +'<th>'+info.english_words+'</th>'
								 +'<th><div class="divcss">'+info.english_mean+'</div></th>'
								 +'<th><div class="divcss">'+info.english_phrases+'</div></th>'+
								  '<th><div class="divcss">'+info.phrases_mean+'</div></th></tr>';
				});
				$("#englishWords").html(_englishWord);
			}
		}
	});
}
window.onload=function(){
	$("#startTime").jeDate({
	    //festival:true,
	    ishmsVal:false,
	    minDate: '2016-06',
	    maxDate: $.nowDate({DD:0}),
	    format:"YYYY-MM",
	    zIndex:3000,
	});
	$("#endTime").jeDate({
	    //festival:true,
	    ishmsVal:false,
	    minDate: '2016-06',
	    maxDate: $.nowDate({DD:0}),
	    format:"YYYY-MM",
	    zIndex:3000,
	});
}
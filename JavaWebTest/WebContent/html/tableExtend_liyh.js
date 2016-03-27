var doyoulikemi4i160327221800_tr_index = -1;//当前点击后的tr索引
    /**
    * trObj 当前被点击的tr对象
    * tableId 表格的id
    * htmlContent 下拉框内需要显示的内容(html片段)
    **/
function doyoulikemi4i160327_tableExtend(trObj, tableId, htmlContent){
    if(doyoulikemi4i160327221800_tr_index==$(trObj).index()){
        var aaadiv = $($($("#"+tableId).find("tr")[doyoulikemi4i160327221800_tr_index+1]).find("div")[0]);
        aaadiv.animate({height:"0px"},200,function(){
        	aaadiv.html("");
        	aaadiv.parent().parent().remove();
        });
        doyoulikemi4i160327221800_tr_index = -1;
        return;
    }
    if(doyoulikemi4i160327221800_tr_index!=-1){
        var aaadiv = $($($("#"+tableId).find("tr")[doyoulikemi4i160327221800_tr_index+1]).find("div")[0]);
        aaadiv.animate({height:"0px"},200,function(){
        	aaadiv.html("");
        	aaadiv.parent().parent().remove();
        });
    }

    if($(trObj).index()>doyoulikemi4i160327221800_tr_index&&doyoulikemi4i160327221800_tr_index!=-1){
        doyoulikemi4i160327221800_tr_index = $(trObj).index()-1;
    }else{
    	doyoulikemi4i160327221800_tr_index = $(trObj).index();
    }
    //alert(doyoulikemi4i160327221800_tr_index);

    var tds = $(trObj).children().length;
    var v_tr = $("<tr><td colspan='"+tds+"'><div style='background-color:#F1F2F2;'></div></td></tr>");
    v_tr.insertAfter($(trObj));
    var v_div = $(v_tr.find("div")[0]);
    v_div.html(htmlContent).hide();
    /* if(v_div.is(":visible")){
        v_div.slideUp();
    }else{
        v_div.slideDown();
    } */
    v_div.slideDown();
	
}
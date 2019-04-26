function ajaxFileUpload(fileId,imgShow,imgUrl,submitId,url) {
	var fileName = $("#"+fileId).val().split(".");
	var length = fileName.length;
	var ext = fileName[length-1];
	if(ext != "jpg" && ext != "png"){
		alert("图片格式只能是jpg和png。。。")
		return ;
	}
	var $btn = $('#picture').find('input[type="submit"]');
	$btn.attr('disabled', 'disabled');
	$.ajaxFileUpload(
        {
            url: url, //用于文件上传的服务器端请求地址
            type:'post',
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: fileId, //文件上传域的ID
            dataType: 'text', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
               var obj = eval("(" + data + ")");
               var prefix = obj.prefix;
               var url = obj.url;
               var realUrl = prefix + url;
               $("#"+imgShow).attr("src",realUrl);
               $("#"+imgShow).show();
               if(null != url && url!="")
            	   $("#"+imgUrl).attr("value",url);
               $btn.removeAttr("disabled");
            },
            error: function (s, xml, a, e)//服务器响应失败处理函数
            {
            	alert("不要点击太快");
                //$btn.removeAttr("disabled");
            }
        }
    );
    return false;
};
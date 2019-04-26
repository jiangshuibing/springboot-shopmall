/**
 * Created by chenhong on 2018/8/13.
 */
function fileSelect() {
    $('#fileToUpload').click();
}

function fileSelected() {
    // 文件选择后触发次函数
    var formData = new FormData($("#forms")[0]);
    $('#forms').attr("enctype","multipart/form-data");
    $.ajax({
        url : "/medical/uploadImage",
        type : 'POST',
        data : formData,
        cache: false,
        async: false,
        processData : false,  //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,  //必须false才会自动加上正确的Content-Type

        success: function (data) {
            console.log(data);
            if (data.R==200){
                $('#ownFace').attr("src",data.url);
                $('#owns').addClass("non");
                $('#ownFace').removeClass("non");
                $('#faceTip').addClass("non");
                $('#ownIdcardFacade').attr("value", data.url);
            }
        },
        error: function (data) {
            console.log("失败");
            /*
             layer.msg(data.message, {time: 2000});
             */
        }
    });
}
function fileSelectBack() {
    $('#fileToUpload2').click();
}

function fileSelectedBack() {
    // 文件选择后触发次函数
    var formData = new FormData($("#forms")[0]);
    $('#forms').attr("enctype","multipart/form-data");
    /*$('#forms').attr("onsubmit", "return false");*/
    $.ajax({
        url : "/medical/uploadImage2",
        type : 'POST',
        data : formData,
        cache: false,
        async: false,
        processData : false,  //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,  //必须false才会自动加上正确的Content-Type

        success: function (data) {
            console.log(data);
            if (data.R==200){
                $('#ownBack').attr("src",data.url);
                $('#back').addClass("non");
                $('#ownBack').removeClass("non");
                $('#backTip').addClass("non");
                $('#ownIdcardIdentity').attr("value", data.url);
            }
        },
        error: function (data) {
            console.log("失败");
            /*
             layer.msg(data.message, {time: 2000});
             */
        }
    });
}

function fileSelect3() {
    $('#fileToUpload3').click();
}

function fileSelected3() {
    // 文件选择后触发次函数
    var formData = new FormData($("#forms")[0]);
    $('#forms').attr("enctype","multipart/form-data");
   /* $('#forms').attr("onsubmit", "return false");*/
    $.ajax({
        url : "/medical/uploadImage3",
        type : 'POST',
        data : formData,
        cache: false,
        async: false,
        processData : false,  //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,  //必须false才会自动加上正确的Content-Type

        success: function (data) {
            console.log(data);
            if (data.R==200){
                $('#manFace').attr("src",data.url);
                $('#mand').addClass("non");
                $('#manFace').removeClass("non");
                $('#manTip').addClass("non");
                $('#mandataryIdcardFacade').attr("value", data.url);
            }
        },
        error: function (data) {
            console.log("失败");
            /*
             layer.msg(data.message, {time: 2000});
             */
        }
    });
}

function fileSelect4() {
    $('#fileToUpload4').click();
}

function fileSelected4() {
    // 文件选择后触发次函数
    var formData = new FormData($("#forms")[0]);
    $('#forms').attr("enctype","multipart/form-data");
    /*$('#forms').attr("onsubmit", "return false");*/
    $.ajax({
        url : "/medical/uploadImage4",
        type : 'POST',
        data : formData,
        cache: false,
        async: false,
        processData : false,  //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,  //必须false才会自动加上正确的Content-Type

        success: function (data) {
            console.log(data);
            if (data.R==200){
                $('#manBack').attr("src",data.url);
                $('#manb').addClass("non");
                $('#manBack').removeClass("non");
                $('#manBackTip').addClass("non");
                $('#mandataryIdcardIdentity').attr("value", data.url);
            }
        },
        error: function (data) {
            console.log("失败");
            /*
             layer.msg(data.message, {time: 2000});
             */
        }
    });
}


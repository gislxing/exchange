
function changeValiCode(dom){
    var img = $(dom).prev("img");
    img.attr("src", "/admin/valicode?" + Math.random());
    img.click;
}
function submitButton(){
    /*var imageCode = $("#imageCode").val();
    $.post("/admin/loginAdmin",
        {
            "imageCode": imageCode,
            "username": imageCode,
            "password": password
        },
        function(data){
            if(data.flag == "success"){//登录成功
                layer.msg(data.msg,{icon:1,time:1000});
                location.href ="/admin/index";
            }else{
                layer.msg(data.msg,{icon:1,time:1000});
            }
        }, "json");*/

    $("#form-admin-login").ajaxSubmit({
        type: 'post',
        url: "/admin/loginAdmin",
        success: function (data) {
            if(data.flag == "success"){//登录成功
                layer.msg(data.msg,{icon:1,time:1000});
                location.href ="/admin/index";
            }else{
                layer.msg(data.msg,{icon:1,time:1000});
            }
        }
    });

}
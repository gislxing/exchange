$(function () {
    $("body").keyup(function (event) {
        if (event.keyCode == 13) {
            submitButton();
        }
    });
});

function changeValiCode(dom) {
    var img = $(dom).prev("img");
    img.attr("src", "/admin/valicode?" + Math.random());
    img.click;
}

function submitButton() {
    $("#form-admin-login").ajaxSubmit({
        type: 'post',
        url: "/admin/loginAdmin",
        success: function (data) {
            if (data.flag == "success") {//登录成功
                layer.msg(data.msg, {icon: 1, time: 1000});
                location.href = "/admin/index";
            } else {
                layer.msg(data.msg, {icon: 1, time: 1000});
            }
        }
    });
}
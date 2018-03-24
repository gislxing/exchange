$(function () {
    $("#loginform").validate({
        rules: {},
        onkeyup: false,
        focusCleanup: true,
        success: "valid",
        submitHandler: function (form) {
            $(form).ajaxSubmit({
                type: 'post',
                url: "/admin/password/updatesave",
                success: function (data) {
                    if (data.flag == "success") {
                        layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                            location.href="/admin/logout";
                        });
                    } else {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                    }
                }
            });

        }
    });
});
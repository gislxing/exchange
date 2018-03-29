$(function () {
    $('.skin-minimal input').iCheck({
        checkboxClass: 'icheckbox-blue',
        radioClass: 'iradio-blue',
        increaseArea: '20%'
    });

    $("#form-admin-add").validate({
        rules: {
            phone: {
                required: true,
                isPhone: true,
            }
        },
        onkeyup: false,
        focusCleanup: true,
        success: "valid",
        submitHandler: function (form) {
            $(form).ajaxSubmit({
                type: 'post',
                url: "/admin/my/bank/card/save",
                success: function (data) {
                    if (data.flag == "success") {
                        layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.location.reload();
                            // parent.layer.close(index);
                        });
                    } else {
                        layer.msg(data.msg, {icon: 2, time: 1000});
                    }
                }
            });

        }
    });
});
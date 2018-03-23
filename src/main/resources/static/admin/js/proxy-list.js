/*管理员-增加*/
function admin_add(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*管理员-删除*/
function admin_del(obj, username) {
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: "POST",
            url: "/admin/delete",
            data: "username=" + username,
            async: true,
            success: function (data) {
                if (data.msg != null && data.msg != ""){
                    layer.msg(username + ' : ' + data.msg, {icon: 2, time: 1000});
                }else{
                    layer.msg(username + ' 已删除', {icon: 1, time: 1000}, function () {
                        // 刷新表格
                        window.location.reload();
                    });
                }
            }
        });
    });
}

/*管理员-编辑*/
function admin_edit(title, url, w, h) {
    layer_show(title, url, w, h);
}

/*管理员-停用*/
function admin_stop(obj, username) {
    layer.confirm('确认要禁止用户: ' + username + '?', function (index) {
        //此处请求后台程序，下方是成功后的前台处理……
        $.ajax({
            type: "POST",
            url: "/admin/able/enable",
            data: "username=" + username + "&status=0",
            async: true,
            success: function (data) {
                if (data.msg != null && data.msg != "") {
                    layer.msg(username + ": " + data.msg, {icon: 5, time: 1000});
                } else {
                    $(obj).parent().parent().find(".user-status").html('<span class="label label-default radius">禁用</span>');
                    $(obj).replaceWith('<a onClick="admin_start(this, username)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
                    layer.msg(username + ' 已停用!', {icon: 5, time: 1000});
                }
            }
        });
    });
}

/*管理员-启用*/
function admin_start(obj, username) {
    layer.confirm('确认要启用' + username + '?', function (index) {
        //此处请求后台程序，下方是成功后的前台处理……
        $.ajax({
            type: "POST",
            url: "/admin/able/enable",
            data: "username=" + username + "&status=1",
            async: true,
            success: function (data) {
                if (data.msg != null && data.msg != "") {
                    layer.msg(username + ": " + data.msg, {icon: 5, time: 1000});
                } else {
                    $(obj).parent().parent().find(".user-status").html('<span class="label label-success radius">启用</span>');
                    $(obj).replaceWith('<a onClick="admin_stop(this,username)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
                    layer.msg(username + ' 已启用!', {icon: 6, time: 1000});
                }
            }
        });
    });
}
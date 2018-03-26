function resetPassword(userId) {
    layer.confirm('确认要重置密码？', function () {
        $.ajax({
            type: 'POST',
            url: '<?=U("user/resetPassword")?>',
            data: {userId: userId},
            dataType: 'json',
            success: function (data) {
                if (data.stauts == 1) {
                    layer.msg('操作成功!', {icon: 1, time: 1000});
                } else {
                    layer.msg(data.msg,{icon:2,time:1000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 1000});
            },
        });
    });
}
/**
 * 暂停交易
 * @param goldId
 */
function zantingjiaoyi(userId,tradeable) {
    var msg;
    if(tradeable == 0){
        msg= "确认要暂停该用户交易？"
    }else {
        msg= "确认要恢复该用户交易？"
    }
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '<?=U("user/zantingjiaoyi")?>',
            data: {userId:userId,tradeable:tradeable},
            dataType: 'json',
            success: function (data) {

                if (data.status == 1) {
                    layer.msg('操作成功!', {icon: 1, time: 1000});
                    window.location.reload();
                } else {
                    layer.msg(data.msg,{icon:2,time:10000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}
/**
 * 禁止登录
 * @param goldId
 */
function jinzhidenglu(userId,loginType) {
    var msg;
    if(loginType == 2){
        msg= "确认要禁止该用户登录？"
    }else {
        msg= "确认要恢复该用户登录？"
    }
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '<?=U("user/jinzhidenglu")?>',
            data: {userId:userId,loginType:loginType},
            dataType: 'json',
            success: function (data) {

                if (data.status == 1) {
                    layer.msg('操作成功!', {icon: 1, time: 1000});
                    window.location.reload();
                } else {
                    layer.msg(data.msg,{icon:2,time:10000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}
function risk(userID,risk) {
    var msg;
    if(risk == 1){
        msg= "确认要恢复该用户？"
    }else {
        msg= "确认要设置该用户？"
    }
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '<?=U("user/risk")?>',
            data: {userId:userID,risk:risk},
            dataType: 'json',
            success: function (data) {
                if (data.status == 1) {
                    layer.msg('操作成功!', {icon: 1, time: 1000});
                    window.location.reload();
                } else {
                    layer.msg(data.msg,{icon:2,time:10000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}
/**
 * 禁止出金
 * @param goldId
 */
function jinzhichujin(userId,chujinType) {
    var msg;
    if(chujinType == 2){
        msg= "确认要禁止该用户出金？"
    }else {
        msg= "确认要恢复该用户出金？"
    }
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '<?=U("user/jinzhichujin")?>',
            data: {userId:userId,chujinType:chujinType},
            dataType: 'json',
            success: function (data) {

                if (data.status == 1) {
                    layer.msg('操作成功!', {icon: 1, time: 1000});
                    window.location.reload();
                } else {
                    layer.msg(data.msg,{icon:2,time:10000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}

function autonym(title,url,w,h) {
    layer_show(title, url, w, h);
}
/**
 * 重置密码
 * @param userId
 */
function resetPassword(userId) {
    layer.confirm('确认要重置密码？', function () {
        $.ajax({
            type: 'POST',
            url: '/admin/user/reset/password',
            data: {id: userId},
            dataType: 'json',
            success: function (data) {
                if (data != null) {
                    layer.msg(data.msg, {icon: 1, time: 1000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 1000});
            }
        });
    });
}

/**
 * 更新交易状态
 * @param goldId
 */
function updateTransactionStatus(userId, status) {
    var msg;
    if (status == 0) {
        msg = "确认要暂停该用户交易？"
    } else {
        msg = "确认要恢复该用户交易？"
    }

    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '/admin/user/update',
            data: {id: userId, tradeable: status},
            dataType: 'json',
            success: function (data) {
                if (data != null) {
                    if (data.flag >= 0){
                        layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                            window.location.reload();
                        });
                    }else{
                        layer.msg(data.msg, {icon: 2, time: 1000});
                    }
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            }
        });
    });
}

/**
 * 禁止登录
 * @param goldId
 */
function changeLoginStatus(userId, loginType) {
    var msg;
    if (loginType == 2) {
        msg = "确认要禁止该用户登录？"
    } else {
        msg = "确认要恢复该用户登录？"
    }
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '/admin/user/update',
            data: {id: userId, loginType: loginType},
            dataType: 'json',
            success: function (data) {
                if (data != null){
                    if (data.flag >= 0){
                        layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                            window.location.reload();
                        });
                    }else{
                        layer.msg(data.msg, {icon: 2, time: 1000});
                    }
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}

// function risk(userID, risk) {
//     var msg;
//     if (risk == 1) {
//         msg = "确认要恢复该用户？"
//     } else {
//         msg = "确认要设置该用户？"
//     }
//     layer.confirm(msg, function () {
//         $.ajax({
//             type: 'POST',
//             url: '<?=U("user/risk")?>',
//             data: {userId: userID, risk: risk},
//             dataType: 'json',
//             success: function (data) {
//                 if (data.status == 1) {
//                     layer.msg('操作成功!', {icon: 1, time: 1000});
//                     window.location.reload();
//                 } else {
//                     layer.msg(data.msg, {icon: 2, time: 10000});
//                 }
//             },
//             error: function (XmlHttpRequest, textStatus, errorThrown) {
//                 layer.msg('error!', {icon: 1, time: 10000});
//             },
//         });
//     });
// }

/**
 * 禁止出金
 * @param goldId
 */
function changeOutCashStatus(userId, chujinType) {
    var msg;
    if (chujinType == 2) {
        msg = "确认要禁止该用户出金？"
    } else {
        msg = "确认要恢复该用户出金？"
    }
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '/admin/user/update',
            data: {id: userId, chujinType: chujinType},
            dataType: 'json',
            success: function (data) {
                if (data != null){
                    if (data.flag >= 0){
                        layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                            window.location.reload();
                        });
                    }else{
                        layer.msg(data.msg, {icon: 2, time: 1000});
                    }
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}

// function autonym(title, url, w, h) {
//     layer_show(title, url, w, h);
// }
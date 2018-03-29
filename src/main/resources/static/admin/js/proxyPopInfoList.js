

/**
 * 驳回
 * @param goldId
 */
function rebutPop(popId,adminId, popFlag,popMoney) {
    var msg = "确认要驳回此用户吗?";
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '/admin/rebutPop',
            data: {popId: popId,adminId: adminId, popFlag: popFlag,popMoney: popMoney},
            dataType: 'json',
            success: function (data) {
                if (data.flag == "success") {
                    layer.msg(data.msg, {icon: 1, time: 1000});
                    window.location.reload();
                } else {
                    layer.msg(data.msg, {icon: 2, time: 10000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}

/**
 * 同意
 * @param popId
 * @param userId
 * @param popFlag
 */
function agreePop(popId,adminId, popFlag,popMoney) {
    var msg = "确认给此用户出金?";
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '/admin/agreePop',
            data: {popId: popId,adminId: adminId, popFlag: popFlag,popMoney: popMoney},
            dataType: 'json',
            success: function (data) {
                if (data.flag == "success") {
                    layer.msg(data.msg, {icon: 1, time: 1000});
                    window.location.reload();
                } else {
                    layer.msg(data.msg, {icon: 2, time: 10000});
                }
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                layer.msg('error!', {icon: 1, time: 10000});
            },
        });
    });
}

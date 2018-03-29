

/**
 * 驳回
 * @param goldId
 */
function rebutPop(popId,userId, popFlag,popMoney) {
    var msg = "确认要驳回此用户吗?";
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '/admin/user/rebutPop',
            data: {popId: popId,userId: userId, popFlag: popFlag,popMoney: popMoney},
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
function agreePop(popId,userId, popFlag) {
    var msg;
    if (popFlag == 2) {
        msg = "确认要给此用户出金吗？"
    } else if(popFlag == 3) {
        msg = "确认要给驳回此用户吗？"
    }
    layer.confirm(msg, function () {
        $.ajax({
            type: 'POST',
            url: '<?=U("user/jinzhidenglu")?>',
            data: {userId: userId, loginType: loginType},
            dataType: 'json',
            success: function (data) {

                if (data.status == 1) {
                    layer.msg('操作成功!', {icon: 1, time: 1000});
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

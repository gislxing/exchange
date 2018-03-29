/**
 * 修改银行卡的状态
 * @param id
 * @param status
 */
function changeBankCardStatus(bankCardid, status) {
    layer.confirm('确认要设置为默认银行卡?', function (index) {
        $.ajax({
            type: "POST",
            url: "/admin/my/bank/card/status",
            data: {bankCardid: bankCardid, status: status},
            async: true,
            success: function (data) {
                if (data.flag == "success") {
                    layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                        window.location.reload();
                    });
                } else {
                    layer.msg(data.msg, {icon: 2, time: 1000});
                }
            }
        });
    });
}

/**
 * 删除银行卡
 * @param id
 */
function deleteBankCard(id) {
    layer.confirm('确认要设置为默认银行卡?', function (index) {
        $.ajax({
            type: "POST",
            url: "/admin/my/bank/card/delete",
            data: {bankCardid: id},
            async: true,
            success: function (data) {
                if (data.flag == "success") {
                    layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                        window.location.reload();
                    });
                } else {
                    layer.msg(data.msg, {icon: 2, time: 1000});
                }
            }
        });
    });
}

/**
 * 绑定银行卡
 * @param title
 * @param url
 * @param w
 * @param h
 */
function admin_add(title, url, w, h) {
    layer_show(title, url, w, h);
}

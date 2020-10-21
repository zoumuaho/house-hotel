var http = {};

/**
 * 封装AJAX请求
 * @param url 请求地址
 * @param data  请求数据
 */
http.ajaxSubmit = function (url, data) {
    var index = "";
    $.ajax({
        url: url,
        type: "post",
        data: data,
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        beforeSend: function () {
            index = layer.load(1, {shade: [0.3, '#000']})
        },
        success: function (data) {
            if (data.code === 200) {
                layer.msg(data.message, {icon: 1, time: 1000}, function () {
                    index = parent.layer.getFrameIndex(window.name);
                    parent.location.reload(); //刷新父页面
                });
            } else {
                layer.msg(data.message, {icon: 1, time: 1000});
            }
        },
        error: function () {
            layer.msg('请求出错！', {icon: 1, time: 1000});
        },
        complete: function () {
            layer.close(index);
        }
    });
};

/**
 * 用户登录
 * @param url   请求地址
 * @param data  登录参数
 */
http.ajaxLogin = function (url, data) {
    var index = "";
    $.ajax({
        url: url,
        type: "post",
        data: data,
        dataType: "json",
        async: false,
        contentType: "application/json;charset=UTF-8",
        beforeSend: function () {
            index = layer.load(1, {shade: [0.3, '#000']})
        },
        success: function (res) {
            if (res.code == "200") {
                layer.msg(res.message, {icon: 1, time: 1000}, function () {
                    window.location.href = "/hotel-api/hotel/user/index";
                });
            } else {
                layer.msg(res.message, {icon: 2, time: 2000});
            }
            console.log(res);

        },
        error: function () {
            layer.msg('请求出错！', {icon: 1, time: 1000});
        },
        complete: function () {
            layer.close(index);
        }
    });
};
/**
 * 保存数据
 * @param url   请求地址
 * @param param 请求参数
 */
http.ajaxSaveData = function (url, param) {
    var index = "";
    $.ajax({
        url: url,
        type: "post",
        data: param,
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        async: false,
        beforeSend: function () {
            index = layer.load(1, {shade: [0.3, '#000']})
        },
        success: function (data) {
            if (data.code == '200') {
                layer.msg(data.message, {icon: 1, time: 2000}, function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.location.replace(parent.location.href);
                    parent.layer.close(index);
                });

            } else {
                layer.msg(data.message, {icon: 1, time: 1000});
            }
        },
        error: function () {
            layer.msg('请求出错！', {icon: 1, time: 1000});
        },
        complete: function () {
            layer.close(index);
        }
    });
}

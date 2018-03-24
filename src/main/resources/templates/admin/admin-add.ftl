<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <#include "/admin/include/head-include.ftl" >
</head>

<body>
<article class="page-container">
    <form class="form form-horizontal" id="form-admin-add">
        <input type="hidden" value="<#if data?exists>${data.id!}</#if>" name="id">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text " required=true value="<#if data?exists>${data.username!}</#if>" placeholder="" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>真实姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required=true  value="<#if data?exists>${data.realname!}</#if>" placeholder="真实姓名" id="realname" name="realname">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><#if !(data?exists)><span class="c-red">*</span></#if>初始密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" <#if !(data?exists)>required=true</#if> value="" placeholder="密码" id="password"
                       name="password">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><#if !(data?exists)><span class="c-red">*</span></#if>确认密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" <#if !(data?exists)>required=true</#if> equalTo="#password" placeholder="确认新密码" id="password2"
                       name="password2">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  value="<#if data?exists>${data.phone!}</#if>" placeholder="" id="phone" name="phone">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手续费返佣比例：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required=true range=[0,100] value="<#if data?exists>${data.backRatio!}<#else>0</#if>" placeholder="" id="backRatio" name="backRatio">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>红利返佣比例：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required=true range=[0,100] value="<#if data?exists>${data.redRatio!}<#else>0</#if>" placeholder="" id="redRatio" name="redRatio">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">公司名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="<#if data?exists>${data.companyName!}</#if>" placeholder="" id="companyRame" name="companyRame">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">公司负责人：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="<#if data?exists>${data.companyLead!}</#if>" placeholder="" id="companyLead" name="companyLead">
            </div>
        </div><div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">公司固定电话：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="<#if data?exists>${data.companyTel!}</#if>" placeholder="" id="companyTel" name="companyTel">
            </div>
        </div><div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">公司地址：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="<#if data?exists>${data.companyAddress!}</#if>" placeholder="" id="companyAddress" name="companyAddress">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript">
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
                    url: <#if data?exists>"/admin/update"<#else>"/admin/save"</#if>,
                    success: function (data) {
                        if(data.flag=="success"){
                            layer.msg(data.msg,{icon:1,time:1000},function(){
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.location.reload();
                                parent.layer.close(index);
                            });
                        }else {
                            layer.msg(data.msg,{icon:1,time:1000});
                        }
                    }
                });

            }
        });
    });
</script>
</body>
</html>
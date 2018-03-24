<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <#include "/admin/include/head-include.ftl" >
    <title>修改密码</title>
</head>
<body>
<div class="pd-20">
    <form class="form form-horizontal" id="loginform"  method="post">
        <table class="table table-border table-bordered table-bg">
            <thead>
            <tr>
                <th colspan="2">修改密码</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th class="text-r" width="30%">旧密码：</th>
                <td><input name="oldpassword" id="oldpassword" required=true class="input-text" type="password" autocomplete="off" placeholder="密码" tabindex="1" datatype="*6-16" nullmsg="请输入旧密码！" errormsg="4~16个字符，区分大小写！">
                </td>
            </tr>
            <tr>
                <th class="text-r">新密码：</th>
                <td><input type="password" class="input-text" <#if !(data?exists)>required=true</#if> value="" placeholder="密码" id="password"
                           name="password">
                </td>
            </tr>
            <tr>
                <th class="text-r">再次输入新密码：</th>
                <td><input type="password" class="input-text" <#if !(data?exists)>required=true</#if> equalTo="#password" placeholder="确认新密码" id="password2"
                           name="password2">
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <button type="submit" class="btn btn-success radius" id="admin-password-save" name="admin-password-save"><i class="icon-ok"></i> 确定</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/password-update.js">

</script>
</body>
</html>
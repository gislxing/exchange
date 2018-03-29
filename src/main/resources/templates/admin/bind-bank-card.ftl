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
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>卡号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text " required=true value="" placeholder="银行卡卡号" id="accountNo"
                       name="accountNo">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>户主姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required=true value="" placeholder="户主姓名" id="accountName"
                       name="accountName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>银行名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required=true value="" placeholder="银行名称" id="bankName"
                       name="bankName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>预留身份证号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required=true value="" placeholder="银行卡预留身份证号" id="bankIdcard"
                       name="bankIdcard">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>预留手机号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" required=true isPhone=true placeholder="银行卡预留手机号" id="bankPhone" name="bankPhone">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否默认银行卡：</label>
            <div class="formControls col-xs-8 col-sm-9">
                    <label>
                    <input type="radio" class="radio" checked checked="" value="1" name="bankFlag">否
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                    <input type="radio" class="radio" value="2" name="bankFlag">是
                    </label>
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
<script type="text/javascript" src="/admin/js/bind-bank-card.js"></script>
</body>
</html>
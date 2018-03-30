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
    <title></title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 我的资金 <span
        class="c-gray en">&gt;</span> 我的银行卡 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                               href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <form searchCond="true" action="/admin/my/bank/card" method="get"></form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="admin_add('绑定银行卡','/admin/my/bank/card/bind','600','400')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 绑定银行卡
            </a>
        </span>
        <span class="r">
            共有数据：<strong>${pageInfo.total!"0"}</strong> 条
        </span>
    </div>

    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th width="150">银行卡卡号</th>
            <th width="60">银行名称</th>
            <th width="90">户主姓名</th>
            <th width="150">预留手机号</th>
            <th width="130">预留身份证号</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <#if data?exists>
        <#list data as tmp>
        <tr class="text-c">
            <td>${tmp.accountNo!}</td>
            <td>${tmp.bankName!}</td>
            <td>${tmp.accountName!}</td>
            <td>${tmp.bankPhone!}</td>
            <td>${tmp.bankIdcard!}</td>
            <td>
                <button type="button" class="btn <#if tmp.bankFlag == 2>btn-default<#else>btn-success</#if> radius" <#if tmp.bankFlag == 2>disabled</#if>
                        onclick="changeBankCardStatus('${tmp.id!}', 2);">设为默认银行卡
                </button>
                <button type="button" class="btn btn-danger radius"
                        onclick="deleteBankCard('${tmp.id!}');">删除银行卡
                </button>
            </td>
        </tr>
        </#list>
        </#if>
        </tbody>
    </table>
    <#include "/admin/include/page.ftl">
</div>
<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/bank-card.js"></script>
</body>
</html>
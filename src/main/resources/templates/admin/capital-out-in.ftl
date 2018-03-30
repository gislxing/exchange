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
    <title>出入金明细</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 我的资金 <span
        class="c-gray en">&gt;</span> 出入金明细 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                               href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form id="adminListBean1" searchCond="true" name="adminListBean1" action="/admin/my/capital" method="get">
        <div class="text-c"> 注册时间：
            <input type="text" value=""
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                   name="addStartTime" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value=""
                   onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
                   name="addEndTime" class="input-text Wdate" style="width:120px;">
            <span class="select-box inline" style="margin-left: 20px">
                <select name="" class="select" id="buyWay">
                    <option value="0">出入金类别</option>
                </select>
            </span>
            <span class="select-box inline" style="margin-left: 20px">
                <select name="" class="select" id="buyWay">
                    <option value="0">出入金状态</option>
                </select>
            </span>
            <button type="submit" class="btn btn-success" id="subForm" name="subForm" style="margin-left: 20px">
                <i class="Hui-iconfont">&#xe665;</i>搜用户
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="admin_add('添加管理员','/admin/add','770','680')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe6a1;</i> 出金
            </a>
            <a href="javascript:;" onclick="admin_add('添加管理员','/admin/add','770','680')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 入金
            </a>
        </span>
        <#--<span class="r">共有数据：<strong>${pageInfo.total!"0"}</strong> 条</span>-->
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th width="50">申请时间</th>
            <th width="50">用户名</th>
            <th width="50">出/入金</th>
            <th width="80">积分</th>
            <th width="50">户主姓名</th>
            <th width="80">开户行</th>
            <th width="100">银行卡卡号</th>
            <th width="100">预留手机号</th>
            <th width="100">预留身份证号</th>
            <th width="50">审核状态</th>
        </tr>
        </thead>
        <tbody>
        <#if data?exists>
        <#list data as admin>
        <tr class="text-c">
            <td width="40">${admin.id}</td>
            <td width="150">${admin.username!}</td>
            <td width="90">${admin.phone!}</td>
            <td width="150">${admin.realname!}</td>
            <td width="150">${admin.money!}</td>
            <td width="130">${admin.showLevel!}</td>
            <td width="100" class="user-status">
                <#if (admin.status?exists && admin.status == 0)>
                    <span class="label radius">已禁用</span>
                <#elseif (admin.status?exists && admin.status == 1)>
                    <span class="label label-success radius">启用</span>
                <#else>
                    <span class="label radius">状态错误</span>
                </#if>
            </td>
            <td width="100"><#if admin.addTime?exists>${admin.addTime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
            <td width="100">${admin.lastLoginIp!}</td>
            <td width="100"><#if admin.lastLoginTime?exists>${admin.lastLoginTime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
        </tr>
        </#list>
        </#if>
        </tbody>
    </table>
    <#--<#include "/admin/include/page.ftl">-->
</div>
<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/capital-out-in.js"></script>
</body>
</html>
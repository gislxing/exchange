﻿<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
	<#include "/admin/include/head-include.ftl" >
    <title>运营中心列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span
        class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                               href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form id="adminListBean1" searchCond="true" name="adminListBean1" action="/admin/proxy" method="get">
        <div class="text-c"> 注册时间：
            <input type="text" value="${searchData.addStartTime!}"
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                   name="addStartTime" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="${searchData.addEndTime!}"
                   onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
                   name="addEndTime" class="input-text Wdate" style="width:120px;">
            <input type="text" value="${searchData.conditions!}" class="input-text" style="width:250px"
                   placeholder="登录名/姓名/手机号" id="conditions" name="conditions">
            <button type="submit" class="btn btn-success" id="subForm" name="subForm"><i
                    class="Hui-iconfont">&#xe665;</i> 搜用户
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l"><a
            href="javascript:;" onclick="admin_add('添加管理员','/admin/add','770','680')"
            class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a></span> <span
            class="r">共有数据：<strong>${pageInfo.total!"0"}</strong> 条</span></div>

    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="11">列表</th>
        </tr>
        <tr class="text-c">
            <th width="40">ID</th>
            <th width="150">登录名</th>
            <th width="90">手机</th>
            <th width="150">姓名</th>
            <th>账户余额</th>
            <th width="130">客户等级</th>
            <th width="100">状态</th>
            <th width="100">注册时间</th>
            <th width="100">最后登录IP</th>
            <th width="100">最后登录时间</th>
            <th width="100">操作</th>
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
            <td width="130">${admin.lelevl!}</td>
            <td width="100">${admin.lelevl!}</td>
            <td width="100"><#if admin.addTime?exists>${admin.addTime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
            <td width="100">${admin.lastLoginIp!}</td>
            <td width="100">${admin.lastLoginTime!}</td>
            <td width="100"></td>
        </tr>
        </#list>
        </#if>
        </tbody>
    </table>
    <#include "/admin/include/page.ftl">
</div>
<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/proxy-list.js"></script>
</body>
</html>
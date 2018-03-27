<?php
/**
 * Created by PhpStorm.
 * User: ZL
 * Date: 2017/9/14
 * Time: 11:11
 */ ?>

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
    <title>客户出金列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资金管理 <span
            class="c-gray en">&gt;</span>客户人金明细 <a class="btn btn-success radius r refres"
                                                           style="line-height:1.6em;margin-top:3px"
                                                           href="javascript:location.replace(location.href);"
                                                           title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form id="adminListBean1" searchCond="true" name="adminListBean1" action="/admin/user/userPayList" method="get">
        <div class="text-c">
            入金时间：
            <input type="text" value="${searchData.addStartTime!}"
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                   name="addStartTime" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="${searchData.addEndTime!}"
                   onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
                   name="addEndTime" class="input-text Wdate" style="width:120px;">
            <input type="text" value="${searchData.conditions!}" class="input-text" style="width:250px"
                   placeholder="登录名/姓名/手机号" id="conditions" name="conditions">
            <span class="select-box inline">
            <select name="flag" class="select" id="payFlag" name="payFlag">
                <option value="0" <#if searchData.payType! == "0">selected</#if>>支付状态</option>
                <option value="2" <#if searchData.payType! == "1">selected</#if>>已支付</option>
                <option value="1" <#if searchData.payType! == "2">selected</#if>>未支付</option>
            </select>
            </span>
            <span class="select-box inline">
            <select name="place" class="select" id="payType" name="payType">
                <option value="0" <#if searchData.payType! == "0">selected</#if>>入金渠道</option>
                <option value="3" <#if searchData.payType! == "1">selected</#if>>快捷支付</option>
                <option value="1" <#if searchData.payType! == "2">selected</#if>>支付宝支付</option>
                <option value="2" <#if searchData.payType! == "3">selected</#if>>微信支付</option>
                <option value="4" <#if searchData.payType! == "4">selected</#if>>QQ支付</option>
            </select>
            </span>

            <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">

        <span class="r">

        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="12"></th>
        </tr>
        <tr class="text-c">
            <th>名称</th>
            <th>手机号</th>
            <th>渠道</th>
            <th>金额</th>
            <th>状态</th>
            <th>提交时间</th>
            <th>综合会员</th>
            <th>微圈代理</th>
        </tr>
        </thead>
        <tbody>
        <#if data?exists>
            <#list data as admin>
            <tr class="text-c">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <#include "/admin/include/page.ftl">
</div>
<#include "/admin/include/foot-include.ftl"/>
</body>
</html>
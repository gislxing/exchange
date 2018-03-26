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
            class="c-gray en">&gt;</span>客户出金明细 <a class="btn btn-success radius r refres"
                                                           style="line-height:1.6em;margin-top:3px"
                                                           href="javascript:location.replace(location.href);"
                                                           title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form action="">
        <div class="text-c">
            入金时间：
            <input placeholder="开始时间" type="text"
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                   class="input-text Wdate" name="start" value="" style="width:120px;">
            -
            <input placeholder="结束时间" type="text"
                   onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })"
                   id="datemax"
                   class="input-text Wdate" name="end" value="" style="width:120px;">

            <input type="text" class="input-text" style="width:150px" placeholder="入金人手机号" id=""
                   value=""
                   name="username">
            <input type="text" class="input-text" style="width:150px" placeholder="入金人姓名" id="" value=""
                   name="realname">
            <input type="text" class="input-text" style="width:150px" placeholder="上级人员用户名" id=""
                   value=""
                   name="jname">
            <span class="select-box inline">
            <select name="flag" class="select">

            </select>
            </span>
            <span class="select-box inline">
            <select name="place" class="select">

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

        </tbody>
    </table>
    <#include "/admin/include/page.ftl">
</div>
<#include "/admin/include/foot-include.ftl"/>
</body>
</html>
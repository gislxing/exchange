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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 客户管理 <span
        class="c-gray en">&gt;</span> 客户交易 <a class="btn btn-success radius r refres"
                                              style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);"
                                              title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form searchCond="true" action="/admin/user/deal" method="get">
        <div class="text-c">
            <input type="text" class="input-text" style="width:150px" placeholder="手机号/账号/真实姓名" id=""
                   value="${searchData.conditions!}"
                   name="conditions">
            <span class="select-box inline">
            <select name="goodsId" class="select" id="goodsId">
                <option value="">所有商品</option>
                <#if goodsList?exists>
                    <#list goodsList as goods>
                        <option value="${goods.id!}"
                                <#if (searchData.goodsId?exists) && (searchData.goodsId == goods.id)>selected</#if>>${goods.name!}</option>
                    </#list>
                </#if>
            </select>
            </span>
            <span class="select-box inline">
            <select name="" class="select" id="buyWay">
                <option value="0">限时竞购</option>
            </select>
            </span>
            <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="r">
            共有数据：<strong>${pageInfo.total!"0"}</strong> 条
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th>手机号</th>
            <th>真实名称</th>
            <th>综合会员</th>
            <th>微圈代理</th>
            <th>商品名称</th>
            <th>玩法类型</th>
            <th>交易金额</th>
            <th>交易时间</th>
        </tr>
        </thead>
        <tbody>
        <#if data?exists>
            <#list data as tmp>
            <tr class="text-c">
                <td>${tmp.username!}</td>
                <td>${tmp.realname!}</td>
                <td>${tmp.compMemberName!}</td>
                <td>${tmp.microProxyName!}</td>
                <td>${tmp.goodsName!}</td>
                <td>限时竞购</td>
                <td><#if tmp.buyPrice?exists>${tmp.buyPrice?string(",##0.00")}<#else>0.00</#if></td>
                <td><#if tmp.buyAddTime?exists>${tmp.buyAddTime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
            </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <#include "/admin/include/page.ftl">
</div>
<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/user-deal.js"></script>
</body>
</html>
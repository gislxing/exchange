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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户管理 <span
        class="c-gray en">&gt;</span> 客户列表 <a class="btn btn-success radius r refres"
                                              style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);"
                                              title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form searchCond="true" action="/admin/user/list" method="get">
        <div class="text-c"> 注册时间：
            <input type="text" value="<#if searchData?exists>${searchData.addStartTime!}</#if>"
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                   name="addStartTime" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="<#if searchData?exists>${searchData.addEndTime!}</#if>"
                   onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
                   name="addEndTime" class="input-text Wdate" style="width:120px;">
            <input type="text" value="<#if searchData?exists>${searchData.conditions!}</#if>" class="input-text"
                   style="width:250px"
                   placeholder="登录名/真实姓名/所属代理" id="conditions" name="conditions">
            <button type="submit" class="btn btn-success" id="subForm" name="subForm"><i
                    class="Hui-iconfont">&#xe665;</i> 搜用户
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="r">
            共有数据：<strong><#if pageInfo?exists>${pageInfo.total!"0"}<#else>0</#if></strong> 条
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th width="5%">编号</th>
            <th>注册时间</th>
            <th>用户名</th>
            <th>真实姓名</th>
            <th>综合会员</th>
            <th>微圈代理</th>
            <th>账户余额</th>
            <th>交易状态</th>
            <th>登录状态</th>
            <th>出金状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <#if data?exists>
                <#list data as user>
                    <tr class="text-c">
                        <td>${user.id}</td>
                        <td><#if user.addTime?exists>${user.addTime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
                        <td>${user.username!}</td>
                        <td>${user.realname!}</td>
                        <td>${user.compMemberName!}</td>
                        <td>${user.microProxyName!}</td>
                        <td>${user.money!}</td>
                        <td>
                            <#if user.tradeable == 1>
                                正常交易
                            <#else>
                                暂停交易
                            </#if>
                        </td>
                        <td>
                            <#if user.loginType == 1>
                                可登录
                            <#else>
                                不可登录
                            </#if>
                        </td>
                        <td>
                            <#if user.chujinType == 1>
                                可出金
                            <#else>
                                不可出金
                            </#if>
                        </td>
                        <td>
                            <button type="button" class="btn btn-warning radius" <#if user.tradeable == 0>disabled</#if>
                                    onclick="updateTransactionStatus('${user.id!}',0);"> 暂停交易
                            </button>
                            <button type="button" class="btn btn-success radius" <#if user.tradeable == 1>disabled</#if>
                                    onclick="updateTransactionStatus('${user.id!}',1);">恢复交易
                            </button>
                            <#if level == 1>
                                <button type="button" class="btn btn-danger radius" id="" name=""
                                        onclick="resetPassword('${user.id!}');">重置密码
                                </button>
                                <button type="button" class="btn btn-danger radius" <#if user.loginType == 2>disabled</#if>
                                              onclick="jinzhidenglu('${user.id!}',2);"> 禁止登录
                                </button>
                                <button type="button" class="btn btn-success radius" <#if user.loginType == 1>disabled</#if>
                                              onclick="jinzhidenglu('${user.id!}',1);"> 恢复登录
                                </button>
                                <button type="button" class="btn btn-warning radius" <#if user.chujinType == 2>disabled</#if>
                                        onclick="jinzhichujin('${user.id!}',2);"> 禁止出金
                                </button>
                                <button type="button" class="btn btn-success radius" <#if user.chujinType == 1>disabled</#if>
                                        onclick="jinzhichujin('${user.id!}',1);"> 恢复出金
                                </button>
                            </#if>
                        </td>
                    </tr>
                </#list>
            </#if>
        </tbody>
    </table>
    <#include "/admin/include/page.ftl">
</div>

<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/user-list.js"></script>

</body>
</html>
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
    <title><?= $title ?></title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资金管理 <span
            class="c-gray en">&gt;</span> 代理出金明细<a class="btn btn-success radius r refres"
                                                           style="line-height:1.6em;margin-top:3px"
                                                           href="javascript:location.replace(location.href);"
                                                           title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form id="adminListBean1" searchCond="true" name="adminListBean1" action="/admin/porxyPopList" method="get">
        <div class="text-c">
            申请时间：
            <input type="text" value="${searchData.addStartTime!}"
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                   name="addStartTime" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="${searchData.addEndTime!}"
                   onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
                   name="addEndTime" class="input-text Wdate" style="width:120px;">
            审核时间：
            <input type="text" value="${searchData.appStartTime!}"
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'appdatemax\')||\'%y-%M-%d\'}' })" id="appdatemin"
                   name="appStartTime" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" value="${searchData.appEndTime!}"
                   onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'appdatemin\')}',maxDate:'%y-%M-%d' })" id="appdatemax"
                   name="appEndTime" class="input-text Wdate" style="width:120px;">
            <input type="text" value="${searchData.conditions!}" class="input-text" style="width:250px"
                   placeholder="登录名/姓名" id="conditions" name="conditions">
        </div>
        <div class="text-c">
            提现银行卡户主姓名：<input type="text" value="${searchData.bankUserName!}" class="input-text" style="width:250px"
                   placeholder="银行卡户主姓名" id="bankUserName" name="bankUserName">
            提现银行卡名称：<input type="text" value="${searchData.bankName!}" class="input-text" style="width:250px"
                   placeholder="银行卡名称" id="bankName" name="bankName">
            <span class="select-box inline">
            <select class="select" id="popFlag" name="popFlag">
                <option value="" <#if searchData.popFlag?exists && searchData.popFlag == "">selected</#if>>提现状态</option>
                <option value="1" <#if searchData.popFlag?exists && searchData.popFlag == "1">selected</#if>>申请</option>
                <option value="2" <#if searchData.popFlag?exists && searchData.popFlag == "2">selected</#if>>通过</option>
                <option value="3" <#if searchData.popFlag?exists && searchData.popFlag == "3">selected</#if>>驳回</option>
            </select>
            </span>
            <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="r">
            <#--共有数据：<strong><?= $count ?></strong> 条
            &nbsp;|&nbsp;共出金：<strong><?= $pop_money ? $pop_money : 0 ?></strong> 元
             &nbsp;|&nbsp;成功：<strong><?= $success ? $success : 0 ?></strong> 元
            &nbsp;|&nbsp;失败：<strong><?= $error ? $error : 0 ?></strong> 元-->
        </span></div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="18"><?= $title ?></th>
        </tr>
        <tr class="text-c">
            <th width="5%">编号</th>
            <th>用户名</th>
            <th>手机号</th>
            <th>真实姓名</th>
            <th>金额</th>
            <th>申请时间</th>
            <th>审核状态</th>
            <th>账号姓名</th>
            <th>开户行</th>
            <th>银行卡号</th>
            <th>银行预留手机号</th>
            <th>银行卡预留户主身份证号</th>
            <#if adminBean.level == 1>
            <th>操作</th>
            </#if>
        </tr>
        </thead>
        <tbody>
     <#if data?exists>
         <#list data as proxyPopVo>
        <tr class="text-c">
            <td>${proxyPopVo.popId!}</td>
            <td>${proxyPopVo.username!}</td>
            <td>${proxyPopVo.phone!}</td>
            <td>${proxyPopVo.realname!}</td>
            <td>${proxyPopVo.popMoney!}</td>
            <td>
            <#if proxyPopVo.popTime?exists>${proxyPopVo.popTime?string("yyyy-MM-dd HH:mm:ss")}</#if>
            </td>
            <td>
                <span class="label radius">
                 <#if proxyPopVo.popFlag?exists>
                    <#if proxyPopVo.popFlag == 1>
                        申请
                    </#if>
                     <#if proxyPopVo.popFlag == 2>
                        通过
                     </#if>
                     <#if proxyPopVo.popFlag == 3>
                        驳回
                     </#if>
                 </#if>
                </span>
            </td>
            <td>${proxyPopVo.popName!}</td>
            <td>${proxyPopVo.popAccount!}</td>
            <td>${proxyPopVo.popCode!}</td>
            <td>${proxyPopVo.popPhone!}</td>
            <td>${proxyPopVo.popIdcard!}</td>
            <#if adminBean.level == 1>
            <th>
                <#if proxyPopVo.popFlag == 1>
                <button type="button" class="btn btn-danger radius"
                        onclick="agreePop(${proxyPopVo.popId!},${proxyPopVo.adminId!},2,${proxyPopVo.popMoney!});"> 通过
                </button>
                <button type="button" class="btn btn-success radius"
                        onclick="rebutPop(${proxyPopVo.popId!},${proxyPopVo.adminId!},3,${proxyPopVo.popMoney!});"> 驳回
                </button>
                </#if>

            </th>
            </#if>
        </tr>
         </#list>
     </#if>
        </tbody>
    </table>
    <#include "/admin/include/page.ftl">
</div>
<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/proxyPopInfoList.js"></script>
</body>
</html>
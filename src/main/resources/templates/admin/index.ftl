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
    <title>H-ui.admin v3.1</title>
    <meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"><a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">H-ui.admin</a>
            <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">v3.1</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>

            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>${showLevel}</li>
                    <li class="dropDown dropDown_hover">
                        <a href="#" class="dropDown_A">${username} <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="/admin/logout">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <dl id="menu-article">
            <dt><i class="Hui-iconfont">&#xe6d8;</i> 代理管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/admin/password/update" data-title="密码修改" href="javascript:void(0)">密码修改</a></li>
                    <#if loginAdminLevel == 1>
                        <li><a data-href="/admin/proxy/2" data-title="运营中心管理" href="javascript:void(0)">运营中心管理</a></li>
                    </#if>
                    <#if (loginAdminLevel <= 2) && (loginAdminLevel >= 1)>
                        <li><a data-href="/admin/proxy/3" data-title="综合会员管理" href="javascript:void(0)">综合会员管理</a></li>
                    </#if>
                    <#if (loginAdminLevel <= 3) && (loginAdminLevel >= 1)>
                        <li><a data-href="/admin/proxy/4" data-title="微圈代理管理" href="javascript:void(0)">微圈代理管理</a></li>
                    </#if>
                </ul>
            </dd>
        </dl>
        <dl id="menu-customer">
            <dt><i class="Hui-iconfont">&#xe62d;</i> 客户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/admin/user/list" data-title="客户列表" href="javascript:void(0)">客户列表</a></li>
                    <li><a data-href="/wel" data-title="客户交易" href="javascript:void(0)">客户交易</a></li>
                    <li><a data-href="/wel" data-title="客户持仓" href="javascript:void(0)">客户持仓</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-capital">
            <dt><i class="Hui-iconfont">&#xe63a;</i> 资金管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/admin/user/userPopList" data-title="客户出金明细" href="javascript:void(0)">客户出金明细</a></li>
                    <li><a data-href="/admin/user/userPayList" data-title="客户入金明细" href="javascript:void(0)">客户入金明细</a></li>
                    <li><a data-href="/admin/porxyPopList" data-title="代理出金审核" href="javascript:void(0)">代理出金审核</a></li>
                    <li><a data-href="/admin/proxyPayList" data-title="代理入金记录" href="javascript:void(0)">代理入金记录</a></li>
                    <li><a data-href="/wel" data-title="我的返现明细" href="javascript:void(0)">我的返现明细</a></li>
                    <li><a data-href="/wel" data-title="运营中心交易收益明细" href="javascript:void(0)">运营中心交易收益明细</a></li>
                    <li><a data-href="/wel" data-title="综合会员交易收益明细" href="javascript:void(0)">综合会员交易收益明细</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-report">
            <dt><i class="Hui-iconfont">&#xe616;</i> 汇总报表<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/wel" data-title="成交汇总报表" href="javascript:void(0)">成交汇总报表</a></li>
                    <li><a data-href="/wel" data-title="客户出入金汇总报表" href="javascript:void(0)">客户出入金汇总报表</a></li>
                    <li><a data-href="/wel" data-title="客户盈亏统计" href="javascript:void(0)">客户盈亏统计</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-goods">
            <dt><i class="Hui-iconfont">&#xe620;</i> 商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/wel" data-title="商品分类" href="javascript:void(0)">商品分类</a></li>
                    <li><a data-href="/wel" data-title="商品列表" href="javascript:void(0)">商品列表</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-goods">
            <dt><i class="Hui-iconfont">&#xe62e;</i> 系统设置<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/wel" data-title="帮助列表" href="javascript:void(0)">帮助列表</a></li>
                    <li><a data-href="/wel" data-title="操作记录" href="javascript:void(0)">操作记录</a></li>
                    <li><a data-href="/wel" data-title="网站设置" href="javascript:void(0)">网站设置</a></li>
                    <li><a data-href="/wel" data-title="风控设置" href="javascript:void(0)">风控设置</a></li>
                    <li><a data-href="/wel" data-title="持仓风控" href="javascript:void(0)">持仓风控</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="welcome.html">我的桌面</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S"
                                                  href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <#include "/admin/welcome.ftl">
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前</li>
        <li id="closeall">关闭全部</li>
    </ul>
</div>
<#include "/admin/include/foot-include.ftl"/>
</body>
</html>
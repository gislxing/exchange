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
            class="c-gray en">&gt;</span> <?= $title ?> <a class="btn btn-success radius r refres"
                                                           style="line-height:1.6em;margin-top:3px"
                                                           href="javascript:location.replace(location.href);"
                                                           title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form action="">
        <div class="text-c"> 注册时间：
            <input placeholder ="开始时间" type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                   class="input-text Wdate" name="start" value="<?=$start?>" style="width:120px;">
            -
            <input placeholder = "结束时间" type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })"
                   id="datemax"
                   class="input-text Wdate" name="end" value="<?=$end?>" style="width:120px;">
            用户名：
            <input type="text" class="input-text" style="width:150px" placeholder="输入登录名" id="" value="<?=$username?>" name="username">
            姓名：
            <input type="text" class="input-text" style="width:150px" placeholder="输入姓名" id="" value="<?=$realname?>" name="realname">
            所属代理：
            <input type="text" class="input-text" style="width:150px" placeholder="" id="" value="<?=$dlusername?>" name="dlusername">
            <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户
            </button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="r">
            共有数据：<strong><?= $count ?></strong> 条
            &nbsp;|&nbsp;余额共：<strong><?= $money ?></strong> 元
             &nbsp;|&nbsp;<?=C("SecondName")?>共：<strong><?= $coin ?></strong> <?=C("SecondUnit")?>
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="18"><?= $title ?></th>
        </tr>
        <tr class="text-c">
            <th width="5%">编号</th>
            <th>注册时间</th>
            <th>用户名</th>
            <th>姓名</th>
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
        <?php foreach ($list as $key => $val): ?>
            <tr class="text-c">
                <td><?= $val['id'] ?></td>
                <td><?= date("Y-m-d H:i:s",$val['addtime']) ?></td>
                <td><?= $val['username'] ?></td>
                <td><?= $val['realname'] ?></td>
                <td><?= \Common\models\Service\AdminService::getUserInfo($val['yunyingid'])['username'] ?></td>
                <td><?= \Common\models\Service\AdminService::getUserInfo($val['zhongheid'])['username'] ?></td>
                <td><?= $val['money'] ?></td>
                <td>
                    <if condition="$val['tradeable'] eq 1">正常交易
                        <else /> 暂停交易
                    </if>
                </td>
                <td>
                    <if condition="$val['logintype'] eq 1">可登录
                        <else /> 不可登录
                    </if>
                </td>
                <td>
                    <if condition="$val['chujintype'] eq 1">可出金
                        <else /> 不可出金
                    </if>
                </td>
                <td>
                    <button type="button" class="btn btn-success radius" onclick="autonym('实名信息','<?=U("user/autonym",['id' => $val['id']])?>')">实名信息</button>
                    <?php if($val['tradeable'] == 1):?>
                    &nbsp;<button type="button" class="btn btn-warning radius" id="" name="" onclick="zantingjiaoyi('<?= $val['id'] ?>',0);"> 暂停交易</button>
                    <?php else:?>
                        <button type="button" class="btn btn-success radius" id="" name="" onclick="zantingjiaoyi('<?= $val['id'] ?>',1);">恢复交易</button>
                    <?php endif;?>
                    <if condition="$adminLelevl eq 1">
                        <button type="button" class="btn btn-danger radius" id="" name="" onclick="resetPassword('<?= $val['id'] ?>');">重置密码</button>
                        <?php if($val['logintype'] == 1):?>
                        &nbsp;<button type="button" class="btn btn-danger radius" id="" name="" onclick="jinzhidenglu('<?= $val['id'] ?>',2);"> 禁止登录</button>
                        <?php else:?>
                            &nbsp;<button type="button" class="btn btn-success radius" id="" name="" onclick="jinzhidenglu('<?= $val['id'] ?>',1);"> 恢复登录<?=$val['loginType']?></button>
                        <?php endif;?>
                        <?php if($val['chujintype'] == 1):?>
                        <button type="button" class="btn btn-warning radius" id="" name="" onclick="jinzhichujin('<?= $val['id'] ?>',2);"> 禁止出金</button>
                        <?php else:?>
                            <button type="button" class="btn btn-success radius" id="" name="" onclick="jinzhichujin('<?= $val['id'] ?>',1);"> 恢复出金</button>
                        <?php endif;?>
                    </if>
                </td>

            </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
    <div class="dataTables_paginate">

    </div>
</div>

<#include "/admin/include/foot-include.ftl"/>
<script type="text/javascript" src="/admin/js/userList.js"></script>

</body>
</html>
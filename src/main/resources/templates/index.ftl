<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#list users as user>
        用户名：${user.userName}
        <br>
        电话：${user.phone}
        <br>
        <br>
    </#list>
</body>
</html>
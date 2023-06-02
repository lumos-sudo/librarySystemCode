<%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/5/27
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }

    html {
        height: 100%;
    }
    body {
        height: 100%;
    }
    .container0{
        height: 100%;
        background-image: linear-gradient(to right, #117c6f, #289c8e,#2fc4b2,#8de5db,#b2f0eb);
    }

    .login-wrapper {
        background-image: linear-gradient(to right,#018abe,#97cadb,#d6e8ee);
        width: 358px;
        height: 588px;
        border-radius: 15px;
        padding: 0 50px;
        position: relative;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
    }
    .header {
        font-size: 38px;
        font-weight: bold;
        text-align: center;
        line-height: 200px;
    }
    .rbtn{
        text-align:center;
        padding-bottom: 30px;
    }
    .input-item {
        display: block;
        width: 100%;
        margin-bottom: 20px;
        border: 0;
        padding: 10px;
        border-bottom: 1px solid rgb(128,125,125);
        font-size: 15px;
        outline: none;
    }
    .input-item::placeholder {
        text-transform: uppercase;
    }
    .btn {
        text-align: center;
        padding: 10px;
        width: 100%;
        margin-top: 40px;
        background-color: bisque;
        color: black;
    }
    .msg {
        text-align: center;
        line-height: 88px;
    }
    a {
        text-decoration-line: none;
        color: red;
    }

    .container{
        display: none;
        width:400px;
        height:400px;
        position:absolute;
        left:50%;
        top:50%;
        transform:translate(-50%,-50%);
    }
    .drag-bar{
        width:100%;
        height:30px;
        background-color:#d8dadb;
    }
    .content{
        width:100%;
        height:370px;
        background-color:#f1f3f4;
        display:flex;
        justify-content:center;
        align-items:center;
    }
    .close{
        display:block;
        position:relative;
        text-align:right;
        left:-10px;
        top:15px;
        color:red;
        font-size:25px;
        transform:translateY(-50%);
        text-decoration:none;
    }
</style>
<body>

<div class="container0">
    <div class="login-wrapper" >
        <form action="/librarySystem_war/testServlet" id="form" method="get">
            <div class="header">登录</div>
            <div class="rbtn">
                <input type="radio" id="user" name="object" value="1" checked="checked" onclick="change1()">
                <label for="user">用户</label>
                <input type="radio" id="librarian" name="object" value="0" onclick="change2()">
                <label for="librarian">图书管理员</label>
                <input type="radio" id="system_administrator" name="object" value="0" onclick="change3()">
                <label for="system_administrator">系统管理员</label>
            </div>
            <div class="form-wrapper">
                <table>
                    <tr>
                        <td>用户名：</td>
                        <td>
                            <input type="text" name="name" id="username" placeholder="用户名" class="input-item">
                        </td>
                    </tr>

                    <tr>
                        <td>密码：</td>
                        <td>
                            <input type="password" name="password" id="password" placeholder="密码" class="input-item">
                        </td>
                    </tr>

                    <tr>

                        <td  style=" text-align:center;">
                            <div id="errMsg">${login_msg}</div>
                        </td>
                    </tr>

                </table>

                <button class="btn" name="btn" type="submit">登录</button>
            </div>

            <div class="msg">
                没有账户？
                <a href="#" onclick="openDialog1()">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <a href="#" onclick="openDialog2()">忘记密码</a>
            </div>
        </form>
    </div>



    <div id="light2" class="container">
        <div class="drag-bar">
            <div style="width:5%;margin-left:90%"><a href = "javascript:void(0)" onclick = "closeDialog2()" class="close" >×</a></div>
        </div>
        <div class="content">
            <form>
                <table align="center">
                    <caption>忘记密码</caption>
                    <tr>
                        <td>绑定的qq账号：</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>验证码：</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" style="text-align: center; padding: 5px;">
                            <input type="button" value="提交"/>
                            <input type="reset" value="重置"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>
<script>
    function change1()
    {
        this.value=1;
    }
    function change2()
    {
        this.value=2;
    }
    function change3()
    {
        this.value=3;
    }
</script>
</body>
</html>
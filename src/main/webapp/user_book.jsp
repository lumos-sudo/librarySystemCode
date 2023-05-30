<%@ page import="com.library.service.bookService" %>
<%@ page import="com.library.pojo.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/5/29
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<style>
    a:link{
        font-size: 20px;
        color: rgb(109,109,109);
        text-decoration: none;
    }

    a:visited{
        font-size: 20px;
        color: rgb(109,109,109);
        text-decoration: none;
    }

    a:hover{
        font-size: 20px;
        color: white;
        text-decoration: none;
    }

    *{
        box-sizing: border-box;
    }

    div.search {
        padding: 10px 0;
    }

    form {
        position: relative;
        width: 500px;
        margin: 0 auto;
    }

    input,button {
        border: none;
        outline: none;
    }

    .search input {
        width: 100%;
        height: 42px;
        padding-left: 13px;
        border: 2px solid #c5464a;
        border-radius: 19px;
        background: transparent;
    }

    .search button {
        height: 42px;
        width: 42px;
        cursor: pointer;
        position: absolute;
        background: #c5464a;
        border-radius: 0 19px 19px 0;
        width: 60px;
        right: 0;
    }
    .search button:hover {
        background-color: #c7585c;
    }

    .search button:before {
        content: "查询";
        font-size: 13px;
        color: #F9F0DA;
    }

    .container{
        display: none;
        width:70%;
        height:70%;
        position:absolute;
        left:58%;
        top:49%;
        transform:translate(-50%,-50%);
    }
    .drag-bar{
        width:100%;
        height:5%;
        background-color:#d8dadb;
        border-top-left-radius:10px;
        border-top-right-radius:10px;
    }
    .content{
        width:100%;
        height:95%;
        background-color:#f1f3f4;
        display:flex;
        justify-content:center;
        align-items:center;
        border-bottom-left-radius:10px;
        border-bottom-right-radius:10px;
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
    #light{
        display: none;
    }

</style>
<body>
<div >

    <div style="background-color: rgb(0,21,41);width: 20%; height: 800px;float:left;">

        <div style="background-color: rgb(0,40,77);">
            <img src="img/touxiang.png" style="width:250px; height: 250px; padding:20px 0px 25px 45px; "/>
        </div>

        <div style="text-align: center; padding:30px 0px 15px 0px; ">
            <a href="user_borrow.html">查询与借阅</a>
        </div>

        <div style="text-align: center; padding:20px 0px 15px 0px; ">
            <a href="user_list.html">借书记录</a>
        </div>

        <div style="text-align: center; padding:20px 0px 15px 0px; ">
            <a href="user_return.html">归还图书</a>
        </div>

        <div style="text-align: center; padding:20px 0px 20px 0px; ">
            <a href="login.jsp">退出登录</a>
        </div>

    </div>

    <div style="width:80%; height: 800px; float:left;">
        <div style="height: 70px; color: rgb(109,109,109); font-size: 18px; line-height: 70px; font-weight: bold; padding-left: 20px;">
            &nbsp;&nbsp;查询与借阅
        </div>

        <div style="background-color: rgb(240,242,245);height: 730px;padding: 20px;">
            <div style="background-color: white;height: 730px;border:none;border-radius: 5px;">

                <div class="search" style="box-sizing: border-box;">
                    <form action="" method="post">
                        <input placeholder="请输入图书的相关信息" name="keyword" type="text">
                        <button type="submit"></button>
                    </form>
                </div>

                <div style=" width:100%; height: 400px; overflow-y:scroll" >
                    <div  style="height:1000px">

                        <table width="80%" cellspacing="0" border="1" style="margin-top:20px; margin-left:100px" id="showAll">
                            <thead align="center">

                            <tr>
                                <th>编号</th>
                                <th>书名</th>
                                <th>作者</th>
                                <th>类型</th>
                                <th>出版社</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>

                            </thead>
                            <tbody>
                            <c:forEach  items="${books}" var="b">
                                <tr align="center">
                                    <td>${b.bno}</td>
                                    <td>${b.bname}</td>
                                    <td>${b.wri}</td>
                                    <td>${b.ssort}</td>
                                    <td>${b.pub}</td>
                                    <td>${b.ing}</td>
                                    <td>
                                        <c:if test="${b.ing<=0}">借阅</c:if>
                                        <c:if test="${b.ing>0}"> <a href="/librarySystem_war/lendServlet?bno=${b.bno}">借阅</a></c:if>

                                        <a href="/librarySystem_war/showDetailServlet?bno=${b.bno}">简介</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        </table>
                    </div>
                </div>


            </div>
        </div>


    </div>

</div>



<div id="fade" class="black_overlay"></div>
<script src="index.js"></script>

</body>
</html>

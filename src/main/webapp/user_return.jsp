<%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/5/30
  Time: 20:51
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


</style>
<body>
<div >

    <div style="background-color: rgb(0,21,41);width: 20%; height: 800px;float:left;">

        <div style="background-color: rgb(0,40,77);">
            <img src="img/touxiang.png" style="width:250px; height: 250px; padding:20px 0px 25px 45px; "/>
        </div>

        <div style="text-align: center; padding:30px 0px 15px 0px; ">
            <a href="user_book.jsp">查询与借阅</a>
        </div>

        <div style="text-align: center; padding:20px 0px 15px 0px; ">
            <a href="user_list.html">借书记录</a>
        </div>

        <div style="text-align: center; padding:20px 0px 15px 0px; ">
            <a href="user_return.html">归还图书</a>
        </div>

        <div style="text-align: center; padding:20px 0px 20px 0px; ">
            <a href="login.html">退出登录</a>
        </div>

    </div>

    <div style="width:80%; height: 800px; float:left;">
        <div style="height: 70px; color: rgb(109,109,109); font-size: 18px; line-height: 70px; font-weight: bold; padding-left: 20px;">
            >&nbsp;&nbsp;归还图书
        </div>

        <div style="background-color: rgb(240,242,245);height: 730px;padding: 20px;">
            <div style="background-color: white;height: 730px;border:none;border-radius: 5px;">

                <div style=" width:100%; height: 400px; overflow-y:scroll">
                    <div  style="height:1000px">

                        <table width="80%" cellspacing="0" border="1" style="margin-top:20px; margin-left:100px" id="showReturn">
                            <thead align="center">

                            <tr>
                                <th>编号</th>
                                <th>书名</th>
                                <th>借书时间</th>
                                <th>应还日期</th>
                                <th>操作</th>
                            </tr>

                            </thead>
                            <tbody>
                            <c:forEach items="records" var="r">
                                <tr>
                                    <th>${r.bno}</th>
                                    <th>${r.bname}</th>
                                    <th>${r.bdate}</th>
                                    <th>${r.ldate}</th>
                                    <th>
                                        <c:if test="${r.ldate==null}" ><a href="/librarySystem_war/returnServlet?bno=${b.bno}">还书</a></c:if>
                                        <c:if test="${r.ldate!=null}" ><a>还书</a></c:if>
                                    </th>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>




                    </div>
                </div>


            </div>
        </div>


    </div>

</div>

</body>
</html>

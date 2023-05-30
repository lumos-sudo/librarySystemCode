<%@ page import="com.library.service.bookService" %><%--
  Created by IntelliJ IDEA.
  User: 李怡嘉
  Date: 2023/5/30
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>借阅书籍</title>
</head>
<body>

<form action="/librarySystem_war/updateServlet" method="get">
    请确认书籍编号是否正确
    书籍编号<input type="text" name="bno"  value="${bno}" >
    <input type="submit" id="btn" value="确认" >
</form>
<script>

</script>
<%--<script src="js/axios-0.18.0.js"></script>
<script>
    document.getElementById("btn").onclick=function (){
        let bno=document.getElementById("Bbno").value;
        console.log(bno);
        axios({
            method:"post",
            url:"http://localhost:8080/librarySystem_war/lendServlet",
            data:{bno:"1"}
        }).then(function (resp) {
            document.getElementById("Bbno").value=123;
            if(resp.data=="success"){
                location.href = "http://localhost:8080/librarySystem_war/user_borrow.html";

            }
        })

    }

</script>--%>
</body>
</html>

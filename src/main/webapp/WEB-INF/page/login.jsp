<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yanya
  Date: 2018/7/12
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/plugins/bootstrap/css/bootstrap.min.css" />
    <script src="<%= request.getContextPath()%>/resources/plugins/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    <style>
        .page-content {
            width: 1200px;
            margin: 0 auto;
            padding-top: 100px;
        }
    </style>
</head>
<body>
    <div class="page-content">
        <div class="container-fluid">
            <form:form id="loginForm" action="checklogin" cssClass="form-horizontal" method="post" >
                <div class="form-group">
                    <label class="col-sm-3 col-sm-offset-2 control-label text-right">用户名：</label>
                    <div class="col-xs-3">
                        <input name="username" value="yanyanghong" type="text" id="username" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 col-sm-offset-2 control-label text-right">密码：</label>
                    <div class="col-sm-3">
                        <input name="password" value="123456" type="password" id="password" class="form-control"/>
                    </div>
                </div>
                <div class="row text-center">
                    <div class="btn-group">
                        <button type="button" class="btn btn-primary" id="btnSubmit">提交</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

    <script>
        $("#btnSubmit").on("click", function () {
            var username = $("#username").val();
            var password = $("#password").val();

            if (username && password) {
                $("#loginForm").serialize();
                $("#loginForm").submit();
            }
        });
    </script>

</body>
</html>

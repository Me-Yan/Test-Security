<%--
  Created by IntelliJ IDEA.
  User: yanya
  Date: 2018/7/12
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
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
            <div class="form-group">
                <label class="col-sm-3 col-sm-offset-2 control-label text-right">用户名：</label>
                <div class="col-xs-3">
                    <input type="text" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 col-sm-offset-2 control-label text-right">密码：</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control">
                </div>
            </div>
        </div>
    </div>

</body>
</html>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.SimpleTimeZone" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <%Date now=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String nowTime=simpleDateFormat.format(now);
        out.write(nowTime);
    %>
    <title>用户列表</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float:left;">
        <form class="form-inline">

            <div class="form-group">
                <label for="list_name">姓名</label>
                <input type="text" class="form-control" id="list_name" placeholder="名字">
            </div><div class="form-group">
                <label for="list_address">籍贯</label>
                <input type="text" class="form-control" id="list_address" placeholder="地址">
            </div><div class="form-group">
                <label for="list_email">邮箱</label>
                <input type="text" class="form-control" id="list_email" placeholder="邮箱">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <%--div布局效果明显，使用tr无用--%>
    <div style="float:right;margin:10px">
        <td colspan="8" align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a></td>
        <td colspan="8" align="center"><a class="btn btn-primary" href="add.html">删除选中</a></td>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s">
        <tr>
            <th><input type="checkbox"></th>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>
        </tr>
            <%--<tr>已修改</tr>--%>
        </c:forEach>

    </table>
    <%--分页效果--%>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size:25px;margin-left:5px">
                一共10页，每页2行
            </span>
        </ul>
    </nav>
</div>
</body>
</html>

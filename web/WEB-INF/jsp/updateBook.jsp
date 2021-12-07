<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/4
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <!--标题-->
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">


        <input type="hidden" name="bookID" value="${qBook.bookID}"/>

        <div class="form-group">
            <label for="bookName">书籍名称：</label>
            <input type="text" class="form-control" id="bookName" name="bookName" value="${qBook.bookName}" required>
        </div>

        <div class="form-group">
            <label for="bookCounts">书籍数量：</label>
            <input type="text" class="form-control" id="bookCounts" name="bookCounts" value="${qBook.bookCounts}" required>
        </div>

        <div class="form-group">
            <label for="detail">书籍描述：</label>
            <input type="text" class="form-control" id="detail" name="detail" value="${qBook.detail}" required>
        </div>
        <button type="submit" class="btn btn-default">修改</button>
    </form>
</div>
</body>
</html>


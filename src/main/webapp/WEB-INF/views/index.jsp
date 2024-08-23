<%--
  Created by IntelliJ IDEA.
  User: khuong
  Date: 8/22/2024
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1>Quản lí nhân viên</h1>
<form method="post" action="/addNV">
    <h3>Thêm nhân viên</h3>

    <div class="mb-3">
        <label for="" class="form-label">mã nhân viên</label>
        <input type="text" class="form-control" name="staffCode" >
        <c:if test="${errors.hasFieldErrors('staffCode')}">
            <div>${errors.getFieldError('staffCode').defaultMessage}</div>
        </c:if>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">tên nhân viên </label>
        <input type="text" class="form-control" id="" name="name" >
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email fpt</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="accountFpt" >

    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Email Fe</label>
        <input type="email" class="form-control" id="exampleInputPassword1" name="accountFe" >
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>

</form>
<p>${error.message}</p>
<div>
    <a href="/export" class="btn btn-primary">
        export
    </a>
    <a href="" class="btn btn-primary">
        import
    </a>
</div>
<table class="table">
    <tr>
        <td>stt</td>
        <td>mã nhân viên</td>
        <td>tên nhân viên</td>
        <td>email fpt</td>
        <td>email fe</td>
        <td>trạng thái</td>
        <td>hành động</td>
    </tr>
    <tbody>

        <c:forEach items="${staff}" var="s" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${s.staffCode}</td>
            <td>${s.name}</td>
            <td>${s.accountFpt}</td>
            <td>${s.accountFe}</td>
            <td>
                <c:choose>
                    <c:when test="${s.status == 1}">
                        Hoạt động
                    </c:when>
                    <c:otherwise>
                        Không hoạt động
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="/deleteNV/${s.id}" class="btn btn-warning">Xóa</a>
                <a href="/detail/${s.id}" class="btn btn-danger">Detail</a>
                <br>
                <a href="/qlNV/upTT/${s.id}" class="btn btn-primary">Trạng thái</a>
                <a href="/chuyenNganh/${s.id}" class="btn btn-success">Chuyên ngành</a>
            </td>
        </tr>
        </c:forEach>


    </tbody>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: khuong
  Date: 8/22/2024
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/putNV/${staff1.id}">
    <h3>Thêm nhân viên</h3>
    <div class="mb-3">
        <label for="" class="form-label">mã nhân viên</label>
        <input type="text" class="form-control" name="staffCode" value="${staff1.staffCode}">
        <c:if test="${errors.hasFieldErrors('staffCode')}">
            <div class="text-danger">${errors.getFieldError('staffCode').defaultMessage}</div>
        </c:if>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">tên nhân viên </label>
        <input type="text" class="form-control" id="" name="name" value="${staff1.name}">
        <c:if test="${errors.hasFieldErrors('name')}">
            <div class="text-danger">${errors.getFieldError('name').defaultMessage}</div>
        </c:if>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email fpt</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="accountFpt" value="${staff1.accountFpt}">
        <c:if test="${errors.hasFieldErrors('accountFpt')}">
            <div class="text-danger">${errors.getFieldError('accountFpt').defaultMessage}</div>
        </c:if>
        <c:if test="${not empty duplicateError}">
            <div class="alert alert-danger">
                    ${duplicateError}
            </div>
        </c:if>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Email Fe</label>
        <input type="email" class="form-control" id="exampleInputPassword1" name="accountFe" value="${staff1.accountFe}">
        <c:if test="${errors.hasFieldErrors('accountFe')}">
            <div class="text-danger">${errors.getFieldError('accountFe').defaultMessage}</div>
        </c:if>
    </div>

    <button type="submit" class="btn btn-warning">update</button>

</form>
</body>
</html>

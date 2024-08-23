<%--
  Created by IntelliJ IDEA.
  User: khuong
  Date: 8/22/2024
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="com.example.thi.entity.MajorFacility" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="">

    <h3>Chuyên ngành</h3>
    <div class="mb-3">
        <label class="form-label">Mã nhân viên</label>
        <input type="text" class="form-control" name="staffCode" value="${staff1.staffCode}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">Tên nhân viên</label>
        <input type="text" class="form-control" name="name" value="${staff1.name}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">Email FPT</label>
        <input type="email" class="form-control" name="accountFpt" value="${staff1.accountFpt}" readonly>
    </div>
    <div class="mb-3">
        <label class="form-label">Email Fe</label>
        <input type="email" class="form-control" name="accountFe" value="${staff1.accountFe}" readonly>
    </div>
</form>

<form method="get" action="/chonCoSo/${staff1.id}">
    <div class="mb-3">
        <label for="coSo" class="form-label">Cơ sở</label>
        <select name="coSoId" id="coSo" class="form-select" onchange="this.form.submit()">
            <option value="">Chọn cơ sở</option>
            <c:forEach var="s" items="${listCoSo}">
                <option value="${s.id}"
                        <c:if test="${s.id == coSoId}">selected</c:if>>
                        ${s.name}
                </option>
            </c:forEach>
        </select>
    </div>



</form>

<form method="get" action="/chonBoMon/${staff1.id}/${coSoId}">
    <div class="mb-3">
        <label for="boMon" class="form-label">Bộ môn</label>
        <select name="boMonid" id="boMon" class="form-select" onchange="this.form.submit()">
            <option value="">Chọn bộ môn</option>
            <c:forEach var="t" items="${listBoMon}">
                <c:if test="${t.idFacility.id.equals(coSoId)}">
                    <option value="${t.id}"
                            <c:if test="${t.id.equals(boMonid)}">selected</c:if>>
                            ${t.idDepartment.name}
                    </option>
                </c:if>
            </c:forEach>
        </select>
    </div>
</form>

<%--<%--%>
<%--    System.out.println("hello");--%>
<%--    List<MajorFacility> listchuyenNganh = (List<MajorFacility>) request.getAttribute("listchuyenNganh");--%>
<%--    for (MajorFacility k : listchuyenNganh) {--%>
<%--        out.println("ID: " + k.getId() + ", Tên: " + k.getIdMajor().getName() + "<br>");--%>
<%--    }--%>
<%--%>--%>

<div class="mb-3">
    <label for="chuyenNganh" class="form-label">Chuyên ngành</label>
    <select name="chuyenNganhId" id="chuyenNganh">
        <option value="">Chọn chuyên ngành</option>
    </select>
</div>

<%--<button type="submit" class="btn btn-primary">Thêm</button>--%>
<table class="table">
    <tr>
        <td>stt</td>
        <td>cơ sở</td>
        <td>bộ môn</td>
        <td>Chuyên ngành</td>
        <td>Hành động</td>
    </tr>
    <tbody>

    <c:forEach items="${listNhanVien}" var="s" varStatus="i">
        <c:if test="${s.idStaff.id==id}">
            <tr>
                <td>${i.index +1}</td>
                <td>${s.idMajorFacility.idDepartmentFacility.idFacility.name}</td>
                <td>${s.idMajorFacility.idMajor.name}</td>
                <td>${s.idMajorFacility.idDepartmentFacility.idDepartment.name}</td>
                <td>                    <a href="/xoaChuyenNganh/${s.id}/${id}" class="btn btn-warning">Xóa</a>
                </td>
            </tr>
        </c:if>
    </c:forEach>

    </tbody>

</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: khuong
  Date: 8/22/2024
  Time: 10:12 PM
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
<form action="">

    <h3>Chuyên ngành</h3>
    <div class="mb-3">
        <label class="form-label">Mã nhân viên</label>
        <input type="text" class="form-control" name="staffCode" value="${staff1.staffCode}">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên nhân viên</label>
        <input type="text" class="form-control" name="name" value="${staff1.name}">
    </div>
    <div class="mb-3">
        <label class="form-label">Email FPT</label>
        <input type="email" class="form-control" name="accountFpt" value="${staff1.accountFpt}">
    </div>
    <div class="mb-3">
        <label class="form-label">Email Fe</label>
        <input type="email" class="form-control" name="accountFe" value="${staff1.accountFe}">
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
                <option value="${t.id}"
                        <c:if test="${t.id == boMonid}">selected</c:if>>
                        ${t.idDepartment.name}
                </option>
            </c:forEach>
        </select>
    </div>
</form>


<form method="get" action="/chonChuyenNganh/${staff1.id}/${coSoId}/${boMonid}">
    <div class="mb-3">
        <label for="coSo" class="form-label">Cơ sở</label>
        <select name="chuyenNganhId" id="chuyenNganh" class="form-select" onchange="this.form.submit()">
            <option value="">Chọn chuyên ngành</option>
         <c:forEach var="k" items="${listchuyenNganh}">
             <c:if test="${k.idDepartmentFacility == boMonid}">${k.idMajor.name}</c:if>
         </c:forEach>
        </select>
    </div>

</form>




<button type="submit" class="btn btn-primary">Tìm kiếm</button>
</body>
</html>

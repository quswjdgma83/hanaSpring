<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let html3 = {
        init: function () {
        }
    };
    $(function () {
        html3.init();
    });
</script>
<div class="container">
    <h1>mypage</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>주소지 이름</th>
            <th>상세주소</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${addrs}">
            <tr>
<%--                <td><a href="<c:url value="/cust/detail"/>?id=${c.id}">${c.id}</a></td>--%>
                <td>${c.addrName}</td>
                <td>${c.addrDetail}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>










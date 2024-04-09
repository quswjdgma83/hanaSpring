<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-27
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
  let left = {
    init: function () {
      $('#btn_board_add').click(()=> {
        let login_id = '${sessionScope.id}'
        if (login_id == '' || login_id == null) {
          $('#btn_board_add').removeAttr('href');
          alert('로그인 하셔야 합니다.');
        }else{

        }
      })
    }
  };
  $(function () {
    left.init();
  });
</script>
<ul class="nav nav-pills flex-column">
  <li class="nav-item">
    <a id="btn_board_add" class="nav-link" href="<c:url value="/board/add"/>">Board Add</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/board/get"/>">Board Get</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/board/allpage?pageNo=1"/>">Board Pagination Get</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
</ul>

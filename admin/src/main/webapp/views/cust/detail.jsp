
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    // JSP 태그를 JavaScript로 직접 사용할 수 없기 때문에 서버 측 경로를 변수에 할당
    let updateUrl = '${pageContext.request.contextPath}/cust/update';
    let deleteUrl = '${pageContext.request.contextPath}/cust/delete?id=';

    let detail = {
        init: function(){
            $('#updateBtn').click(function(){
                $('#detail_form').attr({
                    'action': updateUrl,
                    'method': 'POST'
                }).submit();
            });
            $('#deleteBtn').click(function(){
                let c = confirm('삭제하시겠습니까?');
                if(c === true){
                    let id = $('#id').val();
                    // 삭제 요청 전송
                    window.location.href = deleteUrl + id;
                }
            });
        }
    };

    $(function(){
        detail.init();
    });
</script>



<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form id="detail_form">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" readonly value="${cust.id}" class="form-control" id="id" placeholder="Enter id" name="id">

                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password"  value="${cust.pwd}"  class="form-control" id="pwd" placeholder="Enter password" name="pwd">

                    </div>
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" value="${cust.name}"  class="form-control" id="name" placeholder="Enter name" name="name">

                    </div>
                    <button type="button" id="updateBtn" class="btn btn-primary">Update</button>
                    <button type="button" id="deleteBtn" class="btn btn-primary">Delete</button>
                </form>
            </div>
        </div>
    </div>

</div>



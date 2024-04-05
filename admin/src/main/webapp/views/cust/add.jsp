
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let addUrl = '/cust/addimpl';

    let cust_add = {
        init: function(){
            $('#btn_add').click(function(){
                $('#add_form').attr({
                    'action': addUrl,
                    'method': 'POST'
                }).submit();
            });
        }
    };

    $(function(){
        cust_add.init();
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
                <form id="add_form">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">

                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password"  class="form-control" id="pwd" placeholder="Enter password" name="pwd">
                    </div>
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text"  class="form-control" id="name" placeholder="Enter name" name="name">
                    </div>
                    <button type="button" id="btn_add" class="btn btn-primary">Add</button>
                </form>
            </div>
        </div>
    </div>
</div>



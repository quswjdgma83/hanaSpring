
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let board_add = {
        url:'',
        init:function(url){
            this.url = url;
            $('#board_add_form > button').click(()=>{
                // let title = $('#title').val();
                // let content = $('#content').val();
                this.send();
            });
        },
        send:function(){
            $('#board_add_form').attr({
                'method':'post',
                'action':this.url
            });
            $('#board_add_form').submit();
        }
    };
    $(function(){
        board_add.init('<c:url value="/board/addimpl"/>');
    });
</script>
<div class="container">
    <h2>Board Add Page</h2>
    <form id="board_add_form">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" placeholder="Enter Title" name="boardTitle">
        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control" id="content" placeholder="Enter Content" name="boardContent"></textarea>
        </div>
        <input hidden name="custId" value="${sessionScope.id}">
        <button type="button" class="btn btn-primary">REGISTER</button>
    </form>
</div>

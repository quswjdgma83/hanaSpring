<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let addr_add = {
        url:'',
        init:function(url){
            this.url = url;
            $('#register_form > button').click(()=>{
                let name = $('#name').val();
                let detail = $('#detail').val();
                if(name === '' || name == null){
                    alert('주소 별칭을 입력 하세요');
                    $('#name').focus();
                    return;
                }
                if(detail === '' || detail == null){
                    alert('상세주소를 입력 하세요');
                    $('#detail').focus();
                    return;
                }
                this.send();
            });
        },
        send:function(){
            $('#register_form').attr({
                'method':'post',
                'action':this.url
            });
            $('#register_form').submit();
        }
    };
    $(function(){
        addr_add.init('<c:url value="/mypage/addimpl"/>');
    });

</script>
<div class="container">
    <h2>Register Page</h2>
    <form id="register_form">
        <div class="form-group">
            <label for="name">별칭</label>
            <input type="text" class="form-control" id="name" placeholder="Enter Addr Name" name="addrName">
        </div>
        <div class="form-group">
            <label for="detail">배송지주소:</label>
            <input type="text" class="form-control" id="detail" placeholder="Enter Your detail Address" name="addrDetail">
        </div>
        <button type="button" class="btn btn-primary">REGISTER</button>
    </form>
</div>
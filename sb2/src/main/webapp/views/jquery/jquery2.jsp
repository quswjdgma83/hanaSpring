<style>
    .div_bg{
        border: cyan !important;
    }
</style>
<script>
    let jquery2 = {
        init:function(){
            $('#append').click(function(){
                $('#result').append('<h2>Append..</h2>');
            });
            $('#prepend').click(function(){
                $('#result').prepend('<h2>prepend..</h2>');
            });
            $('#after').click(function(){
                $('#result').after('<h2>after..</h2>');
            });
            $('#before').click(function(){
                $('#result').before('<h2>before..</h2>');
            });
            $('#remove').click(function(){
                $('#result').remove();
            });
            $('#empty').click(function(){
                $('#result').empty();
            });
        }
    };
    $(function (){
        jquery2.init();
    })
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
        <h2>jQuery2 Page</h2>
        <button id="append" type="button" class="btn btn-primary">APPEND</button>
        <button id="prepend" type="button" class="btn btn-primary">pretend</button>
        <button id="after" type="button" class="btn btn-primary">after</button>
        <button id="before" type="button" class="btn btn-primary">before</button>
        <button id="remove" type="button" class="btn btn-primary">remove</button>
        <button id="empty" type="button" class="btn btn-primary">empty</button>
    <div id="result" class="container div_bg">
    </div>
</div>

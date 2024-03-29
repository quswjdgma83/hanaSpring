<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script>
    let rank_tb = {
        init:function(){
            setInterval(function (){
                $.ajax({
                    url:'<c:url value="/getrank"/>',
                    success:function(datas){
                        rank_tb.display(datas);
                    },
                    error:function (){}
                });
            },5000);
        },
        display:function(datas){
            let result = '';
            $(datas).each(function(index, data){
                result += '<tr>';
                result += '<td>'+data.rank+'</td>';
                result += '</tr>';
            });
            $('#rank_tb > tbody').html(result);
        }
    };
    $(function(){
        rank_tb.init();
    })
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>AJAX3 Page</h2>
    <h5>실시간 검색 순위</h5>
    <table class="table table-striped" id="rank_tb">
        <thead>
        <tr>
            <th>Rank</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <%-- KAKAO Map API   --%>
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b91233131542ddc771208f56029a6d98"></script>

    <%-- HighChart API   --%>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/highcharts-3d.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
    <%-- Custom API   --%>
    <script src="<c:url value="/js/0327.js" />"></script>

    <%-- Web Socket Lib    --%>
    <script src="<c:url value="/webjars/sockjs-client/sockjs.min.js"/>"></script>
    <script src="<c:url value="/webjars/stomp-websocket/stomp.min.js"/>"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
        #scroll-btn {
            opacity: 0;
            width: 50px;
            height: 50px;
            color: #fff;
            background-color: #ef476f;
            position: fixed;
            bottom: 13%;
            right: 1%;
            border: 2px solid #fff;
            border-radius: 50%;
            font: 2px monospace;
            transition: opacity 2s, transform 2s;
        }
        #scroll-btn.show {
            opacity: 1;
            transition: opacity 5s, transform 5s;
        }
        #scroll-btn2 {
            opacity: 0;
            width: 50px;
            height: 50px;
            color: #fff;
            background-color: #ef476f;
            position: fixed;
            bottom: 5%;
            right: 1%;
            border: 2px solid #fff;
            border-radius: 50%;
            font: bold 10px monospace;
            transition: opacity 2s, transform 2s;
        }
        #scroll-btn:hover {
            width: 60px;
            height: 60px;
            cursor: pointer; /* 마우스 커서가 포인터 형태로 변경되도록 함 */
            transform: scale(1.2); /* 추가적인 시각적 효과를 위해 scale 변환을 사용할 수 있음 */
        }
        #scroll-btn2:hover {
            width: 60px;
            height: 60px;
            cursor: pointer; /* 마우스 커서가 포인터 형태로 변경되도록 함 */
            transform: scale(1.2); /* 추가적인 시각적 효과를 위해 scale 변환을 사용할 수 있음 */
        }
        #scroll-btn2.show {
            opacity: 1;
            transition: opacity 5s, transform 5s;
        }
    </style>
    <script>
        let center_websocket = {
            stompClient:null,
            init:function(){
                let socket = new SockJS('${serverurl}/wsss');
                this.stompClient = Stomp.over(socket);
                this.stompClient.connect({}, function(frame) {
                    console.log("dwadwafbasefhwaeuifbwueyo");
                    console.log('Connected: ' + frame);
                    this.subscribe('/alert', function(msg) {
                        console.log(msg);
                        if (msg != null) {
                            alert("관리자로부터 알림이 왔습니다")
                        }
                        // $("#alert1").prepend(
                        //     "<h4>" + JSON.parse(msg.body).sendid +":"+
                        //     JSON.parse(msg.body).content1
                        //     + "</h4>");
                    });
                });
            }
        }
        let chatbtn = {
            init:function(){
                // const scrollBtn = document.createElement("button");
                // scrollBtn.innerHTML = "chatbot";
                // scrollBtn.setAttribute("id", "scroll-btn");
                // document.body.appendChild(scrollBtn);
                // scrollBtn.classList.add("show");
                // scrollBtn.addEventListener("click", function(){
                //     location.href='/login';
                // });
                const scrollBtn2 = document.createElement("button");
                scrollBtn2.innerHTML = "1:1";
                scrollBtn2.setAttribute("id", "scroll-btn2");
                document.body.appendChild(scrollBtn2);
                scrollBtn2.classList.add("show");
                scrollBtn2.addEventListener("click", function(){
                    location.href='/chat2';
                });
            }
        };
        $(function(){
            center_websocket.init();
            chatbtn.init();
        });
    </script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1><spring:message code="site.title"  arguments="aa,aa"  /></h1>
    <h5><spring:message code="site.phone"/></h5>
    <div id="alert1"></div>
</div>
<c:choose>
    <c:when test="${sessionScope.id == null}">
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/login" />">LOGIN</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/register" />">REGISTER</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ABOUT US</a>
            </li>
        </ul>
    </c:when>
    <c:otherwise>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/mypage/get'/>">${id}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logoutimpl" />">LOGOUT</a>
            </li>
        </ul>

    </c:otherwise>
</c:choose>


<%--Start Nav Bar--%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="<c:url value='/'/>">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/html/"/>">HTML</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/jquery/"/>">jQuery</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/ajax/"/>">Ajax</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/geo/"/>">Geo</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/chart/"/>">Chat</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/chat/"/>">Chart</a>
            </li>
            <c:if test="${id != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/cust/"/>">Cust</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/item/"/>">Item</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
<%--End Nav Bar--%>

<%--Start Center Area--%>
<div class="container-fluid" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">
            <c:choose>
                <c:when test="${left == null}">
                    <jsp:include page="left.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="${left}.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-10">
            <c:choose>
                <c:when test="${center == null}">
                    <jsp:include page="center.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="${center}.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%--End Center Area--%>

<%--Start Bottom Area--%>
<div class="text-center bg-dark" style="margin-bottom:0">
    <p>Footer</p>
</div>
<%--End Bottom Area--%>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<style>
    #geo2 > #map{
        width:500px;
        height: 400px;
        border:2px solid red;
    }
</style>
<script>
    let geo2 = {
        map:null,
        // initialize
        init:function(){
            this.mapdisplay();
            $('#btn_s').click(() => {
                this.go(37.5447611,127.0564625);
                this.getshop('seouldata');
            });
            $('#btn_b').click(() => {
                this.go(35.1290483,129.0446982);
                this.getshop('busandata');
            });
            $('#btn_j').click(() => {
                this.go(33.3846216,126.5534925);
                this.getshop('jejudata');
            });

        },
        // map 객체 생성
        mapdisplay:function(){
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(37.5447611,127.0564625), // 지도의 중심좌표
                    level: 8 // 지도의 확대 레벨
                };
            this.map = new kakao.maps.Map(mapContainer, mapOption);

            var market_position = new kakao.maps.LatLng(37.5447611,127.0564625);
            var marker = new kakao.maps.Marker({
                position: market_position
            });
            marker.setMap(this.map);
        },
        // 이동
        go:function(lat, lng){
            var moveLatLon = new kakao.maps.LatLng(lat, lng);
            this.map.panTo(moveLatLon);
        },
        // 이동 하는 지역의 데이터를 가지고 온다.
        // loc(s, b, j)
        // getgeodata:function(loc){},
        getshop:function(legion){
            $.ajax({
                url: `/geo/${legion}`,
                success:function(datas){
                    console.log("Data received:", datas); // 데이터를 받아온 후의 로그도 출력해볼 수 있습니다.
                    geo2.display(datas);
                }
            });
        },
        display:function(datas){
            var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png';
            $(datas).each(function(index, item){
                // marker 생성
                // window 생성
                // event
                var imageSize = new kakao.maps.Size(30, 30);
                var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

                var marketPosition = new kakao.maps.LatLng(item.lat,item.lng);
                var marker = new kakao.maps.Marker({
                    map: geo2.map,
                    position: marketPosition,
                    title:item.title,
                    image: markerImage
                });
                // infowindow
                var infoContent = '<p>'+item.title+'</p>';
                infoContent += '<img style="width:50px;"  src="<c:url value="/img/'+item.img+'"/>">';

                var infowindow = new kakao.maps.InfoWindow({
                    content : infoContent,
                    position: marketPosition
                });

                kakao.maps.event.addListener(marker, 'mouseover',mouseoverHandler(marker,infowindow));
                kakao.maps.event.addListener(marker, 'mouseout',mouseoutHandler(marker,infowindow));
                kakao.maps.event.addListener(marker, 'click',mouseclickHandler(item.id));

                function mouseoverHandler(marker,infowindow){
                    return function(){
                        infowindow.open(geo2.map, marker);
                    };
                }

                function mouseoutHandler(marker,infowindow){
                    return function(){
                        infowindow.close();
                    };
                }

                function mouseclickHandler(target){
                    return function(){
                        location.href='<c:url value="/geo/shopdetail?shopid='+target+'" />';
                    };
                }
            });
        }
    };
    $(function(){
        geo2.init();
    });
</script>
<div class="container" id="geo2">
    <h2>GEO2 Page</h2>
    <button id="btn_s" type="button" class="btn btn-primary">Seoul</button>
    <button id="btn_b" type="button" class="btn btn-primary">Busan</button>
    <button id="btn_j" type="button" class="btn btn-primary">Jeju</button>

    <div id="map"></div>
</div>

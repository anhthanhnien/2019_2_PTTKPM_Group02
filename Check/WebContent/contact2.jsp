<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="contact.css" rel="stylesheet" type="text/css"/>
</head>
<body id="body">
        <div class="container">
            <div class="section">
                <ol> 
                    <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
                    <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
                    <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
                    <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
                </ol>
                <ul>
                    <li><a href="https://localhost:8443/Check/feedback.jsp"  target="_self">Rate</a></li>
                    <li><a href="https://localhost:8443/Check/contact2.jsp"  target="_self">Contact</a></li>
		            <li><a href="https://localhost:8443/Check/service2.jsp"  target="_self">Service</a></li>
                    <li><a href="https://localhost:8443/Check/food2.jsp"  target="_self">Food</a></li>	
                </ul> 

            </div>
            <div class="section">
                <div id="content">
                    <h1>CONTACT DETAILS  </h1>
                </div>
                <div id="hihi"> 

                    <img  width="500"  height="300" src ="maps.jpg" usemap="#map_url"/>

                    <map name="map_url">
                        <area shape="rect" coords="500,300,0,0" alt="google maps" href="https://www.google.com/maps/place/Nhà+Hàng+Paris+Deli/@21.0235808,105.8543822,17z/data=!3m1!4b1!4m5!3m4!1s0x3135abec71f65141:0xe6be7e1ff038c2a8!8m2!3d21.0235808!4d105.8565709?hl=vi-VN" title="View on google maps" />


                    </map>   <p>Follow us on</p>
                    <img  width="45"  height="45" src ="googlemaps.png" usemap="#map"/>
                    <map name="map">

                        <area shape="rect" coords="45,45,0,0" alt="google maps" href="https://www.google.com/maps/place/Nhà+Hàng+Paris+Deli/@21.0235808,105.8543822,17z/data=!3m1!4b1!4m5!3m4!1s0x3135abec71f65141:0xe6be7e1ff038c2a8!8m2!3d21.0235808!4d105.8565709?hl=vi-VN" title="View on Google Maps"/>
                    </map>
                    <img  width="45"  height="45" src ="facebook.jpg " title="View on Facebook" usemap="#map_name"/>
                    <map name="map_name">
                        <area shape="rect" coords="100,100,0,0" alt="facebook" href="https://www.facebook.com/profile.php?id=100015361149056" />
                        <img  width="45"  height="45" src ="youtube.jpg" title="View on Youtube" usemap="#map_al"/>
                        <map name="map_al">
                            <area shape="rect" coords="100,100,0,0" alt="youtube"
                                  href="https://www.youtube.com/watch?v=JRCZQO2a6ws" />
                            </div>
                            <div id="ok"><p>

                                    Address: 6B Phan Chu Trinh, Trang Tien, Hoan Kiem, Ha Noi<br>

                                    Tel: (+84.28) 88888888<br>

                                    Fax: (+84.28) 99999999<br>

                                    Email: reservation@hotelgroup2.com.vn
                            </div>
                            <div  id="sex">
                                <p>                      ©  anhthanhnien
                                    /
                                    2019_2_PTTKPM_Group02 </p>
                            </div><br><br>


                            </body>
</html>
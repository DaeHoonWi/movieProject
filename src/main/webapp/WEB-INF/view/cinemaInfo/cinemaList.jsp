<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>영화 커뮤니티 게시판</title>
		<script src="js/jquery-latest.min.js"></script>
<!-- 	<script>
    $( document ).ready(function() {
        console.log( "document loaded" );
    });
 
    $( window ).load(function() {
        console.log( "window loaded" );
    });
    </script> -->
	</head>
	<body>
	
		<c:forEach items="${cinemaList}" var="list">
			<br><br><br>
			제목		: <a href="cinemaDetailView.do?cNum=${list.cNum}"><h1> ${list.cTitle} </h1></a> <br>
			영화 번호	: ${list.cNum} <br>
			국가		: ${list.couNum} <br>
			러닝타임	: ${list.cRunningtime} 분 <br>
			줄거리		: ${list.cSummary} <br>
			
			리뷰수		: ${list.cCount} 개<br>
			시청연령제한: ${list.cAge} 세 관람가<br>
			원본파일명	: ${list.cOriginalFileName} <br>
			저장파일명	: ${list.cStoredFileName} <br>
			개봉일		: ${list.cPlaydate} <br>
	
		</c:forEach>
	
		<h2> <a href="cinemaWriteVeiw.do" style="color: red; text-decoration: none;">영화 추가</a> </h2><br> 

	</body>
</html>
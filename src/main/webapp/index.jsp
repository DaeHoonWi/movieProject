<%-- <%@page import="com.edsk.movie.dto.MemberDTO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>영화 커뮤니티 게시판</title>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script></script>
</head>
<body>

<h3> <a href="qnaList.do">QNA게시판</a> </h3><br>
<h3> <a href="reviewList.do">리뷰게시판</a> </h3><br> 
<h3> <a href="cinemaList.do">영화정보:)</a> </h3><br> 

<%-- <% /* 임시 로그인 - 세션  */
MemberDTO login = new MemberDTO();
//회원
/* login.setmId("kay");
login.setmId("kwon");*/
login.setmId("kim");
login.setmAuthority(0);
//관리자
/* login.setmId("admin");
login.setmAuthority(1);  */
session.setAttribute("login", login); 
%> --%>

</body>
</html>
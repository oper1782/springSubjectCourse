<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.formtable {
	width:250px;
	border:1px solid blue;

}
</style>
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="subject" items="${subject}">
		<p>
		<table class=formtable>
			<tr>
				<td>년도
				<td>학기</td>
				<td>이수학점</td>
				<td>상세보기</td>
			</tr>
			<tr>
				<td><c:out value="${subject.year}" /></td>
				<td><c:out value="${subject.semester}" /></td>
				<td><c:out value="${subject.credit}" /></td>
				<td><a href="${pageContext.request.contextPath}/list">링크</a>
				
			</tr>
		</table>
		</p>
	</c:forEach>

</body>
</html>
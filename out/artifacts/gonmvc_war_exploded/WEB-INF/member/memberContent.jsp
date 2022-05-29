<%@ page import="org.gon.model.MemberDAO" %>
<%@ page import="org.gon.model.MemberVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022-05-26
  Time: 오전 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

//    int num = Integer.parseInt(request.getParameter("num"));
//
//    MemberDAO memberDAO = new MemberDAO();
//    MemberVO vo = memberDAO.memberContent(num);

//    MemberVO vo = (MemberVO) request.getAttribute("vo");

%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<form action="${ctx}/memberUpdate.do" method="post">

    <input type="hidden" name="num" value="${vo.num}">

    <table class="table table-bordered">

    <c:if test="${vo != null}">

        <tr>
            <td>num</td>
            <td>${vo.num}</td>
        </tr>
        <tr>
            <td>id</td>
            <td>${vo.id}</td>
        </tr>
        <tr>
            <td>pass</td>
            <td>${vo.pass}</td>
        </tr>
        <tr>
            <td>name</td>
            <td>${vo.name}</td>
        </tr>
        <tr>
            <td>age</td>
            <td><input type="text" name = "age" value="${vo.age}"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name = "email" value="${vo.email}"></td>
        </tr>
        <tr>
            <td>phone</td>
            <td><input type="text" name = "phone" value="${vo.phone}"></td>
        </tr>
    </c:if>
    <c:if test="${vo == null}">
        <tr>
            <td>일치하는 회원 없음</td>
        </tr>
    </c:if>

        <tr>
            <td colspan="2" align="center">
                <input class="btn btn-primary" type="submit" value="수정하기"/>
                <input class="btn btn-warning" type="reset" value="취소"/>
                <input type="button" value="리스트" onclick="location.href='${ctx}/memberList.do'"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

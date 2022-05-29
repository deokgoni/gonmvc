<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.gon.model.MemberDAO" %>
<%@ page import="org.gon.model.MemberVO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022-05-26
  Time: 오전 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1. 클라이언트 요청 받기
    //2. 회원 전체 리스트 가져오기(model 연동)
//    MemberDAO dao = new MemberDAO();
//    ArrayList<MemberVO> list = dao.memberList();

//    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");


%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        function deleteFn(num){
            console.log(num);
            location.href = "${ctx}/memberDelete.do?num="+num;
        }
    </script>
</head>
<body>
    <table class="table table-bordered">
        <tr>
            <td>num</td>
            <td>id</td>
            <td>pass</td>
            <td>name</td>
            <td>age</td>
            <td>email</td>
            <td>phone</td>
            <td>삭제</td>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.num}</td>
                <td><a href="memberContent.do?num=${list.num}">${list.id}</a></td>
                <td>${list.pass}</td>
                <td>${list.name}</td>
                <td>${list.age}</td>
                <td>${list.email}</td>
                <td>${list.phone}</td>
                <td><input type="button" value="삭제" onclick="deleteFn(${list.num})"></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" align="right"><input type="button" value="회원가입" class="btn btn-primary"
                                                 onclick="location.href='${ctx}/memberRegister.do'"></td>
        </tr>
    </table>
</body>
</html>

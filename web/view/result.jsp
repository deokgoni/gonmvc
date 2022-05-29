<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gon.model.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

    MemberVO vo = new MemberVO("bitco",11,"aaa@naver.com");

    ArrayList<MemberVO> list = new ArrayList<>();
    list.add(vo);
    list.add(vo);
    list.add(vo);
    list.add(vo);
    list.add(vo);

    request.setAttribute("list",list);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>아이디</td>
        <td>나이</td>
        <td>이메일</td>
    </tr>
<c:forEach var="vo" items="${list}">
    <tr>
        <td>${vo.name}</td>
        <td>${vo.age}</td>
        <td>${vo.email}</td>
    </tr>
</c:forEach>
<%--    <tr>--%>
<%--        <td>${vo.name}</td>--%>
<%--        <td>${vo.age}</td>--%>
<%--        <td>${vo.email}</td>--%>
<%--    </tr>--%>


</table>

</body>
</html>

<%@ page import="org.gon.model.MemberDAO" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022-05-26
  Time: 오전 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

  int num = Integer.parseInt(request.getParameter("num"));
  System.out.println("num = " + num);
  MemberDAO memberDAO = new MemberDAO();
  int cnt = memberDAO.memberDelete(num);

  if(cnt>0){
    response.sendRedirect("memberList.jsp");
  }else{
    throw new ServletException("not delete");//톰캣에 에러 던지기
  }
%>
<html>
<head>
    <title>memberDelete</title>
</head>
<body>

</body>
</html>

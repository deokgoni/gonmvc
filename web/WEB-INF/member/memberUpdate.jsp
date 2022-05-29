<%@ page import="org.gon.model.MemberVO" %>
<%@ page import="org.gon.model.MemberDAO" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022-05-26
  Time: 오전 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");


    MemberVO vo = new MemberVO();
    vo.setNum(num);
    vo.setAge(age);
    vo.setEmail(email);
    vo.setPhone(phone);

    System.out.println("vo = " + vo);

    MemberDAO dao = new MemberDAO();
    int cnt = dao.memberUpdate(vo);

    if(cnt > 0){
        System.out.println("insert success");
        response.sendRedirect("memberList.jsp");
    }else{
        //예외객체를 만들어서 tomcat(was)에 던지면 에러화면에 not insert가 뜬다
        throw new ServletException("not insert");
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

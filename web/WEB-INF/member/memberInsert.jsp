<%@ page import="org.gon.model.MemberVO" %>
<%@ page import="org.gon.model.MemberDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //파라미터 정보수집
    request.setCharacterEncoding("utf-8");

    //1. parameter 수집하기
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");


    MemberVO memberVO = new MemberVO(id,pass,name,age,email,phone);

    System.out.println("memberVO.toString() = " + memberVO.toString());

    //Model과 연동
    MemberDAO dao = new MemberDAO();
    int cnt = dao.memberInsert(memberVO);
    if(cnt > 0){
        out.println("insert success");
        response.sendRedirect("/member/memberList.jsp");
    }else{
        //예외객체를 만들어서 tomcat(was)에 던지면 에러화면에 not insert가 뜬다
        throw new ServletException("not insert");
    }


%>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

</body>
</html>

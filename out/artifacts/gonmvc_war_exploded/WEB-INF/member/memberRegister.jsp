<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
회원가입화면

<form action="${ctx}/memberInsert.do" method="post">
    <table class="table table-bordered">

        <tr>
            <th class="">아이디</th>
            <th class=""><input type="text" name="id"/></th>
        </tr>

        <tr>
            <td class="">패스워드</td>
            <td class=""><input type="password" name="pass"/></td>
        </tr>
        <tr>
            <td class="">이름</td>
            <td class=""><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td class="">나이</td>
            <td class=""><input type="text" name="age"/></td>
        </tr>
        <tr>
            <td class="">이메일</td>
            <td class=""><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td class="">전화번호</td>
            <td class=""><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="가입" class="btn btn-primary">
                <input type="reset" value="취소" class="btn btn-danger">
            </td>
        </tr>

    </table>
</form>
</body>
</html>

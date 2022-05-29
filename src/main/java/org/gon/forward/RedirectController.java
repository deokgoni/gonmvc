package org.gon.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. forward 실습
//        int su = 100;
        String data = "apple";
        String name = "park";
        int age = 44;
        String email = "aaa@naver.com";
        // result.jsp로 data 전달

        //controller -> view 전환방법
        //1. redirect
        //2. forward 앞으로
        request.setAttribute("data",data);

        //redirect 기법인데..; data는 어떻게???
        //redirect요청시 위에서 request에 저장된 객체랑 다른 객체가 생성된다...
        response.sendRedirect("view/result.jsp?data="+data+"&name="+name+"&age="+age);


    }
}

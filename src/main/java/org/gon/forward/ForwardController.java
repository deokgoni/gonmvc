package org.gon.forward;

import org.gon.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. forward 실습
        String name = "park";
        int age = 44;
        String email = "aaa@naver.com";

        //forward.jsp
        MemberVO vo = new MemberVO(name, age, email);

        //2. 객체 연결
        request.setAttribute("vo",vo);

        //3. forward
        RequestDispatcher rd = request.getRequestDispatcher("view/forward.jsp");
        rd.forward(request,response);

    }
}

package org.gon.controller;

import org.gon.model.MemberDAO;
import org.gon.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/memberUpdate.do")
public class MemberUpdateController implements Controller {
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String ctx = request.getContextPath();
        //파리미터 수집(VO)
        int num = Integer.parseInt(request.getParameter("num"));
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setNum(num);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberUpdate(vo);

        String nextPage = null;
        if(cnt > 0){
            nextPage = "redirect:/"+ctx+"memberList.do";
        }else{
            //예외객체를 만들어서 tomcat(was)에 던지면 에러화면에 not insert가 뜬다
            throw new ServletException("not insert");
        }
        return nextPage;
    }



/*    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //파리미터 수집(VO)
        int num = Integer.parseInt(request.getParameter("num"));
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setNum(num);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberUpdate(vo);

        if(cnt > 0){
            System.out.println("insert success");
            response.sendRedirect("/memberList.do");
        }else{
            //예외객체를 만들어서 tomcat(was)에 던지면 에러화면에 not insert가 뜬다
            throw new ServletException("not insert");
        }

    }*/
}

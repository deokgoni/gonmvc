package org.gon.controller;

import org.gon.model.MemberDAO;
import org.gon.model.MemberVO;
import org.gon.model.MyCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/memberInsert.do")
public class MemberInsertController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //utf-8 -> 문자하나를 2byte로 처리할 수 있도록 해줌.
        request.setCharacterEncoding("utf-8");
        String ctx = request.getContextPath();
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
        String nextPage = null;
        if(cnt > 0){
            nextPage = "redirect:/"+ctx+"memberList.do";
        }else{
            //예외객체를 만들어서 tomcat(was)에 던지면 에러화면에 not insert가 뜬다
            throw new ServletException("not insert");
        }

        return nextPage;
    }



    /*@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //utf-8 -> 문자하나를 2byte로 처리할 수 있도록 해줌.
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
        PrintWriter out = response.getWriter();
        int cnt = dao.memberInsert(memberVO);
        if(cnt > 0){
            out.println("insert success");
            response.sendRedirect("/memberList.do");
        }else{
            //예외객체를 만들어서 tomcat(was)에 던지면 에러화면에 not insert가 뜬다
            throw new ServletException("not insert");
        }

    }*/
}

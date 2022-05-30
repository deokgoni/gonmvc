package org.gon.controller;

import org.gon.model.MemberDAO;
import org.gon.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/memberContent.do")
public class MemberContentController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));

        MemberDAO memberDAO = new MemberDAO();
        MemberVO vo = memberDAO.memberContent(num);
        request.setAttribute("vo",vo);

        return "memberContent"; //뷰의 이름만 리턴..
//        return "/WEB-INF/member/memberContent.jsp";
    }


/*
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));

        MemberDAO memberDAO = new MemberDAO();
        MemberVO vo = memberDAO.memberContent(num);

        request.setAttribute("vo",vo);
        RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
        rd.forward(request,response);
    }*/
}

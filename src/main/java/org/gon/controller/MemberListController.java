package org.gon.controller;

import org.gon.model.MemberDAO;
import org.gon.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/memberList.do")
public class MemberListController implements Controller {
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 클라이언트 요청 받기
        //2. 회원 전체 리스트 가져오기(model 연동)
        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.memberList();
        request.setAttribute("list",list);

        //3. 다음페이지
        return "memberList";
//        return "/WEB-INF/?member/memberList.jsp";
    }





/*    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 클라이언트 요청 받기
        //2. 회원 전체 리스트 가져오기(model 연동)
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.memberList();

        request.setAttribute("list",list);
        //3. forward
        RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
        rd.forward(request,response);

    }*/
}

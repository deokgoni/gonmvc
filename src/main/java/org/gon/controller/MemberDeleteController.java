package org.gon.controller;

import org.gon.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/memberDelete.do")
public class MemberDeleteController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ctx = request.getContextPath();
        int num = Integer.parseInt(request.getParameter("num"));

        MemberDAO memberDAO = new MemberDAO();
        int cnt = memberDAO.memberDelete(num);

        String nextPage = null;
        if(cnt>0){
            nextPage ="redirect:"+ctx+"/memberList.do";
        }else{
            throw new ServletException("not insert");//톰캣에 에러 던지기
        }
        return nextPage;
    }



    /*@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("num"));

        MemberDAO memberDAO = new MemberDAO();
        int cnt = memberDAO.memberDelete(num);

        if(cnt>0){
            response.sendRedirect("/memberList.do");
        }else{
            throw new ServletException("not insert");//톰캣에 에러 던지기
        }
    }*/
}

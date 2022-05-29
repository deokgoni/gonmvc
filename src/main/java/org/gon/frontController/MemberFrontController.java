package org.gon.frontController;

import org.gon.controller.*;
import org.gon.model.MemberDAO;
import org.gon.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //클라이언트가 어떤 요청 파악
        String url = request.getRequestURI();
        System.out.println("url = " + url);
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        //실제요청명령
        String command = url.substring(contextPath.length());
        System.out.println("command = " + command);


        Controller controller = null;
        String nextPage = null;
        //요청에 따른 분기작업
        HandlerMapping mapping = new HandlerMapping();
        controller = mapping.getController(command);
        nextPage = controller.requestHandler(request, response);

        //forward, redirect
        if(nextPage.indexOf("redirect:") != -1){
            response.sendRedirect(nextPage.split(":")[1]);
        }else{
            System.out.println("frontController. nextPage = " + nextPage);
            RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
            rd.forward(request, response);
        }

    }
}

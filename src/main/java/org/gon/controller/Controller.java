package org.gon.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    //모든 POJO가 있어야 하는 메서드
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

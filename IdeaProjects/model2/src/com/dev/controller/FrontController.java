package com.dev.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String charset = null;
    HashMap<String,Controller> list = null;

    @Override
    public void init(ServletConfig config) throws ServletException { //init() 메소드는 현재 서블릿 객체가 최초로 요청이 들어왔을 때 한번만 실행되는 메소드로서 서블릿으로서 초기화 기능을 담당합니다.
        charset = config.getInitParameter("charset"); //web.xml의 <servlet> 태그의 정보 중<init-param>의 <param-name>이 charset인 태그의 <param-value>을 추출한다.
        list = new HashMap<String, Controller>();
        list.put("/memberInsert.do",new MemberInsertController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //클라이언트로부터 요청이 들어올 때마다 실행하는 메소드입니다.
        req.setCharacterEncoding(charset); //POST방식으로 전달된 질의 문자열을 인코딩 처리하는 메소드입니다. charset변수에는 web.xml파일에 <init-param>에 지정한 값이 저장되어 있다.
        /*
         * 클라이언트의 요청 URL에서 key를 추출하는 코드입니다. 예)http://localhost:9090/dev/memberInsert.do
         */
        String url = req.getRequestURI(); //  /dev/memberInsert.do
        String contextPath = req.getContextPath(); // /dev
        String path = url.substring(contextPath.length()); // contextPath.length(): 4 , path = /memberInsert.do
        Controller subController  = list.get(path); // 따라서 list.get(path)에서 반환되는 객체는 MemberInsertController입니다.
        subController.execute(req,resp);
    }
}

package com.dev.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpUtil {
    public static void forward(HttpServletRequest req, HttpServletResponse resp,String path){
        RequestDispatcher dispatcher = req.getRequestDispatcher(path);// 이동할 페이지에 대한 URI정보는 path변수에 저장되어있습니다. path에 지정된 페이지의 경로를 가지는 RequestDispatcher객체를 생성합니다
        try {
            dispatcher.forward(req,resp);
        } catch (Exception e) {
            System.out.println("forward 오류 : " +e);
        }
    }
}

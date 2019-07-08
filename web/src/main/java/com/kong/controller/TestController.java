package com.kong.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("testController")
public class TestController {
    // /test/show.do  /show.jsp
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("NAME","张三");
        request.getRequestDispatcher("../show.jsp").forward(request, response);

    }
}

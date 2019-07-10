package com.kong.controller;

import com.kong.entity.Staff;
import com.kong.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> staffList=staffService.getAll();
        request.setAttribute("staffList",staffList);
        request.getRequestDispatcher("../staff_list.jsp").forward(request,response);
    }

    //打开添加页面
    public void toadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../staff_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Staff staff = new Staff();
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        staff.setInfo(info);
        staff.setBornDate(bornDate);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }



}

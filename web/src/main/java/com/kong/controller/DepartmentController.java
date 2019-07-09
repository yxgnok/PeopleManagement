package com.kong.controller;

import com.kong.entity.Department;
import com.kong.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("depList", list);
        request.getRequestDispatcher("../department_list.jsp").forward(request, response);
    }

    public void toadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../department_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        Department department = new Department();
        department.setName(name);
        department.setAddress(address);

        departmentService.add(department);

        response.sendRedirect("list.do");

    }
}

package com.example.servlet.project.servlet;

import com.example.servlet.project.dto.CategoryDto;
import com.example.servlet.project.service.CategoryService;
import com.example.servlet.project.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private final CategoryService categoryService = CategoryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryDto> categoryDtoList = categoryService.findAll();
        req.setAttribute("categories", categoryDtoList);
        req.getRequestDispatcher(JspHelper.getPath("category")).forward(req, resp);
    }
}

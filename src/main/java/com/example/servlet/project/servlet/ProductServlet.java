package com.example.servlet.project.servlet;

import com.example.servlet.project.dto.ProductDto;
import com.example.servlet.project.service.ProductService;
import com.example.servlet.project.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = Integer.valueOf(req.getParameter("categoryId"));
        List<ProductDto> productDtoList = productService.findByCategoryId(categoryId);
        req.setAttribute("products", productDtoList);
        req.getRequestDispatcher(JspHelper.getPath("product")).forward(req, resp);

    }
}

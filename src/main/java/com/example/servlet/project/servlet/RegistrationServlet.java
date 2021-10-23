package com.example.servlet.project.servlet;

import com.example.servlet.project.dto.CreateUserDto;
import com.example.servlet.project.entity.Gender;
import com.example.servlet.project.exception.ValidationException;
import com.example.servlet.project.service.UserService;
import com.example.servlet.project.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("gender", Gender.values());
        req.getRequestDispatcher(JspHelper.getPath("registration")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserDto clientDto = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .phone(req.getParameter("phone"))
                .email(req.getParameter("email"))
                .birthday(req.getParameter("birthday"))
                .password(req.getParameter("password"))
                .gender(req.getParameter("gender"))
                .image(req.getPart("image"))
                .build();
        try {
            userService.create(clientDto);
            resp.sendRedirect(JspHelper.getPath("login"));
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrorList());
            doGet(req, resp);
        }
    }
}

package com.example.servlet.project.servlet;

import com.example.servlet.project.dto.UserDto;
import com.example.servlet.project.service.UserService;
import com.example.servlet.project.util.JspHelper;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userService.login(email, password).ifPresentOrElse(
                userDto -> onLoginSuccess(req, resp, userDto),
                () -> onLoginFail(req, resp)

        );
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(HttpServletRequest req, HttpServletResponse resp, UserDto userDto) {
        req.getSession().setAttribute("user", userDto);
        resp.sendRedirect("/category");
    }
}

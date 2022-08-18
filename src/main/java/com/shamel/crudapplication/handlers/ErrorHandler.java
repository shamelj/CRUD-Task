package com.shamel.crudapplication.handlers;

import jakarta.servlet.http.HttpServletRequest;

public class ErrorHandler implements RouteHandler {
    @Override
    public String execute(HttpServletRequest request) {
        return "/invalid-url.jsp";
    }
}

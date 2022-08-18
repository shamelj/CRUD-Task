package com.shamel.crudapplication.handlers;

import jakarta.servlet.http.HttpServletRequest;

public interface RouteHandler {

    String execute(HttpServletRequest request);
}

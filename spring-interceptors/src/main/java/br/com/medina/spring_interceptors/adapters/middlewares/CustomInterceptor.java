package br.com.medina.spring_interceptors.adapters.middlewares;

import java.io.IOException;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        System.out.println("Request Intercepted by my Interceptor");

        // String someHeader = request.getHeader("Some-Header");
        // if (someHeader == null || !someHeader.equals("expectedValue")) {
        // response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        // response.getWriter().write("Missing or invalid Some-Header");
        // return false;
        // }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // logica após o controlador, mas antes da resposta chegar ao cliente
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // Lógica após a resposta ser completamente renderizada
    }
}

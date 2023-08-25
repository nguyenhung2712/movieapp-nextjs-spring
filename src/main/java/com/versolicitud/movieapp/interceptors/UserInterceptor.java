package com.versolicitud.movieapp.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
    		throws Exception {
        // Xử lý trước khi điều hướng tới API
        return true; // Cho phép tiếp tục điều hướng tới API hoặc false để chặn yêu cầu
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
    		ModelAndView modelAndView) throws Exception {
        // Xử lý sau khi API thực thi, trước khi trả về kết quả cho client
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
    		Exception ex) throws Exception {
        // Xử lý sau khi kết thúc yêu cầu API, dù có lỗi hay không
    }
    
    
}

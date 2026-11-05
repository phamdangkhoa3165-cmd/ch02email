package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

// Thẻ này dặn Tomcat: Đánh chặn TẤT CẢ các đường dẫn URL (/*) trước khi đến được Servlet
@WebFilter("/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 1. Ép kiểu mã hóa dữ liệu đầu vào và đầu ra thành UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 2. Cho phép Request đi tiếp tới Servlet mục tiêu
        chain.doFilter(request, response);
    }
}
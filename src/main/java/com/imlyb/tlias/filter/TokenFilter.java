package com.imlyb.tlias.filter;

import com.imlyb.tlias.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取url
        String requestURI = request.getRequestURI();
        //2.判断为登录操作时，直接放行
        if (requestURI.contains("/login")) {
            log.info("登录操作，直接放行");
            filterChain.doFilter(request,response);
            return;
        }
        //3.获取请求头中的token
        String token = request.getHeader("token");
        //4.判断token是否存在 否则说明没有登录，只会错误码401
        if (token==null || token.isEmpty()) {
            log.info("用户未登录，请先登录");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //5.如果token存在 校验令牌 如果检验失败返回错误码401
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
           log.info("token无效");
           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return;
        }
        //6.校验通过，放行
        filterChain.doFilter(request,response);
    }
}

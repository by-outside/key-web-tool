package com.zy.keywebtool.myfilter;

import com.zy.keywebtool.config.StatusConfigUtil;
import com.zy.keywebtool.util.Util;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;
import sun.dc.pr.PRError;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Order(1)
@WebFilter(urlPatterns = "/*")
@Component
public class BaseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = servletRequest.getParameter("token");
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        HttpSession session = servletRequest1.getSession();
        if (!StringUtils.isEmpty(token) && !token.equals("undefined")){
            session.setAttribute("token",token);
        }
        if (Util.isLocal(servletRequest)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            if(StatusConfigUtil.WEB_TOKEN.equals(session.getAttribute("token"))){
                filterChain.doFilter(servletRequest, servletResponse);
                System.out.println(session.getAttribute("token"));
            }else {
                servletResponse.getOutputStream().print("error");
                servletResponse.getOutputStream().flush();
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}

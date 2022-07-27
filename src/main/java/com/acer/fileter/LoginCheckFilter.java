package com.acer.fileter;


import com.acer.common.R;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acer
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    /**
     * 全局请求统一拦截
     * @author acer
     * @date 11:16 2022/7/27
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
    **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将ServletRequest和ServletResponse向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1.获取请求地址URl
        String requestURI
                = request.getRequestURI();
        log.info("获取请求地址URL：{}",requestURI);

        // 2.规定要放过的请求地址：登录、退出、两个静态资源
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };

        // 3.用AntPathMatcher工具（Spring框架中的），判断请求的地址是否在urls中存在
        if (check(urls, requestURI)) {
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        // 4.已登录，直接放行
        if (request.getSession().getAttribute("employee") != null){
            System.out.println(request.getSession().getAttribute("employee"));
            log.info("用户已登录，不需要拦截,用户id为：[]",request.getSession().getAttribute("employee"));
            filterChain.doFilter(request,response);
            return;
        }

        // 5.未登录，返回登录界面：request.js中
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    /**
     * 判断Url地址是否在定义的urls数组中
     * @author acer
     * @date 11:34 2022/7/27
     * @param urls
     * @param requestURI
     * @return boolean
    **/
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            //match第一个参数为：规则参数  第二个为：在这个字符串中查找
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }






























}

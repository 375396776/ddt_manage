package com.ddt.manage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ddt.manage.po.User;

/**
 * 
 * @Title: SessionFilter
 * @Description: Servlet Filter implementation class SessionFilter
 * @Company: 
 * @author 李斌
 * @date 2018年6月8日 下午3:08:11 
 * @version 1.0
 */
@WebFilter("/SessionFilter")
public class SessionFilter extends OncePerRequestFilter implements Filter {
       
	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //不过滤的uri
        String[] notFilter = new String[]{"/login","/logout"};

        //请求的uri
        String uri = request.getRequestURI();
        System.out.println("filter>>>uri>>>"+uri);

        //是否过滤
        boolean doFilter = true;
        for(String s : notFilter){
            if(uri.indexOf(s) != -1){
                //uri中包含不过滤uri，则不进行过滤
                doFilter = false;
                break;
            }
        }

        if(doFilter){
            System.out.println("doFilter>>>");
            //过滤操作
            //从session中获取登陆者实体
            Object obj = request.getSession().getAttribute("user");
            if(obj==null){
                System.out.println("doFilter>>>obj is null");
                boolean isAjaxRequest = isAjaxRequest(request);
                if(isAjaxRequest){
                    response.setCharacterEncoding("UTF-8");
                    response.sendError(HttpStatus.UNAUTHORIZED.value(),"您已经太长时间没有操作,请刷新页面");

                    System.out.println("doFilter>>>ajax request");

                    return ;
                }else{
                    System.out.println("doFilter>>>http request");
                    response.sendRedirect("/ddt_manage/login.do");
                    //跳转到登录页面
                    return ;
                }
            }else{
                User user = (User) obj;
                System.out.println("doFilter>>>username>>"+user.getUsername());
                  // 如果session中存在登录者实体，则继续  
                filterChain.doFilter(request, response);
            }
        }else{
            System.out.println("no Filter>>>");
            //不执行过滤操作
            filterChain.doFilter(request, response);
        }
    }
    /**
     * is Ajax request
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if(header != null && "XMLHttpRequest".equals(header)){
            //ajax request
            return true;
        }else{
            //traditional sync http request
            return false;
        }
    }

}

package com.company.assaka.interceptor;
import com.company.assaka.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String token = (String) request.getAttribute("token");

        try{
            //解析 Token，拿到里面的角色信息
            String role = JwtUtil.getUserType(token);
            //获取当前请求的接口路径
            String uri = request.getRequestURI();

            //权限判断逻辑
            if(!"admin".equals(role)){
                response.setStatus(403);
                response.getWriter().write("{\"code\":403, \"message\":\"权限不足，请先登录管理员账号\"}");
                return false;
            }

            // 放行（只要 Token 没过期，且角色匹配，就放行）
            // 这里还可以把 role 存入 request 域，供后续 Controller 使用
            request.setAttribute("userRole", role);
            return true;
        }catch (Exception e){
            // Token 过期或伪造，解析失败
            response.setStatus(401);
            response.getWriter().write("{\"code\":401, \"message\":\"Token已过期，请刷新页面\"}");
            return false;
        }
    }
}

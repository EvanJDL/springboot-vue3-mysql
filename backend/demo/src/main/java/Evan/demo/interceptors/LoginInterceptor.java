package Evan.demo.interceptors;

import Evan.demo.utils.Claims;
import Evan.demo.utils.JwtUtil;
import Evan.demo.utils.UserHolder;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        try {
            Claims claims = JwtUtil.parseToken(token);
            // ✅ 设置 userId 和 username 到 ThreadLocal 中
            UserHolder.setUserId(claims.getId());
            UserHolder.setUsername(claims.getUsername());
            return true;
        } catch (JWTVerificationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // ✅ 清除 ThreadLocal 中的信息，防止内存泄漏
        UserHolder.clear();
    }
}

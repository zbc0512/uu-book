package io.zbc.uu.book.controller.security;

import com.alibaba.fastjson.JSONObject;
import io.zbc.uu.book.entity.Result;
import io.zbc.uu.book.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Component
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置
        addInterceptor.excludePathPatterns("/")
                .excludePathPatterns("/eureka-ui")
                .excludePathPatterns("/index")
                .excludePathPatterns("/login")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/signOut")
                .excludePathPatterns("/user/getUserFromSession")
                .excludePathPatterns("/system/getAuthorization")
                .excludePathPatterns("/system/getInstallationEnvironment")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/data/**")
                .excludePathPatterns("/logo.ico");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/eureka/**").addResourceLocations("classpath:/static/eureka/");
    }

    public class SecurityInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                try {
                    PrintWriter out = response.getWriter();
                    response.sendError(401, "Unauthorized");
                    out.append(JSONObject.toJSON(Result.notLoginResult()).toString());
                } catch (Exception ignore) {
                }
                return false;
            }
            return true;
        }
    }
}

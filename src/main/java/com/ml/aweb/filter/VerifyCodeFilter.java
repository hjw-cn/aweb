package com.ml.aweb.filter;

import com.ml.aweb.exception.VerifyCodeException;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author hanjiawei
 * @date 2020-09-25
 */

@Component
public class VerifyCodeFilter extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getRequestURI().equals("/login") && request.getMethod().equalsIgnoreCase("post")){
            try {
                validate(request.getSession(),request);
            } catch (VerifyCodeException e) {
                e.printStackTrace();
            }
        }

        filterChain.doFilter(request,response);
    }

    // 验证保存在session中的验证吗是否与表单中的验证吗一致
    private void validate(HttpSession session,HttpServletRequest request) throws ServletRequestBindingException, VerifyCodeException {
        String captcha = ServletRequestUtils.getStringParameter(request, "captcha");
        String code = (String) session.getAttribute(request.getParameter("uuid"));
        logger.info("用户输入的验证码" + captcha);
        logger.info("session中存储的验证码" + code);
        if (!code.equalsIgnoreCase(captcha)){
            throw new VerifyCodeException("验证码不正确");
        }
        session.removeAttribute(request.getParameter("uuid"));
    }
}

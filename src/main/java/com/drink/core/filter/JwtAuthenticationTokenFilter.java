package com.drink.core.filter;

import com.drink.common.ResultCode;
import com.drink.common.ResultJson;
import io.jsonwebtoken.Claims;
import com.drink.entity.UserDetail;
import com.drink.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * token校验
 * @author: JoeTao
 * createAt: 2018/9/14
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String token_header;

    @Resource
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String auth_token = request.getHeader(this.token_header);
        final String auth_token_start = "Bearer ";
        if (StringUtils.isNotEmpty(auth_token) && auth_token.startsWith(auth_token_start)) {
            auth_token = auth_token.substring(auth_token_start.length());
        } else {
            // 不按规范,不允许通过验证
            auth_token = null;
        }

        if (auth_token == null) {
            chain.doFilter(request, response);
            return;
        }

        Claims claims = jwtUtils.getClaimsFromToken(auth_token);
        if (null == claims) { // Token不可解码
            this.resp(response, ResultCode.UNAUTHORIZED, "Can't parse token");
            return;
        }
        if (!jwtUtils.isTokenExpired(auth_token)) {
            //验证为未登陆状态会进入此方法，认证错误
            this.resp(response, ResultCode.UNAUTHORIZED, "Token expired");
            return;
        }

        String username = jwtUtils.getUsernameFromToken(auth_token);

        logger.info(String.format("Checking authentication for userDetail %s.", username));
        if (StringUtils.isEmpty(username)) {
            //验证为未登陆状态会进入此方法，认证错误
            this.resp(response, ResultCode.UNAUTHORIZED, "Invalid token");
            return;
        }

        if (jwtUtils.containToken(username, auth_token) && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetail userDetail = jwtUtils.getUserFromToken(auth_token);
            if (jwtUtils.validateToken(auth_token, userDetail)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info(String.format("Authenticated userDetail %s, setting security context", username));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }

    public void resp(HttpServletResponse response, ResultCode code, String msg) throws IOException {
        response.setStatus(code.getCode());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        String body = ResultJson.failure(code, msg).toString();
        printWriter.write(body);
        printWriter.flush();
    }

}

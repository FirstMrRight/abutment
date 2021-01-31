package com.common.securityconfig;

import com.common.resp.ResultMessage;
import com.common.securityconfig.config.SelfUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录成功处理类
 * @Author Sans
 * @CreateTime 2019/10/3 9:13
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * 登录成功返回结果
     *
     * @Author Sans
     * @CreateTime 2019/10/3 9:27
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 组装JWT
        SelfUserEntity selfUserEntity = (SelfUserEntity) authentication.getPrincipal();
        String token = JwtTokenUtil.createAccessToken(selfUserEntity);
        token = JwtConfig.tokenPrefix + token;
        // 封装返回参数
        Map<String, Object> resultData = new HashMap<>(3);
        resultData.put("code", "200");
        resultData.put("msg", "登录成功");
        resultData.put("token", token);
        ResultMessage.success(resultData);
    }
}
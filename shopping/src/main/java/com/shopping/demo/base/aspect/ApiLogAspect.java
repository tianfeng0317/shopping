package com.shopping.demo.base.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shopping.demo.result.ResultData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

/**
 * @Author :tianfeng
 * @Date : 2020/12/3 10:27
 * @Description: 请求日志切面
 */
@Aspect
@Component
public class ApiLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.shopping.demo.api.*Api.*(..))")
    public void apiLog() {
    }

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    ThreadLocal<String> requstId = new ThreadLocal<String>();

    @Before("apiLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Long currentTimeMillis = System.currentTimeMillis();
        startTime.set(currentTimeMillis);
        requstId.set(UUID.randomUUID().toString().replace("-", ""));
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String id = "[" + requstId.get() + "]";
        String url = "REQUEST: " + request.getRequestURL().toString();
        String inputArgs = "  INPUTARGS: " + JSON.toJSONString(request.getParameterMap());
        String acceptArgs = "  ACCEPTARGS: " + Arrays.toString(joinPoint.getArgs());
        String ip = "  IP: " + request.getRemoteAddr();
        // String invoke = "CLASS_METHOD : " +
        // joinPoint.getSignature().getDeclaringTypeName() + "." +
        // joinPoint.getSignature().getName();
        logger.info(id + url + inputArgs + acceptArgs + ip);
    }

    @AfterReturning(pointcut = "apiLog()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        String id = "[" + requstId.get() + "]";
        String apiName = joinPoint.getSignature().getName();
        String s = "RESPONSE: " + apiName;
        String result = "";
        if (ret instanceof ResultData && !apiName.equals("queryOrderBase")) {
            result = " RESULT: " + ((ResultData<?>)ret).toResult();
        } else {
            result = " RESULT: " + JSONObject.toJSONString(ret);
        }
        String time = " TIME: " + (System.currentTimeMillis() - startTime.get());
        logger.info(id + s + result + time);
    }

}

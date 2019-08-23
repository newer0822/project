package com.erp.config;






import com.erp.domain.RequestMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

@Aspect
@Component
@Order(3)
public class LoggerAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Autowired
    private LoggerRepository loggerRepository;

    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.newer.*.controller.*.*(..))")
    public void weblog(){
    }

    @Before(value = "weblog()")
    public void doBefore(JoinPoint joinPoint){
      //获取HttpServletRequest的请求对象
      RequestAttributes ra =  RequestContextHolder.getRequestAttributes();
      ServletRequestAttributes sra = (ServletRequestAttributes)ra;
      HttpServletRequest request = sra.getRequest();

      String id =   UUID.randomUUID().toString();
      String url = request.getRequestURL().toString();
      String methodName = joinPoint.getSignature().getDeclaringTypeName()
              +"."+joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      String method = request.getMethod();

      RequestMessage rm = new RequestMessage(id,url,methodName,args,method);
      logger.info("开始向mongodb中存储数据,id:" + id);
      loggerRepository.save(rm); //讲requestMessage保存mongodb中
      logger.info("mongodb数据存储完毕");
    }

}

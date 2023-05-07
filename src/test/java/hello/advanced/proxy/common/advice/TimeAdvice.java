package hello.advanced.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    log.info("TimeProxy 실행");
    long startTime = System.currentTimeMillis();

//    Object result = method.invoke(target, args); // MethodInterceptor에서는 Target지정 필요없음
//    invocation.getMethod();
    Object result = invocation.proceed();

    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("TimeProxy 종료 resultTime={}", resultTime);

    return result;
  }
}

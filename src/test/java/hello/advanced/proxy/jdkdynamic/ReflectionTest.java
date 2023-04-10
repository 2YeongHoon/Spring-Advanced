package hello.advanced.proxy.jdkdynamic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionTest {

  @Test
  void reflection0(){
    Hello target = new Hello();
    target.callA();
    target.callB();
  }

  @Test
  void reflection1() throws ClassNotFoundException {
    // 클래스 정보
    Class classHello = Class.forName("hello.advanced.proxy.jdkdynamic.ReflectionTest.Hello");

    Hello target = new Hello();
  }

  @Test
  void reflection2() throws Exception {
    // 클래스 정보
    Class classHello = Class.forName("hello.advanced.proxy.jdkdynamic.ReflectionTest$Hello");

    Hello target = new Hello();
    Method methodCallA = classHello.getMethod("callA");
    dynamicCall(methodCallA, target);

    Method methodCallB = classHello.getMethod("callB");
    dynamicCall(methodCallB, target);
  }

  private void dynamicCall(Method method, Object target)
      throws Exception {
    log.info("start");
    Object result = method.invoke(target);
    log.info("result = {}", result);
  }

  static class Hello{
    public String callA(){
      log.info("callA");
      return "A";
    }

    public String callB(){
      log.info("callB");
      return "B";
    }
  }
}

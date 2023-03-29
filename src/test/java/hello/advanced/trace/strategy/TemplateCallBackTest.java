package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.CallBack;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallBackTest {

  /**
   * 템플릿 콜백 패턴 - 익명내부클래스
   */
  @Test
  void callBackV1(){
    CallBack callBack1 = new CallBack() {
      @Override
      public void call() {
        log.info("비즈니스 로직 실행1");
      }
    };

    CallBack callBack2 = new CallBack() {
      @Override
      public void call() {
        log.info("비즈니스 로직 실행2");
      }
    };
    TimeLogTemplate template = new TimeLogTemplate();
    template.execute(callBack1);
    template.execute(callBack2);
  }

  /**
   * 템플릿 콜백 패턴 - 람다
   */
  @Test
  void callBackV2(){
    TimeLogTemplate template = new TimeLogTemplate();
    template.execute(() -> log.info("비즈니스 로직 실행 1"));
    template.execute(() -> log.info("비즈니스 로직 실행 2"));
  }
}

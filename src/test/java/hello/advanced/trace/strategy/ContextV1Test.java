package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.ContextV1;
import hello.advanced.trace.strategy.code.Strategy;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import hello.advanced.trace.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    /**
     * 전략 패턴(필드)
     */
    @Test
    void strategyV1(){
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        Strategy strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    /**
     * 전략 패턴(필드)
     * 익명 내부클래스, 람다
     */
    @Test
    void strategyV2(){
        // 생성시 전달
//        ContextV1 contextV1 = new ContextV1(new StrategyLogic1() {
//            @Override
//            public void call() {
//                log.info("비즈니스 로직1 실행");
//            }
//        });
//        contextV1.execute();

        // 람다로 변환
        // 자바8부터 지원
        // 인터페이스에 메서드가 1개만 있어야 함.
        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
        contextV1.execute();

//        ContextV1 contextV2 = new ContextV1(new StrategyLogic2() {
//            @Override
//            public void call() {
//                log.info("비즈니스 로직2 실행");
//            }
//        });
//        contextV2.execute();

        // 람다로 변환
        ContextV1 contextV2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        contextV2.execute();
    }
}

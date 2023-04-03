package hello.advanced.proxy.concreteproxy;

import hello.advanced.proxy.concreteproxy.code.ConcreteClient;
import hello.advanced.proxy.concreteproxy.code.ConcreteLogic;
import hello.advanced.proxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

/**
 * 구체클래스 기반 프록시 테스트
 * (인터페이스 없이, 클라이언트 코드변경 없이 프록시패턴 사용)
 */
public class ConcreteProxyTest {

    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    @Test
    void addProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}

package hello.advanced.proxy.decorator;

import hello.advanced.proxy.decorator.code.Component;
import hello.advanced.proxy.decorator.code.DecoratorPatternClient;
import hello.advanced.proxy.decorator.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    void noDecorator(){
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

}

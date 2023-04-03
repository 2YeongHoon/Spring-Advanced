package hello.advanced.proxy.decorator;

import hello.advanced.proxy.decorator.code.Component;
import hello.advanced.proxy.decorator.code.DecoratorPatternClient;
import hello.advanced.proxy.decorator.code.MessageDecorator;
import hello.advanced.proxy.decorator.code.RealComponent;
import hello.advanced.proxy.decorator.code.TimeDecorator;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    void noDecorator(){
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1(){
        RealComponent component = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(component);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator2(){
        RealComponent component = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(component);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }

}

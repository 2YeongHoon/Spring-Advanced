package hello.advanced.proxy.pureproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{

    @Override
    public String operator() {
        log.info("실제 객체 호출");
        sleep(1000);
        return "data";
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

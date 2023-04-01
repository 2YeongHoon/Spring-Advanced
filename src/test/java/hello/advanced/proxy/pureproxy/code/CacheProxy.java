package hello.advanced.proxy.pureproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

    private Subject subject;
    private String cacheValue;

    public CacheProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String operation() {
        log.info("캐시호출");
        if(cacheValue == null){
            cacheValue = subject.operation();
        }
        return cacheValue;
    }
}

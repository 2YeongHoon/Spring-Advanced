package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = () -> {
            threadLocalService.logic("userA");
        };

        Runnable userB = () -> {
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("userA");
        Thread threadB = new Thread(userB);
        threadB.setName("userB");

        threadA.start();
//        sleep(2000); //동시성 문제 발생X
        sleep(500); //동시성 문제 발생O
        threadB.start();
        sleep(3000); //메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
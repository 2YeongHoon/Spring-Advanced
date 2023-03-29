package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {

  private final LogTrace trace;

  public void save(String itemId) {
    TraceTemplate template = new TraceTemplate(trace);
    template.execute("OrderRepositoryV5.begin()", () -> {
      if (itemId.equals("ex")) {
        throw new IllegalStateException("예외 발생!!");
      }
      sleep(1000);
      return null;
    });
  }

  public void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

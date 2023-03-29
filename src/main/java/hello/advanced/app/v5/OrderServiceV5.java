package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

  private final OrderRepositoryV5 orderRepositoryV5;
  private final LogTrace trace;

  public void orderItem(String itemId){
    TraceTemplate template = new TraceTemplate(trace);
    template.execute("OrderServiceV4.begin()", () -> {
      orderRepositoryV5.save(itemId);
      return null;
    });
  }
}

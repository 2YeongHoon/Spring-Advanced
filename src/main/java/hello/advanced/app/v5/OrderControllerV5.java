package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

  private final OrderServiceV5 orderServiceV5;
  private final TraceTemplate template;
//  private final LogTrace logTrace;

  // Autowired 생략가능
  public OrderControllerV5(OrderServiceV5 orderServiceV5, LogTrace trace){
    this.orderServiceV5 = orderServiceV5;
    this.template = new TraceTemplate(trace);
  }

  @GetMapping("/v5/request")
  public String request(String itemId) {
    // 매번 객체를 생성하는 것 보다 전역으로 주입받아 사용하는 것이 좋음.
    // TraceTemplate template = new TraceTemplate(logTrace);
    return template.execute("OrderController.begin()", () -> {
      orderServiceV5.orderItem(itemId);
      return "OK";
    });
  }
}

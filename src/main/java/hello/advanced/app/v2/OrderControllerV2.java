package hello.advanced.app.v2;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

  private final OrderServiceV2 orderServiceV2;
  private final HelloTraceV2 trace;

  @GetMapping("/v2/request")
  public String request(String itemId){

    // 단순히 trace.begin, trace.end만 추가해주면 될 줄 알았지만,
    // 예외처리를 위한 try catch문이 들어가며 굉장히 코드가 지저분해짐.
    TraceStatus status = null;
    try {
      status = trace.begin("OrderController.begin()");
      orderServiceV2.orderItem(status.getTraceId(), itemId);
      trace.end(status);
      return "OK";
    } catch (Exception e){
      trace.exception(status, e);
      throw e;
    }
  }
}

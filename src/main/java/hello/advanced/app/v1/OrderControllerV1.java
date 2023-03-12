package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

  private final OrderServiceV1 orderServiceV1;
  private final HelloTraceV1 trace;

  @GetMapping("/v1/request")
  public String request(String itemId){

    // 단순히 trace.begin, trace.end만 추가해주면 될 줄 알았지만,
    // 예외처리를 위한 try catch문이 들어가며 굉장히 코드가 지저분해짐.
    TraceStatus status = null;
    try {
      status = trace.begin("OrderController.begin()");
      orderServiceV1.orderItem(itemId);
      trace.end(status);
      return "OK";
    } catch (Exception e){
      trace.exception(status, e);
      throw e;
    }
  }
}

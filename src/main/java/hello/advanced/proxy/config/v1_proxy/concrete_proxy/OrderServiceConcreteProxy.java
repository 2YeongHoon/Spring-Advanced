package hello.advanced.proxy.config.v1_proxy.concrete_proxy;

import hello.advanced.proxy.app.v2.OrderRepositoryV2;
import hello.advanced.proxy.app.v2.OrderServiceV2;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

  private final OrderServiceV2 target;
  private final LogTrace logTrace;

  public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
    // 클래스 기반 프록시 단점
    super(null); // 프록시 기능 사용하지 않아서 null, 문법상 super 대입
    this.target = target;
    this.logTrace = logTrace;
  }

  @Override
  public void orderItem(String itemId) {
    TraceStatus status = null;
    try{
      status = logTrace.begin("OrderService.begin()");
      // target호출
      target.orderItem(itemId);
      logTrace.end(status);
    }catch (Exception e){
      logTrace.exception(status, e);
      throw e;
    }  }
}

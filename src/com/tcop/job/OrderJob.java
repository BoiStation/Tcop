package com.tcop.job;

import javax.annotation.Resource;
import com.tcop.service.OrderService;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("orderJob")
@Lazy(false)
public class OrderJob
{
  @Resource(name="orderServiceImpl")
  private OrderService IIIllIlI;
  
  @Scheduled(cron="${job.order_release_stock.cron}")
  public void releaseStock()
  {
    this.IIIllIlI.releaseStock();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.job.OrderJob
 * JD-Core Version:    0.7.0.1
 */
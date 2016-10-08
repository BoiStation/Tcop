package com.tcop.job;

import javax.annotation.Resource;
import com.tcop.service.CartService;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("cartJob")
@Lazy(false)
public class CartJob
{
  @Resource(name="cartServiceImpl")
  private CartService IIIllIlI;
  
  @Scheduled(cron="${job.cart_evict_expired.cron}")
  public void evictExpired()
  {
    this.IIIllIlI.evictExpired();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.job.CartJob
 * JD-Core Version:    0.7.0.1
 */
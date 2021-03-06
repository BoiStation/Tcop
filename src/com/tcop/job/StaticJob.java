package com.tcop.job;

import javax.annotation.Resource;
import com.tcop.service.StaticService;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("staticJob")
@Lazy(false)
public class StaticJob
{
  @Resource(name="staticServiceImpl")
  private StaticService IIIllIlI;
  
  @Scheduled(cron="${job.static_build.cron}")
  public void build()
  {
    this.IIIllIlI.buildAll();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.job.StaticJob
 * JD-Core Version:    0.7.0.1
 */
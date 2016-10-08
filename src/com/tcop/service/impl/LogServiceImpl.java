package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.LogDao;
import com.tcop.entity.Log;
import com.tcop.service.LogService;
import org.springframework.stereotype.Service;

@Service("logServiceImpl")
public class LogServiceImpl
  extends BaseServiceImpl<Log, Long>
  implements LogService
{
  @Resource(name="logDaoImpl")
  private LogDao IIIllIlI;
  
  @Resource(name="logDaoImpl")
  public void setBaseDao(LogDao logDao)
  {
    super.setBaseDao(logDao);
  }
  
  public void clear()
  {
    this.IIIllIlI.removeAll();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.LogServiceImpl
 * JD-Core Version:    0.7.0.1
 */
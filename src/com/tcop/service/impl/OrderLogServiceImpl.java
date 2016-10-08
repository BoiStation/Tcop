package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.OrderLogDao;
import com.tcop.entity.OrderLog;
import com.tcop.service.OrderLogService;
import org.springframework.stereotype.Service;

@Service("orderLogServiceImpl")
public class OrderLogServiceImpl
  extends BaseServiceImpl<OrderLog, Long>
  implements OrderLogService
{
  @Resource(name="orderLogDaoImpl")
  public void setBaseDao(OrderLogDao orderLogDao)
  {
    super.setBaseDao(orderLogDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.OrderLogServiceImpl
 * JD-Core Version:    0.7.0.1
 */
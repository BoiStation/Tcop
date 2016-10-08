package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.OrderItemDao;
import com.tcop.entity.OrderItem;
import com.tcop.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service("orderItemServiceImpl")
public class OrderItemServiceImpl
  extends BaseServiceImpl<OrderItem, Long>
  implements OrderItemService
{
  @Resource(name="orderItemDaoImpl")
  public void setBaseDao(OrderItemDao orderItemDao)
  {
    super.setBaseDao(orderItemDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.OrderItemServiceImpl
 * JD-Core Version:    0.7.0.1
 */
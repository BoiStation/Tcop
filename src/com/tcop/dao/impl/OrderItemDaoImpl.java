package com.tcop.dao.impl;

import com.tcop.dao.OrderItemDao;
import com.tcop.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository("orderItemDaoImpl")
public class OrderItemDaoImpl
  extends BaseDaoImpl<OrderItem, Long>
  implements OrderItemDao
{}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.OrderItemDaoImpl
 * JD-Core Version:    0.7.0.1
 */
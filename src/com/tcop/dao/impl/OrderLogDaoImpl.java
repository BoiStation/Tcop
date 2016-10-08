package com.tcop.dao.impl;

import com.tcop.dao.OrderLogDao;
import com.tcop.entity.OrderLog;
import org.springframework.stereotype.Repository;

@Repository("orderLogDaoImpl")
public class OrderLogDaoImpl
  extends BaseDaoImpl<OrderLog, Long>
  implements OrderLogDao
{}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.OrderLogDaoImpl
 * JD-Core Version:    0.7.0.1
 */
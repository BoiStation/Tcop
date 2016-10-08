package com.tcop.dao.impl;

import com.tcop.dao.CartItemDao;
import com.tcop.entity.CartItem;
import org.springframework.stereotype.Repository;

@Repository("cartItemDaoImpl")
public class CartItemDaoImpl
  extends BaseDaoImpl<CartItem, Long>
  implements CartItemDao
{}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.CartItemDaoImpl
 * JD-Core Version:    0.7.0.1
 */
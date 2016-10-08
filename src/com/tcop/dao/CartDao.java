package com.tcop.dao;

import com.tcop.entity.Cart;

public abstract interface CartDao
  extends BaseDao<Cart, Long>
{
  public abstract void evictExpired();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.CartDao
 * JD-Core Version:    0.7.0.1
 */
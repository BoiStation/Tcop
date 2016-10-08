package com.tcop.service;

import com.tcop.entity.Cart;
import com.tcop.entity.Member;

public abstract interface CartService
  extends BaseService<Cart, Long>
{
  public abstract Cart getCurrent();
  
  public abstract void merge(Member paramMember, Cart paramCart);
  
  public abstract void evictExpired();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.CartService
 * JD-Core Version:    0.7.0.1
 */
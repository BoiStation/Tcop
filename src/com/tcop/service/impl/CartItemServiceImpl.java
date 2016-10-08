package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.CartItemDao;
import com.tcop.entity.CartItem;
import com.tcop.service.CartItemService;
import org.springframework.stereotype.Service;

@Service("cartItemServiceImpl")
public class CartItemServiceImpl
  extends BaseServiceImpl<CartItem, Long>
  implements CartItemService
{
  @Resource(name="cartItemDaoImpl")
  public void setBaseDao(CartItemDao cartItemDao)
  {
    super.setBaseDao(cartItemDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.CartItemServiceImpl
 * JD-Core Version:    0.7.0.1
 */
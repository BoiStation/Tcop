package com.tcop.service;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.ProductNotify;

public abstract interface ProductNotifyService
  extends BaseService<ProductNotify, Long>
{
  public abstract boolean exists(Product paramProduct, String paramString);
  
  public abstract Page<ProductNotify> findPage(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3);
  
  public abstract int send(Long[] paramArrayOfLong);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.ProductNotifyService
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.dao;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.ProductNotify;

public abstract interface ProductNotifyDao
  extends BaseDao<ProductNotify, Long>
{
  public abstract boolean exists(Product paramProduct, String paramString);
  
  public abstract Page<ProductNotify> findPage(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.ProductNotifyDao
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.service;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.entity.Brand;

public abstract interface BrandService
  extends BaseService<Brand, Long>
{
  public abstract List<Brand> findList(Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.BrandService
 * JD-Core Version:    0.7.0.1
 */
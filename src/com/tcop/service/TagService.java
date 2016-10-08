package com.tcop.service;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.entity.Tag;
import com.tcop.entity.Tag.Type;

public abstract interface TagService
  extends BaseService<Tag, Long>
{
  public abstract List<Tag> findList(Tag.Type paramType);
  
  public abstract List<Tag> findList(Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.TagService
 * JD-Core Version:    0.7.0.1
 */
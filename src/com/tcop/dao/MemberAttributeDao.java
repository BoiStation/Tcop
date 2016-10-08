package com.tcop.dao;

import java.util.List;
import com.tcop.entity.MemberAttribute;

public abstract interface MemberAttributeDao
  extends BaseDao<MemberAttribute, Long>
{
  public abstract Integer findUnusedPropertyIndex();
  
  public abstract List<MemberAttribute> findList();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.MemberAttributeDao
 * JD-Core Version:    0.7.0.1
 */
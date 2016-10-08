package com.tcop.dao;

import java.util.List;
import com.tcop.entity.Tag;
import com.tcop.entity.Tag.Type;

public abstract interface TagDao
  extends BaseDao<Tag, Long>
{
  public abstract List<Tag> findList(Tag.Type paramType);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.TagDao
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.dao;

import java.math.BigDecimal;
import com.tcop.entity.MemberRank;

public abstract interface MemberRankDao
  extends BaseDao<MemberRank, Long>
{
  public abstract boolean nameExists(String paramString);
  
  public abstract boolean amountExists(BigDecimal paramBigDecimal);
  
  public abstract MemberRank findDefault();
  
  public abstract MemberRank findByAmount(BigDecimal paramBigDecimal);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.MemberRankDao
 * JD-Core Version:    0.7.0.1
 */
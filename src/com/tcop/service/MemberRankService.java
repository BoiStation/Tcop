package com.tcop.service;

import java.math.BigDecimal;
import com.tcop.entity.MemberRank;

public abstract interface MemberRankService
  extends BaseService<MemberRank, Long>
{
  public abstract boolean nameExists(String paramString);
  
  public abstract boolean nameUnique(String paramString1, String paramString2);
  
  public abstract boolean amountExists(BigDecimal paramBigDecimal);
  
  public abstract boolean amountUnique(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2);
  
  public abstract MemberRank findDefault();
  
  public abstract MemberRank findByAmount(BigDecimal paramBigDecimal);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.MemberRankService
 * JD-Core Version:    0.7.0.1
 */
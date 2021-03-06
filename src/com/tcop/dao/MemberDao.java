package com.tcop.dao;

import java.util.Date;
import java.util.List;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;

public abstract interface MemberDao
  extends BaseDao<Member, Long>
{
  public abstract boolean usernameExists(String paramString);
  
  public abstract boolean emailExists(String paramString);
  
  public abstract Member findByUsername(String paramString);
  
  public abstract List<Member> findListByEmail(String paramString);
  
  public abstract Page<Object> findPurchasePage(Date paramDate1, Date paramDate2, Pageable paramPageable);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.MemberDao
 * JD-Core Version:    0.7.0.1
 */
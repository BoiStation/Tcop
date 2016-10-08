package com.tcop.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.LockModeType;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;

public abstract interface BaseDao<T, ID extends Serializable>
{
  public abstract T find(ID paramID);
  
  public abstract List<T> findList(Integer paramInteger1, Integer paramInteger2, List<Filter> paramList, List<Order> paramList1);
  
  public abstract Page<T> findPage(Pageable paramPageable);
  
  public abstract long count(Filter... paramVarArgs);
  
  public abstract void persist(T paramT);
  
  public abstract T merge(T paramT);
  
  public abstract void remove(T paramT);
  
  public abstract void refresh(T paramT);
  
  public abstract ID getIdentifier(T paramT);
  
  public abstract boolean isManaged(T paramT);
  
  public abstract void detach(T paramT);
  
  public abstract void lock(T paramT, LockModeType paramLockModeType);
  
  public abstract void clear();
  
  public abstract void flush();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.BaseDao
 * JD-Core Version:    0.7.0.1
 */
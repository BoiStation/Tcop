package com.tcop.service;

import java.io.Serializable;
import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;

public abstract interface BaseService<T, ID extends Serializable>
{
  public abstract T find(ID paramID);
  
  public abstract List<T> findAll();
  
  public abstract List<T> findList(ID... paramVarArgs);
  
  public abstract List<T> findList(Integer paramInteger, List<Filter> paramList, List<Order> paramList1);
  
  public abstract List<T> findList(Integer paramInteger1, Integer paramInteger2, List<Filter> paramList, List<Order> paramList1);
  
  public abstract Page<T> findPage(Pageable paramPageable);
  
  public abstract long count();
  
  public abstract long count(Filter... paramVarArgs);
  
  public abstract boolean exists(ID paramID);
  
  public abstract boolean exists(Filter... paramVarArgs);
  
  public abstract void save(T paramT);
  
  public abstract T update(T paramT);
  
  public abstract T update(T paramT, String... paramVarArgs);
  
  public abstract void delete(ID paramID);
  
  public abstract void delete(ID... paramVarArgs);
  
  public abstract void delete(T paramT);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.BaseService
 * JD-Core Version:    0.7.0.1
 */
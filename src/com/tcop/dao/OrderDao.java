package com.tcop.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.tcop.Filter;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Order;

public abstract interface OrderDao
  extends BaseDao<com.tcop.entity.Order, Long>
{
  public abstract com.tcop.entity.Order findBySn(String paramString);
  
  public abstract List<com.tcop.entity.Order> findList(Member paramMember, Integer paramInteger, List<Filter> paramList, List<com.tcop.Order> paramList1);
  
  public abstract Page<com.tcop.entity.Order> findPage(Member paramMember, Pageable paramPageable);
  
  public abstract Page<com.tcop.entity.Order> findPage(Order.OrderStatus paramOrderStatus, Order.PaymentStatus paramPaymentStatus, Order.ShippingStatus paramShippingStatus, Boolean paramBoolean, Pageable paramPageable);
  
  public abstract Long count(Order.OrderStatus paramOrderStatus, Order.PaymentStatus paramPaymentStatus, Order.ShippingStatus paramShippingStatus, Boolean paramBoolean);
  
  public abstract Long waitingPaymentCount(Member paramMember);
  
  public abstract Long waitingShippingCount(Member paramMember);
  
  public abstract BigDecimal getSalesAmount(Date paramDate1, Date paramDate2);
  
  public abstract Integer getSalesVolume(Date paramDate1, Date paramDate2);
  
  public abstract void releaseStock();
}
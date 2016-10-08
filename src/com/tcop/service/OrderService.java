package com.tcop.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.tcop.Filter;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Admin;
import com.tcop.entity.Cart;
import com.tcop.entity.CouponCode;
import com.tcop.entity.Member;
import com.tcop.entity.Order;
import com.tcop.entity.Order.OrderStatus;
import com.tcop.entity.Order.PaymentStatus;
import com.tcop.entity.Order.ShippingStatus;
import com.tcop.entity.Payment;
import com.tcop.entity.PaymentMethod;
import com.tcop.entity.Receiver;
import com.tcop.entity.Refunds;
import com.tcop.entity.Returns;
import com.tcop.entity.Shipping;
import com.tcop.entity.ShippingMethod;

public abstract interface OrderService
  extends BaseService<com.tcop.entity.Order, Long>
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
  
  public abstract com.tcop.entity.Order build(Cart paramCart, Receiver paramReceiver, PaymentMethod paramPaymentMethod, ShippingMethod paramShippingMethod, CouponCode paramCouponCode, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2);
  
  public abstract com.tcop.entity.Order create(Cart paramCart, Receiver paramReceiver, PaymentMethod paramPaymentMethod, ShippingMethod paramShippingMethod, CouponCode paramCouponCode, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, Admin paramAdmin);
  
  public abstract void update(com.tcop.entity.Order paramOrder, Admin paramAdmin);
  
  public abstract void confirm(com.tcop.entity.Order paramOrder, Admin paramAdmin);
  
  public abstract void complete(com.tcop.entity.Order paramOrder, Admin paramAdmin);
  
  public abstract void cancel(com.tcop.entity.Order paramOrder, Admin paramAdmin);
  
  public abstract void payment(com.tcop.entity.Order paramOrder, Payment paramPayment, Admin paramAdmin);
  
  public abstract void refunds(com.tcop.entity.Order paramOrder, Refunds paramRefunds, Admin paramAdmin);
  
  public abstract void shipping(com.tcop.entity.Order paramOrder, Shipping paramShipping, Admin paramAdmin);
  
  public abstract void returns(com.tcop.entity.Order paramOrder, Returns paramReturns, Admin paramAdmin);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.OrderService
 * JD-Core Version:    0.7.0.1
 */
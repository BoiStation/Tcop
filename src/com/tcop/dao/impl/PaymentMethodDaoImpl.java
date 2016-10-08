package com.tcop.dao.impl;

import com.tcop.dao.PaymentMethodDao;
import com.tcop.entity.PaymentMethod;
import org.springframework.stereotype.Repository;

@Repository("paymentMethodDaoImpl")
public class PaymentMethodDaoImpl
  extends BaseDaoImpl<PaymentMethod, Long>
  implements PaymentMethodDao
{}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.PaymentMethodDaoImpl
 * JD-Core Version:    0.7.0.1
 */
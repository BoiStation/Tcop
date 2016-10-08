package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.PaymentMethodDao;
import com.tcop.entity.PaymentMethod;
import com.tcop.service.PaymentMethodService;
import org.springframework.stereotype.Service;

@Service("paymentMethodServiceImpl")
public class PaymentMethodServiceImpl
  extends BaseServiceImpl<PaymentMethod, Long>
  implements PaymentMethodService
{
  @Resource(name="paymentMethodDaoImpl")
  public void setBaseDao(PaymentMethodDao paymentMethodDao)
  {
    super.setBaseDao(paymentMethodDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.PaymentMethodServiceImpl
 * JD-Core Version:    0.7.0.1
 */
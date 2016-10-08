package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.PaymentDao;
import com.tcop.entity.Payment;
import com.tcop.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("paymentServiceImpl")
public class PaymentServiceImpl
  extends BaseServiceImpl<Payment, Long>
  implements PaymentService
{
  @Resource(name="paymentDaoImpl")
  private PaymentDao IIIllIlI;
  
  @Resource(name="paymentDaoImpl")
  public void setBaseDao(PaymentDao paymentDao)
  {
    super.setBaseDao(paymentDao);
  }
  
  @Transactional(readOnly=true)
  public Payment findBySn(String sn)
  {
    return this.IIIllIlI.findBySn(sn);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.PaymentServiceImpl
 * JD-Core Version:    0.7.0.1
 */
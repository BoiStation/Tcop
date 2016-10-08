package com.tcop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.tcop.dao.PaymentDao;
import com.tcop.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository("paymentDaoImpl")
public class PaymentDaoImpl
  extends BaseDaoImpl<Payment, Long>
  implements PaymentDao
{
  public Payment findBySn(String sn)
  {
    if (sn == null) {
      return null;
    }
    String str = "select payment from Payment payment where lower(payment.sn) = lower(:sn)";
    try
    {
      return (Payment)this.entityManager.createQuery(str, Payment.class).setFlushMode(FlushModeType.COMMIT).setParameter("sn", sn).getSingleResult();
    }
    catch (NoResultException localNoResultException) {}
    return null;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.PaymentDaoImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.dao.impl;

import java.util.Collections;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.DepositDao;
import com.tcop.entity.Deposit;
import com.tcop.entity.Member;
import org.springframework.stereotype.Repository;

@Repository("depositDaoImpl")
public class DepositDaoImpl
  extends BaseDaoImpl<Deposit, Long>
  implements DepositDao
{
  public Page<Deposit> findPage(Member member, Pageable pageable)
  {
    if (member == null) {
      return new Page(Collections.emptyList(), 0L, pageable);
    }
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Deposit.class);
    Root localRoot = localCriteriaQuery.from(Deposit.class);
    localCriteriaQuery.select(localRoot);
    localCriteriaQuery.where(localCriteriaBuilder.equal(localRoot.get("member"), member));
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.DepositDaoImpl
 * JD-Core Version:    0.7.0.1
 */
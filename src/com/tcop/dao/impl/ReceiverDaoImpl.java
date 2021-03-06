package com.tcop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.ReceiverDao;
import com.tcop.entity.Member;
import com.tcop.entity.Receiver;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository("receiverDaoImpl")
public class ReceiverDaoImpl
  extends BaseDaoImpl<Receiver, Long>
  implements ReceiverDao
{
  public Receiver findDefault(Member member)
  {
    if (member == null) {
      return null;
    }
    try
    {
      String str1 = "select receiver from Receiver receiver where receiver.member = :member and receiver.isDefault = true";
      return (Receiver)this.entityManager.createQuery(str1, Receiver.class).setFlushMode(FlushModeType.COMMIT).setParameter("member", member).getSingleResult();
    }
    catch (NoResultException localNoResultException2)
    {
      try
      {
        String str2 = "select receiver from Receiver receiver where receiver.member = :member order by receiver.modifyDate desc";
        return (Receiver)this.entityManager.createQuery(str2, Receiver.class).setFlushMode(FlushModeType.COMMIT).setParameter("member", member).setMaxResults(1).getSingleResult();
      }
      catch (NoResultException localNoResultException3) {}
    }
    return null;
  }
  
  public Page<Receiver> findPage(Member member, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Receiver.class);
    Root localRoot = localCriteriaQuery.from(Receiver.class);
    localCriteriaQuery.select(localRoot);
    if (member != null) {
      localCriteriaQuery.where(localCriteriaBuilder.equal(localRoot.get("member"), member));
    }
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
  
  public void persist(Receiver receiver)
  {
    Assert.notNull(receiver);
    Assert.notNull(receiver.getMember());
    if (receiver.getIsDefault().booleanValue())
    {
      String str = "update Receiver receiver set receiver.isDefault = false where receiver.member = :member and receiver.isDefault = true";
      this.entityManager.createQuery(str).setFlushMode(FlushModeType.COMMIT).setParameter("member", receiver.getMember()).executeUpdate();
    }
    super.persist(receiver);
  }
  
  public Receiver merge(Receiver receiver)
  {
    Assert.notNull(receiver);
    Assert.notNull(receiver.getMember());
    if (receiver.getIsDefault().booleanValue())
    {
      String str = "update Receiver receiver set receiver.isDefault = false where receiver.member = :member and receiver.isDefault = true and receiver != :receiver";
      this.entityManager.createQuery(str).setFlushMode(FlushModeType.COMMIT).setParameter("member", receiver.getMember()).setParameter("receiver", receiver).executeUpdate();
    }
    return (Receiver)super.merge(receiver);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.ReceiverDaoImpl
 * JD-Core Version:    0.7.0.1
 */
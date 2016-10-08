package com.tcop.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import com.tcop.dao.FriendLinkDao;
import com.tcop.entity.FriendLink;
import com.tcop.entity.FriendLink.Type;
import org.springframework.stereotype.Repository;

@Repository("friendLinkDaoImpl")
public class FriendLinkDaoImpl
  extends BaseDaoImpl<FriendLink, Long>
  implements FriendLinkDao
{
  public List<FriendLink> findList(FriendLink.Type type)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(FriendLink.class);
    Root localRoot = localCriteriaQuery.from(FriendLink.class);
    localCriteriaQuery.select(localRoot);
    if (type != null) {
      localCriteriaQuery.where(localCriteriaBuilder.equal(localRoot.get("type"), type));
    }
    localCriteriaQuery.orderBy(new Order[] { localCriteriaBuilder.asc(localRoot.get("order")) });
    return this.entityManager.createQuery(localCriteriaQuery).setFlushMode(FlushModeType.COMMIT).getResultList();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.FriendLinkDaoImpl
 * JD-Core Version:    0.7.0.1
 */
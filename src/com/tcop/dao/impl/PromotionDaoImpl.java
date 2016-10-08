package com.tcop.dao.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.dao.PromotionDao;
import com.tcop.entity.Promotion;
import org.springframework.stereotype.Repository;

@Repository("promotionDaoImpl")
public class PromotionDaoImpl
  extends BaseDaoImpl<Promotion, Long>
  implements PromotionDao
{
  public List<Promotion> findList(Boolean hasBegun, Boolean hasEnded, Integer count, List<Filter> filters, List<Order> orders)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Promotion.class);
    Root localRoot = localCriteriaQuery.from(Promotion.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (hasBegun != null) {
      if (hasBegun.booleanValue()) {
        localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localRoot.get("beginDate").isNull(), localCriteriaBuilder.lessThanOrEqualTo(localRoot.get("beginDate"), new Date())));
      } else {
        localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localRoot.get("beginDate").isNotNull(), localCriteriaBuilder.greaterThan(localRoot.get("beginDate"), new Date()) });
      }
    }
    if (hasEnded != null) {
      if (hasEnded.booleanValue()) {
        localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localRoot.get("endDate").isNotNull(), localCriteriaBuilder.lessThan(localRoot.get("endDate"), new Date()) });
      } else {
        localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localRoot.get("endDate").isNull(), localCriteriaBuilder.greaterThanOrEqualTo(localRoot.get("endDate"), new Date())));
      }
    }
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, null, count, filters, orders);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.PromotionDaoImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.ConsultationDao;
import com.tcop.entity.Consultation;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import org.springframework.stereotype.Repository;

@Repository("consultationDaoImpl")
public class ConsultationDaoImpl
  extends BaseDaoImpl<Consultation, Long>
  implements ConsultationDao
{
  public List<Consultation> findList(Member member, Product product, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Consultation.class);
    Root localRoot = localCriteriaQuery.from(Consultation.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.isNull(localRoot.get("forConsultation")));
    if (member != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    }
    if (product != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    }
    if (isShow != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    }
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, null, count, filters, orders);
  }
  
  public Page<Consultation> findPage(Member member, Product product, Boolean isShow, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Consultation.class);
    Root localRoot = localCriteriaQuery.from(Consultation.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.isNull(localRoot.get("forConsultation")));
    if (member != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    }
    if (product != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    }
    if (isShow != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    }
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
  
  public Long count(Member member, Product product, Boolean isShow)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Consultation.class);
    Root localRoot = localCriteriaQuery.from(Consultation.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.isNull(localRoot.get("forConsultation")));
    if (member != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    }
    if (product != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    }
    if (isShow != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    }
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, (List)null);
  }
}
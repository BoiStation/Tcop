package com.tcop.dao.impl;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.tcop.dao.ParameterDao;
import com.tcop.entity.Parameter;
import com.tcop.entity.ParameterGroup;
import org.springframework.stereotype.Repository;

@Repository("parameterDaoImpl")
public class ParameterDaoImpl
  extends BaseDaoImpl<Parameter, Long>
  implements ParameterDao
{
  public List<Parameter> findList(ParameterGroup parameterGroup, Set<Parameter> excludes)
  {
    CriteriaBuilder localCriteriaBuilder = this.entityManager.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Parameter.class);
    Root localRoot = localCriteriaQuery.from(Parameter.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (parameterGroup != null) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("parameterGroup"), parameterGroup));
    }
    if ((excludes != null) && (!excludes.isEmpty())) {
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.not(localRoot.in(excludes)));
    }
    localCriteriaQuery.where(localPredicate);
    return this.entityManager.createQuery(localCriteriaQuery).setFlushMode(FlushModeType.COMMIT).getResultList();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.ParameterDaoImpl
 * JD-Core Version:    0.7.0.1
 */
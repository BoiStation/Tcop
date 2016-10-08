package com.tcop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.tcop.dao.SeoDao;
import com.tcop.entity.Seo;
import com.tcop.entity.Seo.Type;
import org.springframework.stereotype.Repository;

@Repository("seoDaoImpl")
public class SeoDaoImpl
  extends BaseDaoImpl<Seo, Long>
  implements SeoDao
{
  public Seo find(Seo.Type type)
  {
    if (type == null) {
      return null;
    }
    try
    {
      String str = "select seo from Seo seo where seo.type = :type";
      return (Seo)this.entityManager.createQuery(str, Seo.class).setFlushMode(FlushModeType.COMMIT).setParameter("type", type).getSingleResult();
    }
    catch (NoResultException localNoResultException1) {}
    return null;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.SeoDaoImpl
 * JD-Core Version:    0.7.0.1
 */
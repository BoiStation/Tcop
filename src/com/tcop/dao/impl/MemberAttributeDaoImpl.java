package com.tcop.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.tcop.dao.MemberAttributeDao;
import com.tcop.entity.MemberAttribute;
import com.tcop.entity.MemberAttribute.Type;
import org.springframework.stereotype.Repository;

@Repository("memberAttributeDaoImpl")
public class MemberAttributeDaoImpl
  extends BaseDaoImpl<MemberAttribute, Long>
  implements MemberAttributeDao
{
  public Integer findUnusedPropertyIndex()
  {
    for (int i = 0; i < 10; i++)
    {
      String str = "select count(*) from MemberAttribute memberAttribute where memberAttribute.propertyIndex = :propertyIndex";
      Long localLong = (Long)this.entityManager.createQuery(str, Long.class).setFlushMode(FlushModeType.COMMIT).setParameter("propertyIndex", Integer.valueOf(i)).getSingleResult();
      if (localLong.longValue() == 0L) {
        return Integer.valueOf(i);
      }
    }
    return null;
  }
  
  public List<MemberAttribute> findList()
  {
    String str = "select memberAttribute from MemberAttribute memberAttribute where memberAttribute.isEnabled = true order by memberAttribute.order asc";
    return this.entityManager.createQuery(str, MemberAttribute.class).setFlushMode(FlushModeType.COMMIT).getResultList();
  }
  
  public void remove(MemberAttribute memberAttribute)
  {
    if ((memberAttribute != null) && ((memberAttribute.getType() == MemberAttribute.Type.text) || (memberAttribute.getType() == MemberAttribute.Type.select) || (memberAttribute.getType() == MemberAttribute.Type.checkbox)))
    {
      String str1 = "attributeValue" + memberAttribute.getPropertyIndex();
      String str2 = "update Member members set members." + str1 + " = null";
      this.entityManager.createQuery(str2).setFlushMode(FlushModeType.COMMIT).executeUpdate();
      super.remove(memberAttribute);
    }
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.MemberAttributeDaoImpl
 * JD-Core Version:    0.7.0.1
 */
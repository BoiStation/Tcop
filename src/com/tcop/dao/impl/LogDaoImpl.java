package com.tcop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import com.tcop.dao.LogDao;
import com.tcop.entity.Log;
import org.springframework.stereotype.Repository;

@Repository("logDaoImpl")
public class LogDaoImpl
  extends BaseDaoImpl<Log, Long>
  implements LogDao
{
  public void removeAll()
  {
    String str = "delete from Log log";
    this.entityManager.createQuery(str).setFlushMode(FlushModeType.COMMIT).executeUpdate();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.LogDaoImpl
 * JD-Core Version:    0.7.0.1
 */
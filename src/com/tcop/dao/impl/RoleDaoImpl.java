package com.tcop.dao.impl;

import com.tcop.dao.RoleDao;
import com.tcop.entity.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDaoImpl")
public class RoleDaoImpl
  extends BaseDaoImpl<Role, Long>
  implements RoleDao
{}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.RoleDaoImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.dao.impl;

import com.tcop.dao.SpecificationDao;
import com.tcop.entity.Specification;
import org.springframework.stereotype.Repository;

@Repository("specificationDaoImpl")
public class SpecificationDaoImpl
  extends BaseDaoImpl<Specification, Long>
  implements SpecificationDao
{}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.SpecificationDaoImpl
 * JD-Core Version:    0.7.0.1
 */
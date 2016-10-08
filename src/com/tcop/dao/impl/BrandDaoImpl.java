package com.tcop.dao.impl;

import com.tcop.dao.BrandDao;
import com.tcop.entity.Brand;
import org.springframework.stereotype.Repository;

@Repository("brandDaoImpl")
public class BrandDaoImpl
  extends BaseDaoImpl<Brand, Long>
  implements BrandDao
{}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.BrandDaoImpl
 * JD-Core Version:    0.7.0.1
 */
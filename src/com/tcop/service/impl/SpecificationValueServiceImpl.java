package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.SpecificationValueDao;
import com.tcop.entity.SpecificationValue;
import com.tcop.service.SpecificationValueService;
import org.springframework.stereotype.Service;

@Service("specificationValueServiceImpl")
public class SpecificationValueServiceImpl
  extends BaseServiceImpl<SpecificationValue, Long>
  implements SpecificationValueService
{
  @Resource(name="specificationValueDaoImpl")
  public void setBaseDao(SpecificationValueDao specificationValueDao)
  {
    super.setBaseDao(specificationValueDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.SpecificationValueServiceImpl
 * JD-Core Version:    0.7.0.1
 */
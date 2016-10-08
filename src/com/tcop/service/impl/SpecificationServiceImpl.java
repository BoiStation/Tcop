package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.SpecificationDao;
import com.tcop.entity.Specification;
import com.tcop.service.SpecificationService;
import org.springframework.stereotype.Service;

@Service("specificationServiceImpl")
public class SpecificationServiceImpl
  extends BaseServiceImpl<Specification, Long>
  implements SpecificationService
{
  @Resource(name="specificationDaoImpl")
  public void setBaseDao(SpecificationDao specificationDao)
  {
    super.setBaseDao(specificationDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.SpecificationServiceImpl
 * JD-Core Version:    0.7.0.1
 */
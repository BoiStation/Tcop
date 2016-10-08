package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.AttributeDao;
import com.tcop.entity.Attribute;
import com.tcop.service.AttributeService;
import org.springframework.stereotype.Service;

@Service("attributeServiceImpl")
public class AttributeServiceImpl
  extends BaseServiceImpl<Attribute, Long>
  implements AttributeService
{
  @Resource(name="attributeDaoImpl")
  public void setBaseDao(AttributeDao attributeDao)
  {
    super.setBaseDao(attributeDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.AttributeServiceImpl
 * JD-Core Version:    0.7.0.1
 */
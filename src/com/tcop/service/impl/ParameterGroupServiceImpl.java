package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.ParameterGroupDao;
import com.tcop.entity.ParameterGroup;
import com.tcop.service.ParameterGroupService;
import org.springframework.stereotype.Service;

@Service("parameterGroupServiceImpl")
public class ParameterGroupServiceImpl
  extends BaseServiceImpl<ParameterGroup, Long>
  implements ParameterGroupService
{
  @Resource(name="parameterGroupDaoImpl")
  public void setBaseDao(ParameterGroupDao parameterGroupDao)
  {
    super.setBaseDao(parameterGroupDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.ParameterGroupServiceImpl
 * JD-Core Version:    0.7.0.1
 */
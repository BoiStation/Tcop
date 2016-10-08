package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.ParameterDao;
import com.tcop.entity.Parameter;
import com.tcop.service.ParameterService;
import org.springframework.stereotype.Service;

@Service("parameterServiceImpl")
public class ParameterServiceImpl
  extends BaseServiceImpl<Parameter, Long>
  implements ParameterService
{
  @Resource(name="parameterDaoImpl")
  public void setBaseDao(ParameterDao parameterDao)
  {
    super.setBaseDao(parameterDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.ParameterServiceImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.ReturnsDao;
import com.tcop.entity.Returns;
import com.tcop.service.ReturnsService;
import org.springframework.stereotype.Service;

@Service("returnsServiceImpl")
public class ReturnsServiceImpl
  extends BaseServiceImpl<Returns, Long>
  implements ReturnsService
{
  @Resource(name="returnsDaoImpl")
  public void setBaseDao(ReturnsDao returnsDao)
  {
    super.setBaseDao(returnsDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.ReturnsServiceImpl
 * JD-Core Version:    0.7.0.1
 */
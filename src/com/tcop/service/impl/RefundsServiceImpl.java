package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.RefundsDao;
import com.tcop.entity.Refunds;
import com.tcop.service.RefundsService;
import org.springframework.stereotype.Service;

@Service("refundsServiceImpl")
public class RefundsServiceImpl
  extends BaseServiceImpl<Refunds, Long>
  implements RefundsService
{
  @Resource(name="refundsDaoImpl")
  public void setBaseDao(RefundsDao refundsDao)
  {
    super.setBaseDao(refundsDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.RefundsServiceImpl
 * JD-Core Version:    0.7.0.1
 */
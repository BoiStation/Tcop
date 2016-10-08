package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.DeliveryCorpDao;
import com.tcop.entity.DeliveryCorp;
import com.tcop.service.DeliveryCorpService;
import org.springframework.stereotype.Service;

@Service("deliveryCorpServiceImpl")
public class DeliveryCorpServiceImpl
  extends BaseServiceImpl<DeliveryCorp, Long>
  implements DeliveryCorpService
{
  @Resource(name="deliveryCorpDaoImpl")
  public void setBaseDao(DeliveryCorpDao deliveryCorpDao)
  {
    super.setBaseDao(deliveryCorpDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.DeliveryCorpServiceImpl
 * JD-Core Version:    0.7.0.1
 */
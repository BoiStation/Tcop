package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.DeliveryCenterDao;
import com.tcop.entity.DeliveryCenter;
import com.tcop.service.DeliveryCenterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deliveryCenterServiceImpl")
public class DeliveryCenterServiceImpl
  extends BaseServiceImpl<DeliveryCenter, Long>
  implements DeliveryCenterService
{
  @Resource(name="deliveryCenterDaoImpl")
  private DeliveryCenterDao IIIllIlI;
  
  @Resource(name="deliveryCenterDaoImpl")
  public void setBaseDao(DeliveryCenterDao DeliveryCenterDao)
  {
    super.setBaseDao(DeliveryCenterDao);
  }
  
  @Transactional(readOnly=true)
  public DeliveryCenter findDefault()
  {
    return this.IIIllIlI.findDefault();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.DeliveryCenterServiceImpl
 * JD-Core Version:    0.7.0.1
 */
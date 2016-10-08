package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.DeliveryTemplateDao;
import com.tcop.entity.DeliveryTemplate;
import com.tcop.service.DeliveryTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deliveryTemplateServiceImpl")
public class DeliveryTemplateServiceImpl
  extends BaseServiceImpl<DeliveryTemplate, Long>
  implements DeliveryTemplateService
{
  @Resource(name="deliveryTemplateDaoImpl")
  private DeliveryTemplateDao IIIllIlI;
  
  @Resource(name="deliveryTemplateDaoImpl")
  public void setBaseDao(DeliveryTemplateDao deliveryTemplateDao)
  {
    super.setBaseDao(deliveryTemplateDao);
  }
  
  @Transactional(readOnly=true)
  public DeliveryTemplate findDefault()
  {
    return this.IIIllIlI.findDefault();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.DeliveryTemplateServiceImpl
 * JD-Core Version:    0.7.0.1
 */
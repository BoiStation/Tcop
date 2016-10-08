package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.ShippingMethodDao;
import com.tcop.entity.ShippingMethod;
import com.tcop.service.ShippingMethodService;
import org.springframework.stereotype.Service;

@Service("shippingMethodServiceImpl")
public class ShippingMethodServiceImpl
  extends BaseServiceImpl<ShippingMethod, Long>
  implements ShippingMethodService
{
  @Resource(name="shippingMethodDaoImpl")
  public void setBaseDao(ShippingMethodDao shippingMethodDao)
  {
    super.setBaseDao(shippingMethodDao);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.ShippingMethodServiceImpl
 * JD-Core Version:    0.7.0.1
 */
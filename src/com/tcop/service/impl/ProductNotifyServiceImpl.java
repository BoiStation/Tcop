package com.tcop.service.impl;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.ProductNotifyDao;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.ProductNotify;
import com.tcop.service.MailService;
import com.tcop.service.ProductNotifyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productNotifyServiceImpl")
public class ProductNotifyServiceImpl
  extends BaseServiceImpl<ProductNotify, Long>
  implements ProductNotifyService
{
  @Resource(name="productNotifyDaoImpl")
  ProductNotifyDao IIIllIlI;
  @Resource(name="mailServiceImpl")
  MailService IIIllIll;
  
  @Resource(name="productNotifyDaoImpl")
  public void setBaseDao(ProductNotifyDao ProductNotifyDao)
  {
    super.setBaseDao(ProductNotifyDao);
  }
  
  @Transactional(readOnly=true)
  public boolean exists(Product product, String email)
  {
    return this.IIIllIlI.exists(product, email);
  }
  
  @Transactional(readOnly=true)
  public Page<ProductNotify> findPage(Member member, Boolean isMarketable, Boolean isOutOfStock, Boolean hasSent, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, isMarketable, isOutOfStock, hasSent, pageable);
  }
  
  @Transactional(readOnly=true)
  public Long count(Member member, Boolean isMarketable, Boolean isOutOfStock, Boolean hasSent)
  {
    return this.IIIllIlI.count(member, isMarketable, isOutOfStock, hasSent);
  }
  
  public int send(Long[] ids)
  {
    List localList = findList(ids);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ProductNotify localProductNotify = (ProductNotify)localIterator.next();
      this.IIIllIll.sendProductNotifyMail(localProductNotify);
      localProductNotify.setHasSent(Boolean.valueOf(true));
      this.IIIllIlI.merge(localProductNotify);
    }
    return localList.size();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.ProductNotifyServiceImpl
 * JD-Core Version:    0.7.0.1
 */
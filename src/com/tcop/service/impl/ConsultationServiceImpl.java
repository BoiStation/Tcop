package com.tcop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.ConsultationDao;
import com.tcop.entity.Consultation;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.service.ConsultationService;
import com.tcop.service.StaticService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("consultationServiceImpl")
public class ConsultationServiceImpl
  extends BaseServiceImpl<Consultation, Long>
  implements ConsultationService
{
  @Resource(name="consultationDaoImpl")
  private ConsultationDao IIIllIlI;
  @Resource(name="staticServiceImpl")
  private StaticService IIIllIll;
  
  @Resource(name="consultationDaoImpl")
  public void setBaseDao(ConsultationDao consultationDao)
  {
    super.setBaseDao(consultationDao);
  }
  
  @Transactional(readOnly=true)
  public List<Consultation> findList(Member member, Product product, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders)
  {
    return this.IIIllIlI.findList(member, product, isShow, count, filters, orders);
  }
  
  @Transactional(readOnly=true)
  @Cacheable({"consultation"})
  public List<Consultation> findList(Member member, Product product, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.IIIllIlI.findList(member, product, isShow, count, filters, orders);
  }
  
  @Transactional(readOnly=true)
  public Page<Consultation> findPage(Member member, Product product, Boolean isShow, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, product, isShow, pageable);
  }
  
  @Transactional(readOnly=true)
  public Long count(Member member, Product product, Boolean isShow)
  {
    return this.IIIllIlI.count(member, product, isShow);
  }
  
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void reply(Consultation consultation, Consultation replyConsultation)
  {
    if ((consultation == null) || (replyConsultation == null)) {
      return;
    }
    consultation.setIsShow(Boolean.valueOf(true));
    this.IIIllIlI.merge(consultation);
    replyConsultation.setIsShow(Boolean.valueOf(true));
    replyConsultation.setProduct(consultation.getProduct());
    replyConsultation.setForConsultation(consultation);
    this.IIIllIlI.persist(replyConsultation);
    Product localProduct = consultation.getProduct();
    if (localProduct != null)
    {
      this.IIIllIlI.flush();
      this.IIIllIll.build(localProduct);
    }
  }
  
  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void save(Consultation consultation)
  {
    super.save(consultation);
    Product localProduct = consultation.getProduct();
    if (localProduct != null)
    {
      this.IIIllIlI.flush();
      this.IIIllIll.build(localProduct);
    }
  }
  
  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Consultation update(Consultation consultation)
  {
    Consultation localConsultation = (Consultation)super.update(consultation);
    Product localProduct = localConsultation.getProduct();
    if (localProduct != null)
    {
      this.IIIllIlI.flush();
      this.IIIllIll.build(localProduct);
    }
    return localConsultation;
  }
  
  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Consultation update(Consultation consultation, String... ignoreProperties)
  {
    return (Consultation)super.update(consultation, ignoreProperties);
  }
  
  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }
  
  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void delete(Long... ids)
  {
    super.delete(ids);
  }
  
  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void delete(Consultation consultation)
  {
    if (consultation != null)
    {
      super.delete(consultation);
      Product localProduct = consultation.getProduct();
      if (localProduct != null)
      {
        this.IIIllIlI.flush();
        this.IIIllIll.build(localProduct);
      }
    }
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.ConsultationServiceImpl
 * JD-Core Version:    0.7.0.1
 */
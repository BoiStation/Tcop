package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.SeoDao;
import com.tcop.entity.Seo;
import com.tcop.entity.Seo.Type;
import com.tcop.service.SeoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("seoServiceImpl")
public class SeoServiceImpl
  extends BaseServiceImpl<Seo, Long>
  implements SeoService
{
  @Resource(name="seoDaoImpl")
  private SeoDao IIIllIlI;
  
  @Resource(name="seoDaoImpl")
  public void setBaseDao(SeoDao seoDao)
  {
    super.setBaseDao(seoDao);
  }
  
  @Transactional(readOnly=true)
  public Seo find(Seo.Type type)
  {
    return this.IIIllIlI.find(type);
  }
  
  @Transactional(readOnly=true)
  @Cacheable({"seo"})
  public Seo find(Seo.Type type, String cacheRegion)
  {
    return this.IIIllIlI.find(type);
  }
  
  @Transactional
  @CacheEvict(value={"seo"}, allEntries=true)
  public void save(Seo seo)
  {
    super.save(seo);
  }
  
  @Transactional
  @CacheEvict(value={"seo"}, allEntries=true)
  public Seo update(Seo seo)
  {
    return (Seo)super.update(seo);
  }
  
  @Transactional
  @CacheEvict(value={"seo"}, allEntries=true)
  public Seo update(Seo seo, String... ignoreProperties)
  {
    return (Seo)super.update(seo, ignoreProperties);
  }
  
  @Transactional
  @CacheEvict(value={"seo"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }
  
  @Transactional
  @CacheEvict(value={"seo"}, allEntries=true)
  public void delete(Long... ids)
  {
    super.delete(ids);
  }
  
  @Transactional
  @CacheEvict(value={"seo"}, allEntries=true)
  public void delete(Seo seo)
  {
    super.delete(seo);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.SeoServiceImpl
 * JD-Core Version:    0.7.0.1
 */
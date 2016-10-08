package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.AdDao;
import com.tcop.entity.Ad;
import com.tcop.service.AdService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adServiceImpl")
public class AdServiceImpl
  extends BaseServiceImpl<Ad, Long>
  implements AdService
{
  @Resource(name="adDaoImpl")
  public void setBaseDao(AdDao adDao)
  {
    super.setBaseDao(adDao);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void save(Ad ad)
  {
    super.save(ad);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public Ad update(Ad ad)
  {
    return (Ad)super.update(ad);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public Ad update(Ad ad, String... ignoreProperties)
  {
    return (Ad)super.update(ad, ignoreProperties);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void delete(Long... ids)
  {
    super.delete(ids);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void delete(Ad ad)
  {
    super.delete(ad);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.AdServiceImpl
 * JD-Core Version:    0.7.0.1
 */
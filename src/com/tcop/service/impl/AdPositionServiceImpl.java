package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.AdPositionDao;
import com.tcop.entity.AdPosition;
import com.tcop.service.AdPositionService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adPositionServiceImpl")
public class AdPositionServiceImpl
  extends BaseServiceImpl<AdPosition, Long>
  implements AdPositionService
{
  @Resource(name="adPositionDaoImpl")
  private AdPositionDao IIIllIlI;
  
  @Resource(name="adPositionDaoImpl")
  public void setBaseDao(AdPositionDao adPositionDao)
  {
    super.setBaseDao(adPositionDao);
  }
  
  @Transactional(readOnly=true)
  @Cacheable({"adPosition"})
  public AdPosition find(Long id, String cacheRegion)
  {
    return (AdPosition)this.IIIllIlI.find(id);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void save(AdPosition adPosition)
  {
    super.save(adPosition);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public AdPosition update(AdPosition adPosition)
  {
    return (AdPosition)super.update(adPosition);
  }
  
  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public AdPosition update(AdPosition adPosition, String... ignoreProperties)
  {
    return (AdPosition)super.update(adPosition, ignoreProperties);
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
  public void delete(AdPosition adPosition)
  {
    super.delete(adPosition);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.AdPositionServiceImpl
 * JD-Core Version:    0.7.0.1
 */
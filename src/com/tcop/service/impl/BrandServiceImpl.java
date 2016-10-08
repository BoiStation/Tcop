package com.tcop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.dao.BrandDao;
import com.tcop.entity.Brand;
import com.tcop.service.BrandService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("brandServiceImpl")
public class BrandServiceImpl
  extends BaseServiceImpl<Brand, Long>
  implements BrandService
{
  @Resource(name="brandDaoImpl")
  private BrandDao IIIllIlI;
  
  @Resource(name="brandDaoImpl")
  public void setBaseDao(BrandDao brandDao)
  {
    super.setBaseDao(brandDao);
  }
  
  @Transactional(readOnly=true)
  @Cacheable({"brand"})
  public List<Brand> findList(Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.IIIllIlI.findList(null, count, filters, orders);
  }
  
  @Transactional
  @CacheEvict(value={"brand"}, allEntries=true)
  public void save(Brand brand)
  {
    super.save(brand);
  }
  
  @Transactional
  @CacheEvict(value={"brand"}, allEntries=true)
  public Brand update(Brand brand)
  {
    return (Brand)super.update(brand);
  }
  
  @Transactional
  @CacheEvict(value={"brand"}, allEntries=true)
  public Brand update(Brand brand, String... ignoreProperties)
  {
    return (Brand)super.update(brand, ignoreProperties);
  }
  
  @Transactional
  @CacheEvict(value={"brand"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }
  
  @Transactional
  @CacheEvict(value={"brand"}, allEntries=true)
  public void delete(Long... ids)
  {
    super.delete(ids);
  }
  
  @Transactional
  @CacheEvict(value={"brand"}, allEntries=true)
  public void delete(Brand brand)
  {
    super.delete(brand);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.BrandServiceImpl
 * JD-Core Version:    0.7.0.1
 */
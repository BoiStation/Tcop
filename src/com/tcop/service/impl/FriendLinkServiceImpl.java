package com.tcop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.dao.FriendLinkDao;
import com.tcop.entity.FriendLink;
import com.tcop.entity.FriendLink.Type;
import com.tcop.service.FriendLinkService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("friendLinkServiceImpl")
public class FriendLinkServiceImpl
  extends BaseServiceImpl<FriendLink, Long>
  implements FriendLinkService
{
  @Resource(name="friendLinkDaoImpl")
  public FriendLinkDao friendLinkDao;
  
  @Resource(name="friendLinkDaoImpl")
  public void setBaseDao(FriendLinkDao friendLinkDao)
  {
    super.setBaseDao(friendLinkDao);
  }
  
  @Transactional(readOnly=true)
  public List<FriendLink> findList(FriendLink.Type type)
  {
    return this.friendLinkDao.findList(type);
  }
  
  @Transactional(readOnly=true)
  @Cacheable({"friendLink"})
  public List<FriendLink> findList(Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.friendLinkDao.findList(null, count, filters, orders);
  }
  
  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void save(FriendLink friendLink)
  {
    super.save(friendLink);
  }
  
  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public FriendLink update(FriendLink friendLink)
  {
    return (FriendLink)super.update(friendLink);
  }
  
  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public FriendLink update(FriendLink friendLink, String... ignoreProperties)
  {
    return (FriendLink)super.update(friendLink, ignoreProperties);
  }
  
  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }
  
  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void delete(Long... ids)
  {
    super.delete(ids);
  }
  
  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void delete(FriendLink friendLink)
  {
    super.delete(friendLink);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.FriendLinkServiceImpl
 * JD-Core Version:    0.7.0.1
 */
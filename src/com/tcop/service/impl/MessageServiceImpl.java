package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.MessageDao;
import com.tcop.entity.Member;
import com.tcop.entity.Message;
import com.tcop.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("messageServiceImpl")
public class MessageServiceImpl
  extends BaseServiceImpl<Message, Long>
  implements MessageService
{
  @Resource(name="messageDaoImpl")
  private MessageDao IIIllIlI;
  
  @Resource(name="messageDaoImpl")
  public void setBaseDao(MessageDao messageDao)
  {
    super.setBaseDao(messageDao);
  }
  
  @Transactional(readOnly=true)
  public Page<Message> findPage(Member member, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, pageable);
  }
  
  @Transactional(readOnly=true)
  public Page<Message> findDraftPage(Member sender, Pageable pageable)
  {
    return this.IIIllIlI.findDraftPage(sender, pageable);
  }
  
  @Transactional(readOnly=true)
  public Long count(Member member, Boolean read)
  {
    return this.IIIllIlI.count(member, read);
  }
  
  public void delete(Long id, Member member)
  {
    this.IIIllIlI.remove(id, member);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.MessageServiceImpl
 * JD-Core Version:    0.7.0.1
 */
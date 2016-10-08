package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.ReceiverDao;
import com.tcop.entity.Member;
import com.tcop.entity.Receiver;
import com.tcop.service.ReceiverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("receiverServiceImpl")
public class ReceiverServiceImpl extends BaseServiceImpl<Receiver, Long>  implements ReceiverService
{
  @Resource(name="receiverDaoImpl")
  private ReceiverDao IIIllIlI;
  
  @Resource(name="receiverDaoImpl")
  public void setBaseDao(ReceiverDao receiverDao)
  {
    super.setBaseDao(receiverDao);
  }
  
  @Transactional(readOnly=true)
  public Receiver findDefault(Member member)
  {
    return this.IIIllIlI.findDefault(member);
  }
  
  @Transactional(readOnly=true)
  public Page<Receiver> findPage(Member member, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, pageable);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.ReceiverServiceImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.DepositDao;
import com.tcop.entity.Deposit;
import com.tcop.entity.Member;
import com.tcop.service.DepositService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("depositServiceImpl")
public class DepositServiceImpl
  extends BaseServiceImpl<Deposit, Long>
  implements DepositService
{
  @Resource(name="depositDaoImpl")
  private DepositDao IIIllIlI;
  
  @Resource(name="depositDaoImpl")
  public void setBaseDao(DepositDao depositDao)
  {
    super.setBaseDao(depositDao);
  }
  
  @Transactional(readOnly=true)
  public Page<Deposit> findPage(Member member, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, pageable);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.DepositServiceImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.service.impl;

import java.math.BigDecimal;
import javax.annotation.Resource;
import com.tcop.dao.MemberRankDao;
import com.tcop.entity.MemberRank;
import com.tcop.service.MemberRankService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberRankServiceImpl")
public class MemberRankServiceImpl
  extends BaseServiceImpl<MemberRank, Long>
  implements MemberRankService
{
  @Resource(name="memberRankDaoImpl")
  private MemberRankDao IIIllIlI;
  
  @Resource(name="memberRankDaoImpl")
  public void setBaseDao(MemberRankDao memberRankDao)
  {
    super.setBaseDao(memberRankDao);
  }
  
  @Transactional(readOnly=true)
  public boolean nameExists(String name)
  {
    return this.IIIllIlI.nameExists(name);
  }
  
  @Transactional(readOnly=true)
  public boolean nameUnique(String previousName, String currentName)
  {
    if (StringUtils.equalsIgnoreCase(previousName, currentName)) {
      return true;
    }
    return !this.IIIllIlI.nameExists(currentName);
  }
  
  @Transactional(readOnly=true)
  public boolean amountExists(BigDecimal amount)
  {
    return this.IIIllIlI.amountExists(amount);
  }
  
  @Transactional(readOnly=true)
  public boolean amountUnique(BigDecimal previousAmount, BigDecimal currentAmount)
  {
    if ((previousAmount != null) && (previousAmount.compareTo(currentAmount) == 0)) {
      return true;
    }
    return !this.IIIllIlI.amountExists(currentAmount);
  }
  
  @Transactional(readOnly=true)
  public MemberRank findDefault()
  {
    return this.IIIllIlI.findDefault();
  }
  
  @Transactional(readOnly=true)
  public MemberRank findByAmount(BigDecimal amount)
  {
    return this.IIIllIlI.findByAmount(amount);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.MemberRankServiceImpl
 * JD-Core Version:    0.7.0.1
 */
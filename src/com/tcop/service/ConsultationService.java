package com.tcop.service;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Consultation;
import com.tcop.entity.Member;
import com.tcop.entity.Product;

public abstract interface ConsultationService
  extends BaseService<Consultation, Long>
{
  public abstract List<Consultation> findList(Member paramMember, Product paramProduct, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);
  
  public abstract List<Consultation> findList(Member paramMember, Product paramProduct, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
  
  public abstract Page<Consultation> findPage(Member paramMember, Product paramProduct, Boolean paramBoolean, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Product paramProduct, Boolean paramBoolean);
  
  public abstract void reply(Consultation paramConsultation1, Consultation paramConsultation2);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.ConsultationService
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.service;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.Review;
import com.tcop.entity.Review.Type;

public abstract interface ReviewService
  extends BaseService<Review, Long>
{
  public abstract List<Review> findList(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);
  
  public abstract List<Review> findList(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
  
  public abstract Page<Review> findPage(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean);
  
  public abstract boolean isReviewed(Member paramMember, Product paramProduct);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.ReviewService
 * JD-Core Version:    0.7.0.1
 */
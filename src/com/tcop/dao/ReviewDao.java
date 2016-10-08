package com.tcop.dao;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.Review;
import com.tcop.entity.Review.Type;

public abstract interface ReviewDao
  extends BaseDao<Review, Long>
{
  public abstract List<Review> findList(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);
  
  public abstract Page<Review> findPage(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean);
  
  public abstract boolean isReviewed(Member paramMember, Product paramProduct);
  
  public abstract long calculateTotalScore(Product paramProduct);
  
  public abstract long calculateScoreCount(Product paramProduct);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.ReviewDao
 * JD-Core Version:    0.7.0.1
 */
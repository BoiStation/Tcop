package com.tcop.service;

import java.util.Date;
import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Article;
import com.tcop.entity.ArticleCategory;
import com.tcop.entity.Tag;

public abstract interface ArticleService
  extends BaseService<Article, Long>
{
  public abstract List<Article> findList(ArticleCategory paramArticleCategory, List<Tag> paramList, Integer paramInteger, List<Filter> paramList1, List<Order> paramList2);
  
  public abstract List<Article> findList(ArticleCategory paramArticleCategory, List<Tag> paramList, Integer paramInteger, List<Filter> paramList1, List<Order> paramList2, String paramString);
  
  public abstract List<Article> findList(ArticleCategory paramArticleCategory, Date paramDate1, Date paramDate2, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Page<Article> findPage(ArticleCategory paramArticleCategory, List<Tag> paramList, Pageable paramPageable);
  
  public abstract long viewHits(Long paramLong);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.ArticleService
 * JD-Core Version:    0.7.0.1
 */
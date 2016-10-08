package com.tcop.service;

import java.math.BigDecimal;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Article;
import com.tcop.entity.Product;
import com.tcop.entity.Product.OrderType;

public abstract interface SearchService
{
  public abstract void index();
  
  public abstract void index(Class<?> paramClass);
  
  public abstract void index(Article paramArticle);
  
  public abstract void index(Product paramProduct);
  
  public abstract void purge();
  
  public abstract void purge(Class<?> paramClass);
  
  public abstract void purge(Article paramArticle);
  
  public abstract void purge(Product paramProduct);
  
  public abstract Page<Article> search(String paramString, Pageable paramPageable);
  
  public abstract Page<Product> search(String paramString, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Product.OrderType paramOrderType, Pageable paramPageable);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.SearchService
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.dao;

import java.util.List;
import com.tcop.entity.ArticleCategory;

public abstract interface ArticleCategoryDao
  extends BaseDao<ArticleCategory, Long>
{
  public abstract List<ArticleCategory> findRoots(Integer paramInteger);
  
  public abstract List<ArticleCategory> findParents(ArticleCategory paramArticleCategory, Integer paramInteger);
  
  public abstract List<ArticleCategory> findChildren(ArticleCategory paramArticleCategory, Integer paramInteger);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.ArticleCategoryDao
 * JD-Core Version:    0.7.0.1
 */
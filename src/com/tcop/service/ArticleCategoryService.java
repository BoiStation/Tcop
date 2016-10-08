package com.tcop.service;

import java.util.List;
import com.tcop.entity.ArticleCategory;

public abstract interface ArticleCategoryService
  extends BaseService<ArticleCategory, Long>
{
  public abstract List<ArticleCategory> findRoots();
  
  public abstract List<ArticleCategory> findRoots(Integer paramInteger);
  
  public abstract List<ArticleCategory> findRoots(Integer paramInteger, String paramString);
  
  public abstract List<ArticleCategory> findParents(ArticleCategory paramArticleCategory);
  
  public abstract List<ArticleCategory> findParents(ArticleCategory paramArticleCategory, Integer paramInteger);
  
  public abstract List<ArticleCategory> findParents(ArticleCategory paramArticleCategory, Integer paramInteger, String paramString);
  
  public abstract List<ArticleCategory> findTree();
  
  public abstract List<ArticleCategory> findChildren(ArticleCategory paramArticleCategory);
  
  public abstract List<ArticleCategory> findChildren(ArticleCategory paramArticleCategory, Integer paramInteger);
  
  public abstract List<ArticleCategory> findChildren(ArticleCategory paramArticleCategory, Integer paramInteger, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.ArticleCategoryService
 * JD-Core Version:    0.7.0.1
 */
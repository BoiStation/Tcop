package com.tcop.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.tcop.entity.Article;
import com.tcop.entity.ArticleCategory;
import com.tcop.service.ArticleCategoryService;
import com.tcop.service.ArticleService;
import com.tcop.service.TagService;
import com.tcop.util.FreemarkerUtils;
import org.springframework.stereotype.Component;

@Component("articleListDirective")
public class ArticleListDirective
  extends BaseDirective
{
  private static final String IIIllIlI = "articleCategoryId";
  private static final String IIIllIll = "tagIds";
  private static final String IIIlllII = "articles";
  @Resource(name="articleServiceImpl")
  private ArticleService IIIlllIl;
  @Resource(name="articleCategoryServiceImpl")
  private ArticleCategoryService IIIllllI;
  @Resource(name="tagServiceImpl")
  private TagService IIIlllll;
  
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    Long localLong = (Long)FreemarkerUtils.getParameter("articleCategoryId", Long.class, params);
    Long[] arrayOfLong = (Long[])FreemarkerUtils.getParameter("tagIds", Long[].class, params);
    ArticleCategory localArticleCategory = (ArticleCategory)this.IIIllllI.find(localLong);
    List localList1 = this.IIIlllll.findList(arrayOfLong);
    Object localObject;
    if (((localLong != null) && (localArticleCategory == null)) || ((arrayOfLong != null) && (localList1.isEmpty())))
    {
      localObject = new ArrayList();
    }
    else
    {
      boolean bool = IIIllIlI(env, params);
      String str = IIIllIll(env, params);
      Integer localInteger = IIIllIll(params);
      List localList2 = IIIllIlI(params, Article.class, new String[0]);
      List localList3 = IIIllIlI(params, new String[0]);
      if (bool) {
        localObject = this.IIIlllIl.findList(localArticleCategory, localList1, localInteger, localList2, localList3, str);
      } else {
        localObject = this.IIIlllIl.findList(localArticleCategory, localList1, localInteger, localList2, localList3);
      }
    }
    IIIllIlI("articles", localObject, env, body);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.template.directive.ArticleListDirective
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.tcop.service.ArticleCategoryService;
import org.springframework.stereotype.Component;

@Component("articleCategoryRootListDirective")
public class ArticleCategoryRootListDirective
  extends BaseDirective
{
  private static final String IIIllIlI = "articleCategories";
  @Resource(name="articleCategoryServiceImpl")
  private ArticleCategoryService IIIllIll;
  
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    boolean bool = IIIllIlI(env, params);
    String str = IIIllIll(env, params);
    Integer localInteger = IIIllIll(params);
    List localList;
    if (bool) {
      localList = this.IIIllIll.findRoots(localInteger, str);
    } else {
      localList = this.IIIllIll.findRoots(localInteger);
    }
    IIIllIlI("articleCategories", localList, env, body);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.template.directive.ArticleCategoryRootListDirective
 * JD-Core Version:    0.7.0.1
 */
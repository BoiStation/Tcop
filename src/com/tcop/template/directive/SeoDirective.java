package com.tcop.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.Map;
import javax.annotation.Resource;
import com.tcop.entity.Seo;
import com.tcop.entity.Seo.Type;
import com.tcop.service.SeoService;
import com.tcop.util.FreemarkerUtils;
import org.springframework.stereotype.Component;

@Component("seoDirective")
public class SeoDirective
  extends BaseDirective
{
  private static final String IIIllIlI = "type";
  private static final String IIIllIll = "seo";
  @Resource(name="seoServiceImpl")
  private SeoService IIIlllII;
  
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    Seo.Type localType = (Seo.Type)FreemarkerUtils.getParameter("type", Seo.Type.class, params);
    boolean bool = IIIllIlI(env, params);
    String str = IIIllIll(env, params);
    Seo localSeo;
    if (bool) {
      localSeo = this.IIIlllII.find(localType, str);
    } else {
      localSeo = this.IIIlllII.find(localType);
    }
    IIIllIlI("seo", localSeo, env, body);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.template.directive.SeoDirective
 * JD-Core Version:    0.7.0.1
 */
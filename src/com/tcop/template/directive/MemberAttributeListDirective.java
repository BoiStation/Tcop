package com.tcop.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.tcop.service.MemberAttributeService;
import org.springframework.stereotype.Component;

@Component("memberAttributeListDirective")
public class MemberAttributeListDirective
  extends BaseDirective
{
  private static final String IIIllIlI = "memberAttributes";
  @Resource(name="memberAttributeServiceImpl")
  private MemberAttributeService IIIllIll;
  
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    boolean bool = IIIllIlI(env, params);
    String str = IIIllIll(env, params);
    List localList;
    if (bool) {
      localList = this.IIIllIll.findList(str);
    } else {
      localList = this.IIIllIll.findList();
    }
    IIIllIlI("memberAttributes", localList, env, body);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.template.directive.MemberAttributeListDirective
 * JD-Core Version:    0.7.0.1
 */
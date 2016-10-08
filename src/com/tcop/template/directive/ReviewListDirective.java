package com.tcop.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.Review;
import com.tcop.entity.Review.Type;
import com.tcop.service.MemberService;
import com.tcop.service.ProductService;
import com.tcop.service.ReviewService;
import com.tcop.util.FreemarkerUtils;
import org.springframework.stereotype.Component;

@Component("reviewListDirective")
public class ReviewListDirective
  extends BaseDirective
{
  private static final String IIIllIlI = "memberId";
  private static final String IIIllIll = "productId";
  private static final String IIIlllII = "type";
  private static final String IIIlllIl = "reviews";
  @Resource(name="reviewServiceImpl")
  private ReviewService IIIllllI;
  @Resource(name="memberServiceImpl")
  private MemberService IIIlllll;
  @Resource(name="productServiceImpl")
  private ProductService IIlIIIII;
  
  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    Long localLong1 = (Long)FreemarkerUtils.getParameter("memberId", Long.class, params);
    Long localLong2 = (Long)FreemarkerUtils.getParameter("productId", Long.class, params);
    Review.Type localType = (Review.Type)FreemarkerUtils.getParameter("type", Review.Type.class, params);
    Member localMember = (Member)this.IIIlllll.find(localLong1);
    Product localProduct = (Product)this.IIlIIIII.find(localLong2);
    Object localObject;
    if (((localLong1 != null) && (localMember == null)) || ((localLong2 != null) && (localProduct == null)))
    {
      localObject = new ArrayList();
    }
    else
    {
      boolean bool = IIIllIlI(env, params);
      String str = IIIllIll(env, params);
      Integer localInteger = IIIllIll(params);
      List localList1 = IIIllIlI(params, Review.class, new String[0]);
      List localList2 = IIIllIlI(params, new String[0]);
      if (bool) {
        localObject = this.IIIllllI.findList(localMember, localProduct, localType, Boolean.valueOf(true), localInteger, localList1, localList2, str);
      } else {
        localObject = this.IIIllllI.findList(localMember, localProduct, localType, Boolean.valueOf(true), localInteger, localList1, localList2);
      }
    }
    IIIllIlI("reviews", localObject, env, body);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.template.directive.ReviewListDirective
 * JD-Core Version:    0.7.0.1
 */
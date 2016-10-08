package com.tcop.controller.shop;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.ProductNotify;
import com.tcop.service.MemberService;
import com.tcop.service.ProductNotifyService;
import com.tcop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopProductNotifyController")
@RequestMapping({"/product_notify"})
public class ProductNotifyController
  extends BaseController
{
  @Resource(name="productNotifyServiceImpl")
  private ProductNotifyService IIIlllIl;
  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;
  @Resource(name="productServiceImpl")
  private ProductService IIIlllll;
  
  @RequestMapping(value={"/email"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Map<String, String> email()
  {
    Member localMember = this.IIIllllI.getCurrent();
    Object localObject = localMember != null ? localMember.getEmail() : null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("email", localObject);
    return localHashMap;
  }
  
  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Map<String, Object> save(String email, Long productId)
  {
    HashMap localHashMap = new HashMap();
    if (!validateValue(ProductNotify.class, "email", email, new Class[0]))
    {
      localHashMap.put("message", MESSAGE_ERROR);
      return localHashMap;
    }
    Product localProduct = (Product)this.IIIlllll.find(productId);
    if (localProduct == null)
    {
      localHashMap.put("message", Message.warn("shop.productNotify.productNotExist", new Object[0]));
      return localHashMap;
    }
    if (!localProduct.getIsMarketable().booleanValue())
    {
      localHashMap.put("message", Message.warn("shop.productNotify.productNotMarketable", new Object[0]));
      return localHashMap;
    }
    if (!localProduct.getIsOutOfStock().booleanValue()) {
      localHashMap.put("message", Message.warn("shop.productNotify.productInStock", new Object[0]));
    }
    if (this.IIIlllIl.exists(localProduct, email))
    {
      localHashMap.put("message", Message.warn("shop.productNotify.exist", new Object[0]));
    }
    else
    {
      ProductNotify localProductNotify = new ProductNotify();
      localProductNotify.setEmail(email);
      localProductNotify.setHasSent(Boolean.valueOf(false));
      localProductNotify.setMember(this.IIIllllI.getCurrent());
      localProductNotify.setProduct(localProduct);
      this.IIIlllIl.save(localProductNotify);
      localHashMap.put("message", MESSAGE_SUCCESS);
    }
    return localHashMap;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.ProductNotifyController
 * JD-Core Version:    0.7.0.1
 */
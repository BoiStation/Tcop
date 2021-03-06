package com.tcop.controller.shop;

import javax.annotation.Resource;
import com.tcop.ResourceNotFoundException;
import com.tcop.entity.Promotion;
import com.tcop.service.PromotionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopPromotionController")
@RequestMapping({"/promotion"})
public class PromotionController
  extends BaseController
{
  @Resource(name="promotionServiceImpl")
  private PromotionService IIIlllIl;
  
  @RequestMapping(value={"/content/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String content(@PathVariable Long id, ModelMap model)
  {
    Promotion localPromotion = (Promotion)this.IIIlllIl.find(id);
    if (localPromotion == null) {
      throw new ResourceNotFoundException();
    }
    model.addAttribute("promotion", localPromotion);
    return "/shop/promotion/content";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.PromotionController
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.controller.shop;

import javax.annotation.Resource;
import com.tcop.Pageable;
import com.tcop.ResourceNotFoundException;
import com.tcop.entity.Brand;
import com.tcop.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopBrandController")
@RequestMapping({"/brand"})
public class BrandController
  extends BaseController
{
  private static final int IIIlllIl = 40;
  @Resource(name="brandServiceImpl")
  private BrandService IIIllllI;
  
  @RequestMapping(value={"/list/{pageNumber}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(@PathVariable Integer pageNumber, ModelMap model)
  {
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(40));
    model.addAttribute("page", this.IIIllllI.findPage(localPageable));
    return "/shop/brand/list";
  }
  
  @RequestMapping(value={"/content/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String content(@PathVariable Long id, ModelMap model)
  {
    Brand localBrand = (Brand)this.IIIllllI.find(id);
    if (localBrand == null) {
      throw new ResourceNotFoundException();
    }
    model.addAttribute("brand", localBrand);
    return "/shop/brand/content";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.BrandController
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.controller.shop;

import javax.annotation.Resource;
import com.tcop.Pageable;
import com.tcop.ResourceNotFoundException;
import com.tcop.entity.ArticleCategory;
import com.tcop.service.ArticleCategoryService;
import com.tcop.service.ArticleService;
import com.tcop.service.SearchService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopArticleController")
@RequestMapping({"/article"})
public class ArticleController
  extends BaseController
{
  private static final int IIIlllIl = 20;
  @Resource(name="articleServiceImpl")
  private ArticleService IIIllllI;
  @Resource(name="articleCategoryServiceImpl")
  private ArticleCategoryService IIIlllll;
  @Resource(name="searchServiceImpl")
  private SearchService IIlIIIII;
  
  @RequestMapping(value={"/list/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(@PathVariable Long id, Integer pageNumber, ModelMap model)
  {
    ArticleCategory localArticleCategory = (ArticleCategory)this.IIIlllll.find(id);
    if (localArticleCategory == null) {
      throw new ResourceNotFoundException();
    }
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(20));
    model.addAttribute("articleCategory", localArticleCategory);
    model.addAttribute("page", this.IIIllllI.findPage(localArticleCategory, null, localPageable));
    return "/shop/article/list";
  }
  
  @RequestMapping(value={"/search"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String search(String keyword, Integer pageNumber, ModelMap model)
  {
    if (StringUtils.isEmpty(keyword)) {
      return "/shop/common/error";
    }
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(20));
    model.addAttribute("articleKeyword", keyword);
    model.addAttribute("page", this.IIlIIIII.search(keyword, localPageable));
    return "shop/article/search";
  }
  
  @RequestMapping(value={"/hits/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Long hits(@PathVariable Long id)
  {
    return Long.valueOf(this.IIIllllI.viewHits(id));
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.ArticleController
 * JD-Core Version:    0.7.0.1
 */
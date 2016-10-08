package com.tcop.controller.admin;

import java.util.HashSet;
import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.entity.Article;
import com.tcop.entity.ArticleCategory;
import com.tcop.entity.Tag;
import com.tcop.service.ArticleCategoryService;
import com.tcop.service.ArticleService;
import com.tcop.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminArticleController")
@RequestMapping({"/admin/article"})
public class ArticleController
  extends BaseController
{
  @Resource(name="articleServiceImpl")
  private ArticleService IIIlllIl;
  @Resource(name="articleCategoryServiceImpl")
  private ArticleCategoryService IIIllllI;
  @Resource(name="tagServiceImpl")
  private TagService IIIlllll;
  
  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("articleCategoryTree", this.IIIllllI.findTree());
    model.addAttribute("tags", this.IIIlllll.findList(Tag.Type.article));
    return "/admin/article/add";
  }
  
  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Article article, Long articleCategoryId, Long[] tagIds, RedirectAttributes redirectAttributes)
  {
    article.setArticleCategory((ArticleCategory)this.IIIllllI.find(articleCategoryId));
    article.setTags(new HashSet(this.IIIlllll.findList(tagIds)));
    if (!IIIllIlI(article, new Class[0])) {
      return "/admin/common/error";
    }
    article.setHits(Long.valueOf(0L));
    article.setPageNumber(null);
    this.IIIlllIl.save(article);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }
  
  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("articleCategoryTree", this.IIIllllI.findTree());
    model.addAttribute("tags", this.IIIlllll.findList(Tag.Type.article));
    model.addAttribute("article", this.IIIlllIl.find(id));
    return "/admin/article/edit";
  }
  
  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Article article, Long articleCategoryId, Long[] tagIds, RedirectAttributes redirectAttributes)
  {
    article.setArticleCategory((ArticleCategory)this.IIIllllI.find(articleCategoryId));
    article.setTags(new HashSet(this.IIIlllll.findList(tagIds)));
    if (!IIIllIlI(article, new Class[0])) {
      return "/admin/common/error";
    }
    this.IIIlllIl.update(article, new String[] { "hits", "pageNumber" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/article/list";
  }
  
  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.ArticleController
 * JD-Core Version:    0.7.0.1
 */
package com.tcop.controller.admin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.tcop.entity.Article;
import com.tcop.entity.Product;
import com.tcop.service.ArticleService;
import com.tcop.service.ProductService;
import com.tcop.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminIndexController")
@RequestMapping({"/admin/index"})
public class IndexController
  extends BaseController
{
  @Resource(name="articleServiceImpl")
  private ArticleService articleServiceImpl;
  @Resource(name="productServiceImpl")
  private ProductService IIIllllI;
  @Resource(name="searchServiceImpl")
  private SearchService searchService;
  
  @RequestMapping(value={"/build"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String build(ModelMap model)
  {
    model.addAttribute("buildTypes", IndexController.BuildType.values());
    return "/admin/index/build";
  }
  
  @RequestMapping(value={"/build"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Map<String, Object> build(IndexController.BuildType buildType, Boolean isPurge, Integer first, Integer count){
  
	long l1 = System.currentTimeMillis();
    if ((first == null) || (first.intValue() < 0)) {
      first = Integer.valueOf(0);
    }
    if ((count == null) || (count.intValue() <= 0)) {
      count = Integer.valueOf(50);
    }
    int i = 0;
    boolean bool = true;
    List localList;
    Object localObject1;
    if (buildType == IndexController.BuildType.article)
    {
      if ((first.intValue() == 0) && (isPurge != null) && (isPurge.booleanValue())) {
        this.searchService.purge(Article.class);
      }
      localList = this.articleServiceImpl.findList(null, null, null, first, count);
      Iterator localObject2 = localList.iterator();
      while(localObject2.hasNext()) {
        localObject1 = (Article)localObject2.next();
        this.searchService.index((Article)localObject1);
        i++;
      }
      first = Integer.valueOf(first.intValue() + localList.size());
      if (localList.size() == count.intValue()) {
        bool = false;
      }
    }
    else if (buildType == IndexController.BuildType.product)
    {
      if ((first.intValue() == 0) && (isPurge != null) && (isPurge.booleanValue())) {
        this.searchService.purge(Product.class);
      }
      localList = this.IIIllllI.findList(null, null, null, first, count);
      Iterator localObject2 = localList.iterator();
      while (localObject2.hasNext())
      {
        localObject1 = (Product)localObject2.next();
        this.searchService.index((Product)localObject1);
        i++;
      }
      first = Integer.valueOf(first.intValue() + localList.size());
      if (localList.size() == count.intValue()) {
        bool = false;
      }
    }
    long l2 = System.currentTimeMillis();
    Map<String, Object> localObject2 = new HashMap();
    ((Map)localObject2).put("first", first);
    ((Map)localObject2).put("buildCount", Integer.valueOf(i));
    ((Map)localObject2).put("buildTime", Long.valueOf(l2 - l1));
    ((Map)localObject2).put("isCompleted", Boolean.valueOf(bool));
    return localObject2;
  }
  
  public enum BuildType
  {
    article,  product;
  }
  
}
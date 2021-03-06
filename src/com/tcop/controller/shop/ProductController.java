package com.tcop.controller.shop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.tcop.Pageable;
import com.tcop.ResourceNotFoundException;
import com.tcop.entity.Attribute;
import com.tcop.entity.Brand;
import com.tcop.entity.Product;
import com.tcop.entity.Product.OrderType;
import com.tcop.entity.ProductCategory;
import com.tcop.entity.Promotion;
import com.tcop.service.BrandService;
import com.tcop.service.ProductCategoryService;
import com.tcop.service.ProductService;
import com.tcop.service.PromotionService;
import com.tcop.service.SearchService;
import com.tcop.service.TagService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopProductController")
@RequestMapping({"/product"})
public class ProductController
  extends BaseController
{
  @Resource(name="productServiceImpl")
  private ProductService productService;
  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService productCategoryService;
  @Resource(name="brandServiceImpl")
  private BrandService brandService;
  @Resource(name="promotionServiceImpl")
  private PromotionService promotionService;
  @Resource(name="tagServiceImpl")
  private TagService tagService;
  @Resource(name="searchServiceImpl")
  private SearchService searchService;
  
  @RequestMapping(value={"/history"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public List<Product> history(Long[] ids)
  {
    return this.productService.findList(ids);
  }
  
  @RequestMapping(value={"/list/{productCategoryId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(@PathVariable Long productCategoryId, Long brandId, Long promotionId, Long[] tagIds, 
		  BigDecimal startPrice, BigDecimal endPrice, Product.OrderType orderType, Integer pageNumber, 
		  Integer pageSize, HttpServletRequest request, ModelMap model) {
	  
	//查找产品分类
    ProductCategory productCategory = (ProductCategory)this.productCategoryService.find(productCategoryId);
    if (productCategory == null) {
      throw new ResourceNotFoundException();
    }
    //查找品牌
    Brand brand = (Brand)this.brandService.find(brandId);
    //查找促销信息
    Promotion promotion = (Promotion)this.promotionService.find(promotionId);
    //获取标签
    List localList = this.tagService.findList(tagIds);
    HashMap map = new HashMap();
    if (productCategory != null){
      //获取产品属性xx_attribute
      Set set = productCategory.getAttributes();
      Iterator iterator = set.iterator();
      while (iterator.hasNext()){
        Attribute attribute = (Attribute)iterator.next();
        String str = request.getParameter("attribute_" + attribute.getId());
        if (StringUtils.isNotEmpty(str)) {
          map.put(attribute, str);
        }
      }
    }
    //设置分页
    Pageable pageable = new Pageable(pageNumber, pageSize);
    //设置视图模型对象 http://crunchify.com/spring-mvc-how-to-access-modelmap-values-in-a-jsp/
    model.addAttribute("orderTypes", Product.OrderType.values());
    model.addAttribute("productCategory", productCategory);
    model.addAttribute("brand", brand);
    model.addAttribute("promotion", promotion);
    model.addAttribute("tags", localList);
    model.addAttribute("attributeValue", map);
    model.addAttribute("startPrice", startPrice);
    model.addAttribute("endPrice", endPrice);
    model.addAttribute("orderType", orderType);
    model.addAttribute("pageNumber", pageNumber);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("page", this.productService.findPage(productCategory, brand, promotion, localList, map, startPrice, endPrice, Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(false), null, null, orderType, pageable));
    return "/shop/product/list";
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Long brandId, Long promotionId, Long[] tagIds, BigDecimal startPrice, BigDecimal endPrice, Product.OrderType orderType, Integer pageNumber, Integer pageSize, HttpServletRequest request, ModelMap model)
  {
    Brand localBrand = (Brand)this.brandService.find(brandId);
    Promotion localPromotion = (Promotion)this.promotionService.find(promotionId);
    List localList = this.tagService.findList(tagIds);
    Pageable localPageable = new Pageable(pageNumber, pageSize);
    model.addAttribute("orderTypes", Product.OrderType.values());
    model.addAttribute("brand", localBrand);
    model.addAttribute("promotion", localPromotion);
    model.addAttribute("tags", localList);
    model.addAttribute("startPrice", startPrice);
    model.addAttribute("endPrice", endPrice);
    model.addAttribute("orderType", orderType);
    model.addAttribute("pageNumber", pageNumber);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("page", this.productService.findPage(null, localBrand, localPromotion, localList, null, startPrice, endPrice, Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(false), null, null, orderType, localPageable));
    return "/shop/product/list";
  }
  
  @RequestMapping(value={"/search"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String search(String keyword, BigDecimal startPrice, BigDecimal endPrice, Product.OrderType orderType, Integer pageNumber, Integer pageSize, ModelMap model)
  {
	
	System.out.println("keyword:" + keyword);
	  
    if (StringUtils.isEmpty(keyword)) {
      return "/shop/common/error";
    }
    
    System.out.println("keyword:" + keyword);
    
    Pageable localPageable = new Pageable(pageNumber, pageSize);
    model.addAttribute("orderTypes", Product.OrderType.values());
    model.addAttribute("productKeyword", keyword);
    model.addAttribute("startPrice", startPrice);
    model.addAttribute("endPrice", endPrice);
    model.addAttribute("orderType", orderType);
    model.addAttribute("page", this.searchService.search(keyword, startPrice, endPrice, orderType, localPageable));
    
    return "shop/product/search";
  }
  
  @RequestMapping(value={"/hits/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Long hits(@PathVariable Long id)
  {
    return Long.valueOf(this.productService.viewHits(id));
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.ProductController
 * JD-Core Version:    0.7.0.1
 */
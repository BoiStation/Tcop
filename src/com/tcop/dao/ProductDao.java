package com.tcop.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Attribute;
import com.tcop.entity.Brand;
import com.tcop.entity.Goods;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.entity.Product.OrderType;
import com.tcop.entity.ProductCategory;
import com.tcop.entity.Promotion;
import com.tcop.entity.Tag;

public abstract interface ProductDao
  extends BaseDao<Product, Long>
{
  public abstract boolean snExists(String paramString);
  
  public abstract Product findBySn(String paramString);
  
  public abstract List<Product> search(String paramString, Boolean paramBoolean, Integer paramInteger);
  
  public abstract List<Product> findList(ProductCategory paramProductCategory, Brand paramBrand, Promotion paramPromotion, List<Tag> paramList, Map<Attribute, String> paramMap, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Product.OrderType paramOrderType, Integer paramInteger, List<Filter> paramList1, List<Order> paramList2);
  
  public abstract List<Product> findList(ProductCategory paramProductCategory, Date paramDate1, Date paramDate2, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<Product> findList(Goods paramGoods, Set<Product> paramSet);
  
  public abstract Page<Product> findPage(ProductCategory paramProductCategory, Brand paramBrand, Promotion paramPromotion, List<Tag> paramList, Map<Attribute, String> paramMap, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Product.OrderType paramOrderType, Pageable paramPageable);
  
  public abstract Page<Product> findPage(Member paramMember, Pageable paramPageable);
  
  public abstract Page<Object> findSalesPage(Date paramDate1, Date paramDate2, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6);
  
  public abstract boolean isPurchased(Member paramMember, Product paramProduct);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.ProductDao
 * JD-Core Version:    0.7.0.1
 */
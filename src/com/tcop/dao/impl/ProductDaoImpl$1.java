package com.tcop.dao.impl;

import java.util.Comparator;
import com.tcop.entity.SpecificationValue;
import org.apache.commons.lang.builder.CompareToBuilder;

class ProductDaoImpl$1
  implements Comparator<SpecificationValue>
{
  ProductDaoImpl$1(ProductDaoImpl paramProductDaoImpl) {}
  
  public int compare(SpecificationValue a1, SpecificationValue a2)
  {
    return new CompareToBuilder().append(a1.getSpecification(), a2.getSpecification()).toComparison();
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.impl.ProductDaoImpl.1
 * JD-Core Version:    0.7.0.1
 */
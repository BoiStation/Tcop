package com.tcop.service;

import java.util.List;
import com.tcop.Template;
import com.tcop.Template.Type;

public abstract interface TemplateService
{
  public abstract List<Template> getAll();
  
  public abstract List<Template> getList(Template.Type paramType);
  
  public abstract Template get(String paramString);
  
  public abstract String read(String paramString);
  
  public abstract String read(Template paramTemplate);
  
  public abstract void write(String paramString1, String paramString2);
  
  public abstract void write(Template paramTemplate, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.TemplateService
 * JD-Core Version:    0.7.0.1
 */
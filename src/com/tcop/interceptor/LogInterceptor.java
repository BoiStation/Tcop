package com.tcop.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcop.LogConfig;
import com.tcop.entity.Log;
import com.tcop.service.AdminService;
import com.tcop.service.LogConfigService;
import com.tcop.service.LogService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter
{
  private static final String[] IIIllIlI = { "password", "rePassword", "currentPassword" };
  private static AntPathMatcher IIIllIll = new AntPathMatcher();
  private String[] IIIlllII = IIIllIlI;
  @Resource(name="logConfigServiceImpl")
  private LogConfigService IIIlllIl;
  @Resource(name="logServiceImpl")
  private LogService IIIllllI;
  @Resource(name="adminServiceImpl")
  private AdminService IIIlllll;
  
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
  {
    List localList = this.IIIlllIl.getAll();
    if (localList != null)
    {
      String str1 = request.getServletPath();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        LogConfig localLogConfig = (LogConfig)localIterator1.next();
        if (IIIllIll.match(localLogConfig.getUrlPattern(), str1))
        {
          String str2 = this.IIIlllll.getCurrentUsername();
          String str3 = localLogConfig.getOperation();
          String str4 = str2;
          String str5 = (String)request.getAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME);
          String str6 = request.getRemoteAddr();
          request.removeAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME);
          StringBuffer localStringBuffer = new StringBuffer();
          Map localMap = request.getParameterMap();
          if (localMap != null)
          {
            Iterator localIterator2 = localMap.entrySet().iterator();
            while (localIterator2.hasNext())
            {
              Entry entry = (Map.Entry)localIterator2.next();
              String str7 = (String)(entry).getKey();
              if (!ArrayUtils.contains(this.IIIlllII, str7))
              {
                String[] arrayOfString1 = (String[])(entry).getValue();
                if (arrayOfString1 != null) {
                  for (String str8 : arrayOfString1) {
                    localStringBuffer.append(str7 + " = " + str8 + "\n");
                  }
                }
              }
            }
          }
          Log log = new Log();
          (log).setOperation(str3);
          (log).setOperator(str4);
          (log).setContent(str5);
          (log).setParameter(localStringBuffer.toString());
          (log).setIp(str6);
          this.IIIllllI.save(log);
          break;
        }
      }
    }
  }
  
  public String[] getIgnoreParameters()
  {
    return this.IIIlllII;
  }
  
  public void setIgnoreParameters(String[] ignoreParameters)
  {
    this.IIIlllII = ignoreParameters;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.interceptor.LogInterceptor
 * JD-Core Version:    0.7.0.1
 */
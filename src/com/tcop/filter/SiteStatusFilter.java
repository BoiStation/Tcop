package com.tcop.filter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tcop.Setting;
import com.tcop.util.SettingUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

@Component("siteStatusFilter")
public class SiteStatusFilter extends OncePerRequestFilter
{
  private static final String[] IIIllIlI = { "/admin/**" };
  private static final String IIIllIll = "/common/site_close.jhtml";
  private static AntPathMatcher IIIlllII = new AntPathMatcher();
  private String[] IIIlllIl = IIIllIlI;
  private String IIIllllI = "/common/site_close.jhtml";
  
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
  {
    Setting localSetting = SettingUtils.get();
    try {
    	if (localSetting.getIsSiteEnabled().booleanValue())
        {
          filterChain.doFilter(request, response);
        }
        else
        {
          String str1 = request.getServletPath();
          if (str1.equals(this.IIIllllI))
          {
            filterChain.doFilter(request, response);
            return;
          }
          if (this.IIIlllIl != null) {
            for (String str2 : this.IIIlllIl) {
              if (IIIlllII.match(str2, str1))
              {
                filterChain.doFilter(request, response);
                return;
              }
            }
          }
          response.sendRedirect(request.getContextPath() + this.IIIllllI);
        }
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
  
  public String[] getIgnoreUrlPatterns()
  {
    return this.IIIlllIl;
  }
  
  public void setIgnoreUrlPatterns(String[] ignoreUrlPatterns)
  {
    this.IIIlllIl = ignoreUrlPatterns;
  }
  
  public String getRedirectUrl()
  {
    return this.IIIllllI;
  }
  
  public void setRedirectUrl(String redirectUrl)
  {
    this.IIIllllI = redirectUrl;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.filter.SiteStatusFilter
 * JD-Core Version:    0.7.0.1
 */
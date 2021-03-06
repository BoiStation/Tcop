package com.tcop.controller.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tcop.entity.Member;
import com.tcop.util.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopLogoutController")
public class LogoutController
  extends BaseController
{
  @RequestMapping(value={"/logout"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
  {
    session.removeAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
    CookieUtils.removeCookie(request, response, "username");
    return "redirect:/";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.LogoutController
 * JD-Core Version:    0.7.0.1
 */
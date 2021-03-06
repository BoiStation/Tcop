package com.tcop.controller.shop.member;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.tcop.CommonAttributes;
import com.tcop.Setting;
import com.tcop.controller.shop.BaseController;
import com.tcop.entity.Area;
import com.tcop.entity.Member;
import com.tcop.entity.Member.Gender;
import com.tcop.entity.MemberAttribute;
import com.tcop.entity.MemberAttribute.Type;
import com.tcop.service.AreaService;
import com.tcop.service.MemberAttributeService;
import com.tcop.service.MemberService;
import com.tcop.util.SettingUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("shopMemberProfileController")
@RequestMapping({"/member/profile"})
public class ProfileController
  extends BaseController
{
  @Resource(name="memberServiceImpl")
  private MemberService IIIlllIl;
  @Resource(name="memberAttributeServiceImpl")
  private MemberAttributeService IIIllllI;
  @Resource(name="areaServiceImpl")
  private AreaService IIIlllll;
  
  @RequestMapping(value={"/check_email"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public boolean checkEmail(String email)
  {
    if (StringUtils.isEmpty(email)) {
      return false;
    }
    Member localMember = this.IIIlllIl.getCurrent();
    return this.IIIlllIl.emailUnique(localMember.getEmail(), email);
  }
  
  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(ModelMap model)
  {
    model.addAttribute("genders", Member.Gender.values());
    model.addAttribute("memberAttributes", this.IIIllllI.findList());
    return "shop/member/profile/edit";
  }
  
  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(String email, HttpServletRequest request, RedirectAttributes redirectAttributes)
  {
    if (!validateValue(Member.class, "email", email, new Class[0])) {
      return "/shop/common/error";
    }
    Setting localSetting = SettingUtils.get();
    Member localMember = this.IIIlllIl.getCurrent();
    if ((!localSetting.getIsDuplicateEmail().booleanValue()) && (!this.IIIlllIl.emailUnique(localMember.getEmail(), email))) {
      return "/shop/common/error";
    }
    localMember.setEmail(email);
    List localList = this.IIIllllI.findList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MemberAttribute localMemberAttribute = (MemberAttribute)localIterator.next();
      String str = request.getParameter("memberAttribute_" + localMemberAttribute.getId());
      if ((localMemberAttribute.getType() == MemberAttribute.Type.name) || (localMemberAttribute.getType() == MemberAttribute.Type.address) || (localMemberAttribute.getType() == MemberAttribute.Type.zipCode) || (localMemberAttribute.getType() == MemberAttribute.Type.phone) || (localMemberAttribute.getType() == MemberAttribute.Type.mobile) || (localMemberAttribute.getType() == MemberAttribute.Type.text) || (localMemberAttribute.getType() == MemberAttribute.Type.select))
      {
        if ((localMemberAttribute.getIsRequired().booleanValue()) && (StringUtils.isEmpty(str))) {
          return "/shop/common/error";
        }
        localMember.setAttributeValue(localMemberAttribute, str);
      }
      else
      {
        Member.Gender localGender;
        if (localMemberAttribute.getType() == MemberAttribute.Type.gender)
        {
          localGender = StringUtils.isNotEmpty(str) ? Member.Gender.valueOf(str) : null;
          if ((localMemberAttribute.getIsRequired().booleanValue()) && (localGender == null)) {
            return "/shop/common/error";
          }
          localMember.setGender(localGender);
        }
        else if (localMemberAttribute.getType() == MemberAttribute.Type.birth)
        {
          try
          {
        	Date date = StringUtils.isNotEmpty(str) ? DateUtils.parseDate(str, CommonAttributes.DATE_PATTERNS) : null;
            if ((localMemberAttribute.getIsRequired().booleanValue()) && (date == null)) {
              return "/shop/common/error";
            }
            localMember.setBirth(date);
          }
          catch (ParseException localParseException1)
          {
            return "/shop/common/error";
          }
        }
        else
        {
          Object localObject1;
          if (localMemberAttribute.getType() == MemberAttribute.Type.area)
          {
            localObject1 = StringUtils.isNotEmpty(str) ? (Area)this.IIIlllll.find(Long.valueOf(str)) : null;
            if (localObject1 != null) {
              localMember.setArea((Area)localObject1);
            } else if (localMemberAttribute.getIsRequired().booleanValue()) {
              return "/shop/common/error";
            }
          }
          else if (localMemberAttribute.getType() == MemberAttribute.Type.checkbox)
          {
        	String[] as = request.getParameterValues("memberAttribute_" + localMemberAttribute.getId());
        	List list1 = (as != null ? Arrays.asList(as) : null);
            if ((localMemberAttribute.getIsRequired().booleanValue()) && ((list1 == null) || (list1.isEmpty()))) {
              return "/shop/common/error";
            }
            localMember.setAttributeValue(localMemberAttribute, list1);
          }
        }
      }
    }
    this.IIIlllIl.update(localMember);
    IIIllIlI(redirectAttributes, MESSAGE_SUCCESS);
    return "redirect:edit.jhtml";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.member.ProfileController
 * JD-Core Version:    0.7.0.1
 */
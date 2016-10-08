package com.tcop.controller.shop;

import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.ResourceNotFoundException;
import com.tcop.Setting;
import com.tcop.Setting.CaptchaType;
import com.tcop.Setting.ConsultationAuthority;
import com.tcop.entity.Consultation;
import com.tcop.entity.Member;
import com.tcop.entity.Product;
import com.tcop.service.CaptchaService;
import com.tcop.service.ConsultationService;
import com.tcop.service.MemberService;
import com.tcop.service.ProductService;
import com.tcop.util.SettingUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopConsultationController")
@RequestMapping({"/consultation"})
public class ConsultationController
  extends BaseController
{
  private static final int IIIlllIl = 10;
  @Resource(name="consultationServiceImpl")
  private ConsultationService IIIllllI;
  @Resource(name="productServiceImpl")
  private ProductService IIIlllll;
  @Resource(name="memberServiceImpl")
  private MemberService IIlIIIII;
  @Resource(name="captchaServiceImpl")
  private CaptchaService IIlIIIIl;
  
  @RequestMapping(value={"/add/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(@PathVariable Long id, ModelMap model)
  {
    Setting localSetting = SettingUtils.get();
    if (!localSetting.getIsConsultationEnabled().booleanValue()) {
      throw new ResourceNotFoundException();
    }
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null) {
      throw new ResourceNotFoundException();
    }
    model.addAttribute("product", localProduct);
    model.addAttribute("captchaId", UUID.randomUUID().toString());
    return "/shop/consultation/add";
  }
  
  @RequestMapping(value={"/content/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String content(@PathVariable Long id, Integer pageNumber, ModelMap model)
  {
    Setting localSetting = SettingUtils.get();
    if (!localSetting.getIsConsultationEnabled().booleanValue()) {
      throw new ResourceNotFoundException();
    }
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null) {
      throw new ResourceNotFoundException();
    }
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("product", localProduct);
    model.addAttribute("page", this.IIIllllI.findPage(null, localProduct, Boolean.valueOf(true), localPageable));
    return "/shop/consultation/content";
  }
  
  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message save(String captchaId, String captcha, Long id, String content, HttpServletRequest request)
  {
    if (!this.IIlIIIIl.isValid(Setting.CaptchaType.consultation, captchaId, captcha)) {
      return Message.error("shop.captcha.invalid", new Object[0]);
    }
    Setting localSetting = SettingUtils.get();
    if (!localSetting.getIsConsultationEnabled().booleanValue()) {
      return Message.error("shop.consultation.disabled", new Object[0]);
    }
    if (!validateValue(Consultation.class, "content", content, new Class[0])) {
      return MESSAGE_ERROR;
    }
    Member localMember = this.IIlIIIII.getCurrent();
    if ((localSetting.getConsultationAuthority() != Setting.ConsultationAuthority.anyone) && (localMember == null)) {
      return Message.error("shop.consultation.accessDenied", new Object[0]);
    }
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null) {
      return MESSAGE_ERROR;
    }
    Consultation localConsultation = new Consultation();
    localConsultation.setContent(content);
    localConsultation.setIp(request.getRemoteAddr());
    localConsultation.setMember(localMember);
    localConsultation.setProduct(localProduct);
    if (localSetting.getIsConsultationCheck().booleanValue())
    {
      localConsultation.setIsShow(Boolean.valueOf(false));
      this.IIIllllI.save(localConsultation);
      return Message.success("shop.consultation.check", new Object[0]);
    }
    localConsultation.setIsShow(Boolean.valueOf(true));
    this.IIIllllI.save(localConsultation);
    return Message.success("shop.consultation.success", new Object[0]);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.ConsultationController
 * JD-Core Version:    0.7.0.1
 */
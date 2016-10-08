package com.tcop.controller.shop.member;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.tcop.Pageable;
import com.tcop.Setting;
import com.tcop.controller.shop.BaseController;
import com.tcop.entity.Member;
import com.tcop.entity.Payment;
import com.tcop.entity.Payment.Status;
import com.tcop.entity.Payment.Type;
import com.tcop.entity.Sn;
import com.tcop.plugin.PaymentPlugin;
import com.tcop.service.DepositService;
import com.tcop.service.MemberService;
import com.tcop.service.PaymentService;
import com.tcop.service.PluginService;
import com.tcop.service.SnService;
import com.tcop.util.SettingUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopMemberDepositController")
@RequestMapping({"/member/deposit"})
public class DepositController
  extends BaseController
{
  private static final int IIIlllIl = 10;
  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;
  @Resource(name="depositServiceImpl")
  private DepositService IIIlllll;
  @Resource(name="pluginServiceImpl")
  private PluginService IIlIIIII;
  @Resource(name="paymentServiceImpl")
  private PaymentService IIlIIIIl;
  @Resource(name="snServiceImpl")
  private SnService IIlIIIlI;
  
  @RequestMapping(value={"/recharge"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String recharge(ModelMap model)
  {
    List localList = this.IIlIIIII.getPaymentPlugins(true);
    if (!localList.isEmpty())
    {
      model.addAttribute("defaultPaymentPlugin", localList.get(0));
      model.addAttribute("paymentPlugins", localList);
    }
    return "shop/member/deposit/recharge";
  }
  
  @RequestMapping(value={"/recharge"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String recharge(BigDecimal amount, String paymentPluginId, HttpServletRequest request, ModelMap model)
  {
    PaymentPlugin localPaymentPlugin = this.IIlIIIII.getPaymentPlugin(paymentPluginId);
    if ((localPaymentPlugin == null) || (!localPaymentPlugin.getIsEnabled())) {
      return "/shop/common/error";
    }
    Setting localSetting = SettingUtils.get();
    if ((amount == null) || (amount.compareTo(new BigDecimal(0)) <= 0) || (amount.precision() > 15) || (amount.scale() > localSetting.getPriceScale().intValue())) {
      return "/shop/common/error";
    }
    BigDecimal localBigDecimal = localPaymentPlugin.getFee(amount);
    amount = amount.add(localBigDecimal);
    Payment localPayment = new Payment();
    localPayment.setSn(this.IIlIIIlI.generate(Sn.Type.payment));
    localPayment.setType(Payment.Type.online);
    localPayment.setStatus(Payment.Status.wait);
    localPayment.setPaymentMethod(localPaymentPlugin.getPaymentName());
    localPayment.setFee(localBigDecimal);
    localPayment.setAmount(amount);
    localPayment.setPaymentPluginId(paymentPluginId);
    localPayment.setExpire(localPaymentPlugin.getTimeout() != null ? DateUtils.addMinutes(new Date(), localPaymentPlugin.getTimeout().intValue()) : null);
    localPayment.setMember(this.IIIllllI.getCurrent());
    this.IIlIIIIl.save(localPayment);
    model.addAttribute("url", localPaymentPlugin.getUrl());
    model.addAttribute("method", localPaymentPlugin.getMethod());
    model.addAttribute("parameterMap", localPaymentPlugin.getParameterMap(localPayment.getSn(), amount, IIIllIlI("shop.member.deposit.recharge", new Object[0]), request));
    return "shop/payment/submit";
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllll.findPage(localMember, localPageable));
    return "shop/member/deposit/list";
  }
}
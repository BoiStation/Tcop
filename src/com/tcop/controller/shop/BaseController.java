package com.tcop.controller.shop;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import javax.validation.Validator;
import com.tcop.DateEditor;
import com.tcop.HtmlCleanEditor;
import com.tcop.Message;
import com.tcop.Setting;
import com.tcop.template.directive.FlashMessageDirective;
import com.tcop.util.SettingUtils;
import com.tcop.util.SpringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BaseController
{
  protected static final String ERROR_PAGE = "/shop/common/error";
  protected static final Message MESSAGE_ERROR = Message.error("shop.message.error", new Object[0]);
  protected static final Message MESSAGE_SUCCESS = Message.success("shop.message.success", new Object[0]);
  private static final String CONSTRAINTVIOLATIONS = "constraintViolations";
  @Resource(name="validator")
  private Validator validator;
  
  @InitBinder
  protected void bindingPreparation(WebDataBinder paramWebDataBinder)
  {
	System.out.println("into binding...");
    paramWebDataBinder.registerCustomEditor(String.class, new HtmlCleanEditor(true, true));
    paramWebDataBinder.registerCustomEditor(Date.class, new DateEditor(true));
  }
  
  protected boolean validate(Object paramObject, Class<?>... paramVarArgs){
    Set localSet = this.validator.validate(paramObject, paramVarArgs);
    if (localSet.isEmpty()) {
      return true;
    }
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    localRequestAttributes.setAttribute("constraintViolations", localSet, 0);
    return false;
  }
  
  protected boolean validateValue(Class<?> paramClass, String paramString, Object paramObject, Class<?>... paramVarArgs)
  {
    Set localSet = this.validator.validateValue(paramClass, paramString, paramObject, paramVarArgs);
    if (localSet.isEmpty()) {
      return true;
    }
    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    requestAttributes.setAttribute("constraintViolations", localSet, 0);
    return false;
  }
  
  protected String IIIllIlI(BigDecimal paramBigDecimal, boolean paramBoolean1, boolean paramBoolean2)
  {
    Setting settings = SettingUtils.get();
    String str = settings.setScale(paramBigDecimal).toString();
    if(paramBoolean1) {
      str = settings.getCurrencySign() + str;
    }
    if (paramBoolean2) {
      str = str + settings.getCurrencyUnit();
    }
    return str;
  }
  
  protected String IIIllIlI(String paramString, Object... paramVarArgs)
  {
    return SpringUtils.getMessage(paramString, paramVarArgs);
  }
  
  protected void IIIllIlI(RedirectAttributes paramRedirectAttributes, Message paramMessage)
  {
    if ((paramRedirectAttributes != null) && (paramMessage != null)) {
      paramRedirectAttributes.addFlashAttribute(FlashMessageDirective.FLASH_MESSAGE_ATTRIBUTE_NAME, paramMessage);
    }
  }
}
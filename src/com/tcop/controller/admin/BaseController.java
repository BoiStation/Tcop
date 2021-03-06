package com.tcop.controller.admin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import javax.validation.Validator;
import com.tcop.DateEditor;
import com.tcop.Message;
import com.tcop.Setting;
import com.tcop.entity.Log;
import com.tcop.template.directive.FlashMessageDirective;
import com.tcop.util.SettingUtils;
import com.tcop.util.SpringUtils;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BaseController
{
  protected static final String IIIllIlI = "/admin/common/error";
  protected static final Message IIIllIll = Message.error("admin.message.error", new Object[0]);
  protected static final Message IIIlllII = Message.success("admin.message.success", new Object[0]);
  private static final String IIIlllIl = "constraintViolations";
  @Resource(name="validator")
  private Validator IIIllllI;
  
  @InitBinder
  protected void IIIllIlI(WebDataBinder paramWebDataBinder)
  {
    paramWebDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    paramWebDataBinder.registerCustomEditor(Date.class, new DateEditor(true));
  }
  
  protected boolean IIIllIlI(Object paramObject, Class<?>... paramVarArgs)
  {
    Set localSet = this.IIIllllI.validate(paramObject, paramVarArgs);
    if (localSet.isEmpty()) {
      return true;
    }
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    localRequestAttributes.setAttribute("constraintViolations", localSet, 0);
    return false;
  }
  
  protected boolean IIIllIlI(Class<?> paramClass, String paramString, Object paramObject, Class<?>... paramVarArgs)
  {
    Set localSet = this.IIIllllI.validateValue(paramClass, paramString, paramObject, paramVarArgs);
    if (localSet.isEmpty()) {
      return true;
    }
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    localRequestAttributes.setAttribute("constraintViolations", localSet, 0);
    return false;
  }
  
  protected String IIIllIlI(BigDecimal paramBigDecimal, boolean paramBoolean1, boolean paramBoolean2)
  {
    Setting localSetting = SettingUtils.get();
    String str = localSetting.setScale(paramBigDecimal).toString();
    if (paramBoolean1) {
      str = localSetting.getCurrencySign() + str;
    }
    if (paramBoolean2) {
      str = str + localSetting.getCurrencyUnit();
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
  
  protected void IIIllIlI(String paramString)
  {
    if (paramString != null)
    {
      RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
      localRequestAttributes.setAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME, paramString, 0);
    }
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.BaseController
 * JD-Core Version:    0.7.0.1
 */
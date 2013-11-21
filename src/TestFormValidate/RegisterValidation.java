package TestFormValidate;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("registerValidator")
public class RegisterValidation implements Validator{
	public boolean supports(Class<?> aClass){
		return NewRegister.class.isAssignableFrom(aClass);
	}
	
	public void validate(Object target, Errors errors){
		//下面三个字符串分别为：field，message.properties里注册的错误码，若给出的错误码没有使用这条message
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.NewRegister.name", "用户名不能为空");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.NewRegister.name", "密码不能为空");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.NewRegister.name", "邮箱不能为空");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.NewRegister.name", "电话不能为空");
		
		NewRegister newRegister = (NewRegister)target;
		CommonValidationTools commonValidationTools = new CommonValidationTools();
		
		if(!commonValidationTools.checkEmail(newRegister.getEmail())){
			errors.rejectValue("email", "NotValid.NewRegister.email", "请输入合格的邮箱格式");
		}
		if(!commonValidationTools.checkPhone(newRegister.getPhone())){
			errors.rejectValue("email", "NotValid.NewRegister.phone", "请输入合格的电话格式");
		}
	}

	
}

package TestFormValidate;


import javax.servlet.Registration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@Autowired
	private RegisterValidation registerValidation;
	
	public void setRegisterValidation(
			RegisterValidation registerValidation){
		this.registerValidation = registerValidation;
	}
	
	//show blank register form
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistration(Model model){
		NewRegister newRegister = new NewRegister();
		model.addAttribute("newRegister", newRegister);
		return "registerForm";
	}
	
	//process the register
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processRegister(NewRegister newRegister, BindingResult result,Model model){
		registerValidation.validate(newRegister, result);
		model.addAttribute("newRegister", newRegister);
		
		if(result.hasErrors()){		
			return "registerForm";
		}else {
			
			return "registersuccess";
		}
	}
}

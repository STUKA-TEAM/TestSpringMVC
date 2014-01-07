package TestSpringInterceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AfterInterceptorController {
@RequestMapping(value="/interceptorTest")
public String Message(ModelMap modelMap){
	modelMap.addAttribute("controllerMes","controller");
	return "message";
}
}

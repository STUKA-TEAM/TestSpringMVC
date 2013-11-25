package TestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloWorldController {
    @RequestMapping(value = "/helloworld/show", method = RequestMethod.GET)
    public String helloWorld(ModelMap modelMap){
    	String messageString  = "HELLO WORLD";
    	modelMap.addAttribute("message", messageString);
    	return "helloWorldView";
    }
    
}

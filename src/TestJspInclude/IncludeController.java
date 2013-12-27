package TestJspInclude;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncludeController {
@RequestMapping(value="/initial", method=RequestMethod.GET)
public String initial(Model model){	
	return "initial";
}

@RequestMapping(value="/includedProcess", method=RequestMethod.GET)
public String includedProcess(Model model){
	model.addAttribute("data", "includedData");
	return "includedProcess";
}
}

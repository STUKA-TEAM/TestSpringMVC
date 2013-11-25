package TestAjaxRetrieve;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrepareInitialViewController {
@RequestMapping(value = "/initialview", method = RequestMethod.GET)
public String prepareInitialController(Model model){
	return "initialView";
}
}

package TestAjaxRetrieve;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class ResponseAjaxController {
	@RequestMapping(value = "/getdiv", method = RequestMethod.POST)
	String showDiv(@RequestBody String jsonString, Model model){
		Gson gson = new Gson();
		UserDemo userDemo = gson.fromJson(jsonString, UserDemo.class);
		model.addAttribute("user", userDemo);
		return "divView";
	}
}

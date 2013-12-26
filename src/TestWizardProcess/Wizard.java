package TestWizardProcess;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;
import com.sun.istack.internal.FinalArrayList;

@Controller
@RequestMapping("/wizard")
@SessionAttributes("dataBean")
public class Wizard {
	@RequestMapping(value = "/initial", method = RequestMethod.GET)
	public String initial(final ModelMap modelMap){
		DataBean dataBean = new DataBean();
		modelMap.addAttribute("dataBean", dataBean);
		return "stepContainer";
	}
	@RequestMapping(value = "/backstep1", method = RequestMethod.GET)
	public String backstep1(final @ModelAttribute("dataBean") DataBean dataBean, Model model){
		model.addAttribute("dataBean", dataBean);
		return "step1";
	}
	@RequestMapping(value = "/step2", method = RequestMethod.POST)
	public String step2(@RequestBody String json, final @ModelAttribute("dataBean") DataBean dataBean, Model model){
		Gson gson = new Gson();
		Step1Data step1Data = gson.fromJson(json, Step1Data.class);
		dataBean.setStep1Data(step1Data.getData());
		model.addAttribute("dataBean", dataBean);
		return "step2";
	}
	@RequestMapping(value = "/backstep2", method = RequestMethod.GET)
	public String backstep2(final @ModelAttribute("dataBean") DataBean dataBean, Model model){
		model.addAttribute("dataBean", dataBean);
		return "step2";
	}
	@RequestMapping(value = "/step3", method = RequestMethod.POST)
	public String step3(@RequestBody String json, final @ModelAttribute("dataBean") DataBean dataBean, Model model){
		Gson gson = new Gson();
		Step1Data step2Data = gson.fromJson(json, Step1Data.class);
		dataBean.setStep2Data(step2Data.getData());
		model.addAttribute("dataBean", dataBean);
		return "step3";
	}
	@RequestMapping(value = "/finish", method = RequestMethod.POST)
	public String finish(@RequestBody String json, 
			final @ModelAttribute("dataBean") DataBean dataBean, 
			Model model,
			final SessionStatus status){
		Gson gson = new Gson();
		Step1Data step3Data = gson.fromJson(json, Step1Data.class);
		dataBean.setStep3Data(step3Data.getData());
		model.addAttribute("dataBean", dataBean);
		status.setComplete();
		return "finish";
	}
}

package TestJSONInUIAndServer;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class JsonTestController {
	@RequestMapping(value = "/jsonmail", method = RequestMethod.GET)
	public @ResponseBody String getMailInJson(){
		Mail mail = new Mail(System.currentTimeMillis(), "hello!");
		Gson gson = new Gson();
		String json = gson.toJson(mail);
		return json;
	}
	
	@RequestMapping(value = "/jsonfolder", method = RequestMethod.GET)
	@ResponseBody
	public String getFolderInJson(){
        Date time = Calendar.getInstance().getTime();
	    
		Folder root = new Folder
		("/",
		        new Folder("tmp",
		                new File("cache.tmp", time)),
		        new Folder("opt",
		                new Folder("Chrome",
		                        new File("chrome", 123456))),
		        new Folder("home",
		                new Folder("john"),
		                new Folder("kate"))                
		);
		 
		//object to json
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = builder.create();
		String json = gson.toJson(root); 
		
		return json;
	}
	
	@RequestMapping(value = "/jsonreceiver", method = RequestMethod.POST)
	public String receiveJsonFromWeb(@RequestBody String json, Model model){
		model.addAttribute("json", json);
		return "showJsonView";
	}
}

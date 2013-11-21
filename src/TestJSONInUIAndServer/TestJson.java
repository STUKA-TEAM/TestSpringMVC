package TestJSONInUIAndServer;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestJson {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("All-Modules.xml");
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
		
		//json to object
		Folder outputRoot = gson.fromJson(json, Folder.class);
		
		System.out.println(json);  
	}

}

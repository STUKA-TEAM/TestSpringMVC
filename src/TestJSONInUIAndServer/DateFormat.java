package TestJSONInUIAndServer;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DateFormat {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("All-Modules.xml");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 05, 8, 18, 05, 23);
		Date time = calendar.getTime();
		
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = builder.create();
		String json = gson.toJson(time);
		
		System.out.println(json);

	}

}

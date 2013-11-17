package TestJSONInUIAndServer;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * @Description: to solve 'Naming discrepancies'
 * @author I079982
 *
 */
public class Mail {
    @SerializedName("Time")
    private int timestamp;
    
    public int getTimestamp()
    {
        return timestamp;
    }
    
    public Mail(int timestamp)
    {
        this.timestamp = timestamp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int timestamp = (int)new Date().getTime() / 1000;
		Mail mail = new Mail(timestamp);
		        
		Gson gson = new Gson();
		String json = gson.toJson(mail);
		
		Mail mail2 = gson.fromJson(json, Mail.class);
		
		System.out.println(json);
		System.out.println(mail2.getTimestamp());
	}

}

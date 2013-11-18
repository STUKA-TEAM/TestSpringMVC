package TestJSONInUIAndServer;

import com.google.gson.annotations.SerializedName;

/**
 * @Description: to solve 'Naming discrepancies'
 * @author I079982
 *
 */
public class Mail {
	@SerializedName("time")
   private long timestamp;
   private String mailContent;
    
    public long getTimestamp()
    {
        return timestamp;
    }
    
    public Mail(long timestamp)
    {
        this.timestamp = timestamp;
    }

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	
    public Mail(long timestamp, String mailContent) {
		super();
		this.timestamp = timestamp;
		this.mailContent = mailContent;
	}
}

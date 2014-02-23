package TestCellText;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
@Controller
public class sendText {
@RequestMapping(value = "/send", method = RequestMethod.GET)
void sendCellText() throws HttpException, IOException{
	String contentString = "尊敬的Elove客户，您当月使用了10套Elove，每套30元，未付款金额为300元，为保证账户正常运行，请及时缴款。详见：http://tukacorp.com/a.htm?p=usernameusername";
	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");//在头文件中设置转码
	NameValuePair[] data ={ new NameValuePair("Uid", "tukacorp")
	                       ,new NameValuePair("Key", "b52d3d68d04a344a6cf8")
	                       ,new NameValuePair("smsMob","13818031305")
	                       ,new NameValuePair("smsText",contentString)};
	post.setRequestBody(data);

	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result = new String(post.getResponseBodyAsString().getBytes("utf8")); 
	System.out.println(result);
	post.releaseConnection();
}
}

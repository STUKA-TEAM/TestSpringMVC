package TestUploadFiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.multipart.MultipartFile;


public class CommonValidationTools {
	public boolean checkEmail(String email){
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
		Pattern regex = Pattern.compile(check);  
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}
	
	public boolean checkPhone(String phone){
		String check = "^(13[4,5,6,7,8,9]|15[0,8,9,1,7]|188|187)\\d{8}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(phone);		 
		return matcher.matches();
	}
	
	public boolean checkImageSize(MultipartFile multipartFile) {
		//不能超过 2MB
		if(multipartFile.getSize() > 2100000){
			return false;
		}else {
			return true;
		}
	}
	public boolean checkImageType(MultipartFile multipartFile) {
		if (multipartFile.getContentType() != "image/jpeg" 
				&& multipartFile.getContentType() != "image/png") {
			return false;
		}else {
			return true;
		}
	}
}

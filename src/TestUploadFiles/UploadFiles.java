package TestUploadFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFiles {
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	 public String handleFormUpload(@RequestParam("name") String name,
        @RequestParam("file") MultipartFile fileFromForm) {
		  if (!fileFromForm.isEmpty()) {
              try {
				InputStream inputStream = fileFromForm.getInputStream();
				String fileName = fileFromForm.getOriginalFilename();
				
				//Test MultipartFile
				System.out.println("getContentType:"+fileFromForm.getContentType());
				System.out.println("getName:"+fileFromForm.getName());
				System.out.println("getOriginalFilename:"+fileFromForm.getOriginalFilename());
				System.out.println("getSize:"+fileFromForm.getSize());//byte
				
				//Test Validation
				CommonValidationTools commonValidationTools = new CommonValidationTools();
				System.out.println("typevalidation:" + commonValidationTools.checkImageType(fileFromForm));
				System.out.println("sizevalidation:" + commonValidationTools.checkImageSize(fileFromForm));
				//写入绝对路径：项目部署后都是写到磁盘的绝对路径
				String path = "C:\\Users\\I079951\\Desktop\\" + fileName;
				SaveUploadedFile saveUploadedFile = new SaveUploadedFile();
				saveUploadedFile.save(path, inputStream);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
              // store the bytes in a database or file system and so on
             
      }
        return "success";
    }
	
	@RequestMapping(value = "submitform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute Book book){
		return "showbook";
	}
}

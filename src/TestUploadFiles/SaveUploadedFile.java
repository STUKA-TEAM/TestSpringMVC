package TestUploadFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SaveUploadedFile {
	public boolean save(String path, InputStream inputStream){
		OutputStream outputStream = null;
		try {
			File file = new File(path);				
		    outputStream = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != -1){
				outputStream.write(bytes, 0, read);
			}
			System.out.println("RIGHT");
			outputStream.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

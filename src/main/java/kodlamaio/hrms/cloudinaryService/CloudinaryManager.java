package kodlamaio.hrms.cloudinaryService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager {

	private Cloudinary cloudinary = new Cloudinary(
			ObjectUtils.asMap("cloud_name", "my_cloud_name", "api_key", "my_api_key", "api_secret", "my_api_secret"));
	

	public Map upload(MultipartFile multipartFile) throws IOException {
		
		File file = convert(multipartFile);
		Map upload = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		Map result= upload;
		file.delete();
		return result;
	}

	private File convert(MultipartFile multipartFile) throws IOException{
		File file= new File(multipartFile.getOriginalFilename());
		FileOutputStream fileOut = new FileOutputStream(file);
		fileOut.write(multipartFile.getBytes());
		fileOut.close();
		return file;
	}

}





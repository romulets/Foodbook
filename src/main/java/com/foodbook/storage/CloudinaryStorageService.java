package com.foodbook.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
@Primary
public class CloudinaryStorageService implements StorageService {

	private static Cloudinary cloudinary;
	
	@Override
	public void init() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "dgr5qeds2",
				  "api_key", "177384457871566",
				  "api_secret", "v8SwCseijctC1Kbps6Dsw7npaes"));		
	}

	@Override
	public String store(MultipartFile file, String filename, ServerPath path) {
		try {
			
			Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
					"resource_type", "auto",
					"folder", path.getIdentifier(),
					"overwrite", true
					));
			
			return (String) result.get("public_id");
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(String filename, ServerPath path) {
		// TODO Auto-generated method stub
		
	}

}

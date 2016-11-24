package com.foodbook.storage;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
@Primary
public class CloudinaryStorageService implements StorageService {

	private static Cloudinary cloudinary;
	
	@Value("${cloudinary.cloud_name}")
	private String cloudName;
	
	@Value("${cloudinary.api_key}")
	private String apiKey;
	
	@Value("${cloudinary.api_secret}")
	private String apiSecret;
	
	@Override
	public void init() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", cloudName,
				  "api_key", apiKey,
				  "api_secret", apiSecret));		
	}

	
	@Override
    public String store(BufferedImage file, String filename, ServerPath path) {
		ByteArrayOutputStream baos;
		byte[] imageInByte;
		
		try {
			
			baos = new ByteArrayOutputStream();
			ImageIO.write(file, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			filename = store(imageInByte, filename, path);
			baos.close();
			
			return filename;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
	@Override
	public String store(MultipartFile file, String filename, ServerPath path) {
		try {
			return store(file.getBytes(), filename, path);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String store(byte[] file, String filename, ServerPath path) throws IOException {
		Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
				"public_id", filename,
				"resource_type", "auto",
				"folder", path.getIdentifier(),
				"overwrite", true,
				"format", "jpg"
				));
		
		return (String) result.get("url");
	}

	@Override
	public void delete(String filename, ServerPath path) {
		// Not implemented by api
	}

}

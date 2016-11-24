package com.foodbook.helpers;

import java.awt.image.BufferedImage;

import org.springframework.web.multipart.MultipartFile;

public interface ImageCropperHelper {

	
	public BufferedImage cropCenter(MultipartFile src);
	
}

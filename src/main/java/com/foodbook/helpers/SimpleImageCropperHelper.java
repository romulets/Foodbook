package com.foodbook.helpers;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SimpleImageCropperHelper implements ImageCropperHelper{
	
	public BufferedImage cropCenter(MultipartFile src) {
		try {			
			return cropCenter(src.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private BufferedImage cropCenter(byte[] image) throws IOException {
		InputStream in = new ByteArrayInputStream(image);
		  BufferedImage originalImage = ImageIO.read(in);
		  
		  int height = originalImage.getHeight();
		  int width = originalImage.getWidth();
		  
		  if (height == width) {
		    return originalImage;
		  }
		  
		  int squareSize = (height > width ? width : height);

		  int xc = width / 2;
		  int yc = height / 2;
		  
		  BufferedImage croppedImage = originalImage.getSubimage(
		      xc - (squareSize / 2), 
		      yc - (squareSize / 2), 
		      squareSize,            
		      squareSize             
		  );
		  
		  return resize(croppedImage, 300, 300);
	}
	
	private BufferedImage resize(BufferedImage img, int newW, int newH) {  
	    int w = img.getWidth();  
	    int h = img.getHeight();  
	    BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
	    Graphics2D g = dimg.createGraphics();  
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	    RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
	    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
	    g.dispose();  
	    return dimg;  
	} 
	
}

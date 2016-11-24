package com.foodbook.storage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.exceptions.StorageException;

@Service
public class LocalStorageService implements StorageService {
    
	@Value("${server.resources.path}")
	private String resourcesBasePath;
	
    @Override
    public void init() {
    	getBasepath(ServerPath.USER).toFile().mkdirs();
    	getBasepath(ServerPath.RECIPE).toFile().mkdirs();
    }
    
    @Override
    public String store(BufferedImage file, String filename, ServerPath path) {
    	return "";
    }
    
    
    @Override
    public String store(MultipartFile file, String filename, ServerPath path) {
        try {
            if (file.isEmpty()) 
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            
            filename = generateFileName(file, filename);
            copyFile(file, filename, path);
            
            return filename;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
    
    private String generateFileName(MultipartFile file, String filename) {
    	String[] parts = file.getOriginalFilename().split("\\.");
        return String.format("%s.%s", filename, parts[parts.length - 1]);
    }
    
    private void copyFile(MultipartFile file, String filename, ServerPath path) throws IOException {
    	Path basepath = getBasepath(path);
        Files.copy(file.getInputStream(), basepath.resolve(filename));
    }
    
    private Path getBasepath(ServerPath path) {
    	Path basepath = Paths.get(resourcesBasePath);
    	return basepath.resolve(path.getServerPath());
    }
    
    public Path load(String filename, ServerPath path) {
        return path.getServerPath().resolve(filename);
    }
    
    @Override
    public void delete(String filename, ServerPath path) {
        try{
        	Files.delete(load(filename, path).toAbsolutePath());
        } catch (NoSuchFileException e) {
        	throw new StorageException("No such file " + filename, e);
        } catch (IOException e) {
        	throw new StorageException("permission problems on delete " + filename, e);
        }
    }
}

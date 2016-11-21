package com.foodbook.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.exceptions.StorageException;

@Service
public class LocalStorageService implements StorageService {

    private final Path rootLocation;
       
	
    public LocalStorageService() {
        this.rootLocation = Paths.get("files/img");
    }		
    
    @Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
    
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }
    
    @Override
    public void delete(String filename) {
        try{
        	Files.delete(load(filename).toAbsolutePath());
        } catch (NoSuchFileException e) {
        	throw new StorageException("No such file " + filename, e);
        } catch (IOException e) {
        	throw new StorageException("permission problems on delete " + filename, e);
        }
    }
}

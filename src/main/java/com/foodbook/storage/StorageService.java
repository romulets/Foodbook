package com.foodbook.storage;


import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

    void store(MultipartFile file);

    Path load(String filename);

    void delete(String filename);
}

package com.foodbook.storage;


import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

    String store(MultipartFile file, String filename, ServerPath path);

    void delete(String filename, ServerPath path);
}

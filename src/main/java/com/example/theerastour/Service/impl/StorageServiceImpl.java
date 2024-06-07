package com.example.theerastour.Service.impl;


import com.example.theerastour.Service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation  ;

    public StorageServiceImpl(){
        this.rootLocation = Paths.get("src/main/resources/static/img");
    }

    public static String getRelativePath(String fullPath) {
        int index = fullPath.indexOf("static");
        if (index != -1) {
            String relativePath = fullPath.substring(index + 7).replace("\\", "/");
            return "/" + relativePath;
        }
        return "";
    }

    @Override
    public String store(MultipartFile file){
        try {
            System.out.println(file);
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
            return getRelativePath(destinationFile.toString());
        }
        catch (IOException e) {
            //  throw new StorageException("Failed to store file.", e);
            System.out.println("Khong convert anh duoc");
        }
        return "";
    }

    @Override
    public void init(){
        try{
            Files.createDirectories(rootLocation);
        } catch (Exception e){

        }
    }


}
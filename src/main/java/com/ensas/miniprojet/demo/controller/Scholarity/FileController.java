package com.ensas.miniprojet.demo.controller.Scholarity;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/scholarity/files")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Authorization", "content-type"})
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity uploadToLocalFileSystem(@RequestParam("file")MultipartFile file){

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        System.out.println("fileName : " +fileName );

        String filebasePath = "/Users/mac/Desktop/miniProjet/";
        Path path = Paths.get( filebasePath + fileName);
        System.out.println("path : " + path.toString() );
        try{
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName)
                .toUriString();

        return ResponseEntity.ok(fileDownloadUri);
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity uploadToLocalFileSystem(@PathVariable String fileName) {



     //   Path path = Paths.get(filebasePath + fileName);
        Resource resource = null;
        resource = new ClassPathResource("image/" + fileName);;

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .header(""
                ,"attachment; filename\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}

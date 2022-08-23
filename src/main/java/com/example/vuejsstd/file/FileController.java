package com.example.vuejsstd.file;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class FileController {

    @PostMapping("/file")
    public String requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/" + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            return "upload fail";
        }
        return "upload success";
    }
}

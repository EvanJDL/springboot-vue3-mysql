package Evan.demo.controller;

import Evan.demo.pojo.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString() +
                originalFilename.substring(originalFilename.lastIndexOf("."));
        String uploadDir = "C:/Users/frank/Desktop/web_develop/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        file.transferTo(new File(uploadDir + filename));

        String url = "/uploads/" + filename;
        return Result.success(url);
    }
}

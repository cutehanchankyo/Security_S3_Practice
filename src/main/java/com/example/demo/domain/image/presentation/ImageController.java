package com.example.demo.domain.image.presentation;

import com.example.demo.domain.image.service.Impl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final ImageServiceImpl imageService;

    @PostMapping
    public ResponseEntity<List<String>> createImage(@RequestPart("images") List<MultipartFile> images) throws Exception {
        List<String> result = imageService.execute(images);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

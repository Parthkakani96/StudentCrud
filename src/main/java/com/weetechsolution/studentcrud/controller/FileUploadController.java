package com.weetechsolution.studentcrud.controller;

import com.weetechsolution.studentcrud.model.FilePath;
import com.weetechsolution.studentcrud.service.impl.FilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class FileUploadController {

    @Autowired
    private FilePathService filePathService;

//  Upload File to Server and Save file path in the Database
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        return filePathService.Upload(file);
    }

//  Get Method to get File by ID
    @GetMapping("/files/{id}")
    private FilePath getFileByID(@PathVariable("id") long id){
        return filePathService.getFileById(id);
    }

//  Delete Method to delete the File by ID
    @DeleteMapping("/files/{id}")
    private void deleteFile(@PathVariable("id") long id){
        filePathService.deleteFile(id);
    }

//  Change
    @GetMapping("/files")
    private List<FilePath> getAllFiles() {
        return filePathService.getAllFile();
    }
}

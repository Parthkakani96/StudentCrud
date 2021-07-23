package com.weetechsolution.studentcrud.service.impl;

import com.weetechsolution.studentcrud.model.FilePath;
import com.weetechsolution.studentcrud.repository.FilePathRepository;
import com.weetechsolution.studentcrud.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilePathService {

    @Autowired
    private FilePathRepository filePathRepository;

    public String Upload(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {

            String fileName = file.getOriginalFilename();

            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

            try {

                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Then create the corresponding entity class, add the following path, and then write through the database operation method
            FilePath biaopath = new FilePath();
            biaopath.setPath("http://localhost:8080/"+fileName);
            filePathRepository.save(biaopath);

        }
        return "File " + file.getOriginalFilename() + " is Upload!!!";

    }

    public List<FilePath> getAllFile(){
        List<FilePath> filePaths = new ArrayList<>();
        filePathRepository.findAll().forEach(filePath -> filePaths.add(filePath));
        return filePaths;
    }

    public FilePath getFileById(long id){
        return filePathRepository.findById(id).get();
    }

//  Deleting a Specific record by using the method deleteById()
    public void deleteFile(long id){
        filePathRepository.deleteById(id);
    }
}

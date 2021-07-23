package com.weetechsolution.studentcrud.repository;

import com.weetechsolution.studentcrud.model.FilePath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilePathRepository extends JpaRepository<FilePath, Long> {
}

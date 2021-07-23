package com.weetechsolution.studentcrud.repository;

import com.weetechsolution.studentcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsByRollNumber(Integer rollNumber);
}

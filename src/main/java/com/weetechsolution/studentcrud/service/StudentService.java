package com.weetechsolution.studentcrud.service;

import com.weetechsolution.studentcrud.model.Student;
import java.util.List;

public interface StudentService {

    Student save(Student student);
    Student update(Student student, int id);
    Student getById(int id);
    void delete(int id);
    List<Student> getAllStudents();

}

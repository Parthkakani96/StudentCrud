package com.weetechsolution.studentcrud.controller;

import com.weetechsolution.studentcrud.model.Student;
import com.weetechsolution.studentcrud.repository.StudentRepository;
import com.weetechsolution.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

//  Create New Student. Cannot create if the rollnumber exists
    @PostMapping("/signup")
    public ResponseEntity<?> createStudent(@RequestBody Student student) throws Exception{

        if (studentRepository.existsByRollNumber(student.getRollNumber())){
            return ResponseEntity
                    .badRequest()
                    .body("You are already Register!!!\nPlease Perform:\n1. Update\n2. Delete or\n3. Insert");
        }
        return ResponseEntity.ok(studentService.save(student));
    }

//  Multiple Endpoints API
    @GetMapping({"/student", "/student/{id}"})
    private Object multipleEndpoint(@PathVariable(value = "id", required = false) Integer id) {
        if (id!=null)
            return studentService.getById(id);
        else
            return studentService.getAllStudents();
    }

//  Delete Student By ID
    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.delete(id);
    }

//  Update Student By ID
    @PutMapping("/student/update/{id}")
    public Student updateStudent(@RequestBody Student student){
        studentService.update(student, student.getId());
        return student;
    }
}

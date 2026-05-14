package com.example.learningrestapi.controller;



import com.example.learningrestapi.service.StudentService;
import com.example.learningrestapi.studentdto.CreatenewStudentdto;
import com.example.learningrestapi.studentdto.StudentDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {
    private final StudentService studentservice;

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllstudent(){
    return  ResponseEntity.ok(studentservice.getallStudent());
    }
//    @GetMapping("/students/{id}/{name}")
//    public String getstudentbyId(@PathVariable Long id,@PathVariable String name){
//        return "id is :"+ id + "name is "+ name;
//    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentbyId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentservice.getstudentbyid(id));
    }
    @PostMapping("/students")
    public ResponseEntity<StudentDto> addnewStudent(@RequestBody @Valid CreatenewStudentdto addStudentdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentservice.createnewstudent(addStudentdto));
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteaStudent(@PathVariable Long id){
        studentservice.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody @Valid CreatenewStudentdto createnewStudentdto){
        return ResponseEntity.ok(studentservice.updateStudent(id,createnewStudentdto));
    }
    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDto> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentservice.partialStudentUpdate(id,updates));
    }

}

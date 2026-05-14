package com.example.learningrestapi.service;

import com.example.learningrestapi.studentdto.CreatenewStudentdto;
import com.example.learningrestapi.studentdto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getallStudent();

    StudentDto getstudentbyid(Long id);

    StudentDto createnewstudent(CreatenewStudentdto createnewstudent);

    void deleteStudentById(Long id);


    StudentDto updateStudent(Long id, CreatenewStudentdto createnewStudent);

    StudentDto partialStudentUpdate(Long id, Map<String, Object> updates);
}


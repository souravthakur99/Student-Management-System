package com.example.learningrestapi.service.impl;

import com.example.learningrestapi.entity.Student;
import com.example.learningrestapi.repository.StudentRepository;
import com.example.learningrestapi.service.StudentService;
import com.example.learningrestapi.studentdto.CreatenewStudentdto;
import com.example.learningrestapi.studentdto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceimpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    StudentServiceimpl(StudentRepository studentRepository, ModelMapper modelMapper){
        this.studentRepository=studentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<StudentDto> getallStudent() {
        List<Student> students=studentRepository.findAll();
        List<StudentDto> studentdtoList= students.stream().map( student->new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();
        return studentdtoList;
    }



    @Override
    public StudentDto getstudentbyid(Long id){
        Student student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found with id "+id));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createnewstudent(CreatenewStudentdto createnewstudent) {
        Student newStudent=modelMapper.map(createnewstudent , Student.class);
        Student student=studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }
    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("student does not exist");
        }
        studentRepository.deleteById(id);
    }
    public StudentDto updateStudent(Long id,CreatenewStudentdto createnewStudentdto){
     Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student is not updated id is indefined"));
     modelMapper.map(createnewStudentdto,Student.class);

     student=studentRepository.save(student);
     return modelMapper.map(student,StudentDto.class);
    }
    @Override
    public StudentDto partialStudentUpdate(Long id, Map<String, Object> updates){
        Student student=studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student does not exist"));
        updates.forEach((field,value)->{
            switch (field){
                case "name":student.setName((String)value);
                break;
                case "email":student.setEmail((String)value);
                break;
                default:
                    throw new IllegalArgumentException("field invalid");
            }
        });
        Student savedStudent=studentRepository.save(student);
       return modelMapper.map(savedStudent,StudentDto.class);
    }
}


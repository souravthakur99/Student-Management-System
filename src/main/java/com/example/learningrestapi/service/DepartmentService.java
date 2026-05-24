package com.example.learningrestapi.service;

import com.example.learningrestapi.entity.Department;
import com.example.learningrestapi.repository.DepartmentRepository;
import com.example.learningrestapi.studentdto.CreateDepartmentdto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    public DepartmentService(DepartmentRepository departmentRepository,ModelMapper modelMapper){
        this.modelMapper=modelMapper;
        this.departmentRepository=departmentRepository;
    }
    public Department createDepartment(CreateDepartmentdto createDepartmentdto){
        Department department= modelMapper.map(createDepartmentdto, Department.class);
        department.setName(createDepartmentdto.getName());
        return departmentRepository.save(department);
    }
}

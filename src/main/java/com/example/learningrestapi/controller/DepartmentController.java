package com.example.learningrestapi.controller;

import com.example.learningrestapi.entity.Department;
import com.example.learningrestapi.service.DepartmentService;
import com.example.learningrestapi.studentdto.CreateDepartmentdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DepartmentController {
    private final DepartmentService departmentService;
    DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @PostMapping("/departments")

    public ResponseEntity<Department> createDepartment(

            @RequestBody

            CreateDepartmentdto createDepartmentdto){

        return ResponseEntity

                .status(HttpStatus.CREATED)

                .body(departmentService

                        .createDepartment(createDepartmentdto));

    }
}

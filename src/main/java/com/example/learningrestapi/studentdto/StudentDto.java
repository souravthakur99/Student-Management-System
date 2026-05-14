package com.example.learningrestapi.studentdto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class StudentDto {

    private long id;
    private String name;
    private String email;
    public StudentDto() {

    }
    // Constructor
    public StudentDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter for id
    public long getId() {
        return id;
    }

    // Setter for id
    public void setId(long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
}

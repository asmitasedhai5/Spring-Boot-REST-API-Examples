package com.nccs.spring.practice.service.dto;

import com.nccs.spring.practice.domain.Student;

public class StudentDTO {

    public Long id;
    public String firstname;
    public String lastname;
    public Integer grade;

    public StudentDTO(){

    }

    public StudentDTO(Long id, String firstname, String lastname, Integer grade) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
    }

    public StudentDTO(Student student){
        this(student.getId(),student.getFirstname(),student.getLastname(),student.getGrade());
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", grade=" + grade +
                '}';
    }
}

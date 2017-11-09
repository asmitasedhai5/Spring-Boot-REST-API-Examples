package com.nccs.spring.practice.service.dto;

import com.nccs.spring.practice.domain.Classroom;
import com.nccs.spring.practice.domain.Student;

public class ClassroomDTO {

    private Long id;
    private Integer section;
    private Student student;

    public ClassroomDTO(){

    }

    public ClassroomDTO(Long id, Integer section, Student student) {
        this.id = id;
        this.section = section;
        this.student = student;
    }

    public ClassroomDTO(Classroom classroom){
        this(classroom.getId(),classroom.getSection(),classroom.getStudent());
    }

    public Long getId() {
        return id;
    }

    public Integer getSection() {
        return section;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "ClassroomDTO{" +
                "id=" + id +
                ", section=" + section +
                ", student=" + student +
                '}';
    }
}

package com.nccs.spring.practice.domain;

import javax.persistence.*;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer section;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Student student;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public void setStudent(Student student) {
        this.student = student;
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
}

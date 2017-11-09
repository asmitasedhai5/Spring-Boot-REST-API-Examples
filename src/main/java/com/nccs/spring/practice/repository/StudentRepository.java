package com.nccs.spring.practice.repository;

import com.nccs.spring.practice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

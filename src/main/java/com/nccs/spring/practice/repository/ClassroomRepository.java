package com.nccs.spring.practice.repository;

import com.nccs.spring.practice.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{
}

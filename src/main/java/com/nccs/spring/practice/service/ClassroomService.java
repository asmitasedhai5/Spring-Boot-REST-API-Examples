package com.nccs.spring.practice.service;

import com.nccs.spring.practice.domain.Classroom;
import com.nccs.spring.practice.domain.Student;
import com.nccs.spring.practice.repository.ClassroomRepository;
import com.nccs.spring.practice.repository.StudentRepository;
import com.nccs.spring.practice.service.dto.ClassroomDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private ClassroomRepository classroomRepository;
    private StudentRepository studentRepository;

    public ClassroomService(ClassroomRepository classroomRepository, StudentRepository studentRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
    }

    public Classroom insertClassroom(ClassroomDTO classroomDTO){
       Student student= new Student();
       student.setFirstname(classroomDTO.getStudent().getFirstname());
       student.setLastname(classroomDTO.getStudent().getLastname());
       student.setGrade(classroomDTO.getStudent().getGrade());

       Classroom classroom = new Classroom();
       classroom.setSection(classroomDTO.getSection());
       classroom.setStudent(classroomDTO.getStudent());

        return classroomRepository.save(classroom);
    }

    public Classroom updateClassroom(ClassroomDTO classroomDTO){
        Classroom classroom = classroomRepository.findOne(classroomDTO.getId());

        Student student = new Student();
        student.setFirstname(classroomDTO.getStudent().getFirstname());
        student.setLastname(classroomDTO.getStudent().getLastname());
        student.setGrade(classroomDTO.getStudent().getGrade());

        classroom.setSection(classroomDTO.getSection());
        classroom.setStudent(classroomDTO.getStudent());

        return classroomRepository.save(classroom);


    }

    public void deleteClassroom(Long id){
         classroomRepository.delete(id);
    }

    public List<Classroom> getAllClassroom(){
        return classroomRepository.findAll();
    }
}

package com.nccs.spring.practice.rest;


import com.nccs.spring.practice.domain.Classroom;
import com.nccs.spring.practice.service.ClassroomService;
import com.nccs.spring.practice.service.dto.ClassroomDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassroomController {
    public static final Logger logger = LoggerFactory.getLogger(ClassroomController.class);


    private ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @RequestMapping(value="/classroom", method= RequestMethod.POST)
    public ResponseEntity<?> insertClassroom(@RequestBody ClassroomDTO classroomDTO){
        Classroom classroom = classroomService.insertClassroom(classroomDTO);
        System.out.println("classroom:"+classroomDTO.toString());
        return new ResponseEntity<Classroom>(classroom, HttpStatus.CREATED);
    }

    @RequestMapping(value="/classroom", method= RequestMethod.PUT)
    public ResponseEntity<?> updateClassroom(@RequestBody ClassroomDTO classroomDTO){
        Classroom classroom=classroomService.updateClassroom(classroomDTO);
        return new ResponseEntity<Classroom>(classroom, HttpStatus.OK);
    }

    @RequestMapping(value="/classroom/{id}")
    public ResponseEntity<?> deleteClassroom(@PathVariable  Long id){
        classroomService.deleteClassroom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value="/classroom", method=RequestMethod.GET)
    public ResponseEntity<?> getAllClassroom(){
        List<Classroom> classrooms = classroomService.getAllClassroom();
        return new ResponseEntity<List<Classroom>>(classrooms,HttpStatus.OK);

    }
}

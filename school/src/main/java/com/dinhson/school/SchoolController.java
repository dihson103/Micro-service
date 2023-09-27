package com.dinhson.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody School school){
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping("/with-students/{student-id}")
    public ResponseEntity<FullSchoolResponse> findSchoolWithStudent(@PathVariable("student-id") Integer studentId){
        return ResponseEntity.ok(service.findSchoolWithStudents(studentId));
    }

}

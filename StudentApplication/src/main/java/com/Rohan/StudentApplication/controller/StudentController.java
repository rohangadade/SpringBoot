package com.Rohan.StudentApplication.controller;

import com.Rohan.StudentApplication.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping
    public List<Student> getAllStudent(){
        return students;
    }

    @PostMapping
    public String addStudent(@RequestBody Student student){

        students.add(student);
        return "Student add Succesfully";
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){

        for(int i = 0 ; i < students.size() ; i++){
            if(students.get(i).getId().equals(id)){
                return students.get(i);
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id,@RequestBody Student updatedStudent){

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, updatedStudent);
                return "Student Updated Successfully";
            }
        }

        return "Student Not Found";
    }
}





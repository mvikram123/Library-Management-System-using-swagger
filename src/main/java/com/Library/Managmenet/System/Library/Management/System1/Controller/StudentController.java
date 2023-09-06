package com.Library.Managmenet.System.Library.Management.System1.Controller;

import com.Library.Managmenet.System.Library.Management.System1.DTO.StudentRequestDto;
import com.Library.Managmenet.System.Library.Management.System1.DTO.StudentResponseDto;
import com.Library.Managmenet.System.Library.Management.System1.Entity.Student;
import com.Library.Managmenet.System.Library.Management.System1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

         studentService.addStudent(studentRequestDto);
         return "student has been added successfully";
    }

    @GetMapping("/find_By_email")
    public String findStudentByEmail(@RequestParam("email") String email){
       return studentService.findByEmail(email);
    }
}

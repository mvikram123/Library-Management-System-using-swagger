package com.Library.Managmenet.System.Library.Management.System1.Service;

import com.Library.Managmenet.System.Library.Management.System1.DTO.StudentRequestDto;
import com.Library.Managmenet.System.Library.Management.System1.DTO.StudentResponseDto;
import com.Library.Managmenet.System.Library.Management.System1.Entity.LibraryCard;
import com.Library.Managmenet.System.Library.Management.System1.Entity.Student;
import com.Library.Managmenet.System.Library.Management.System1.Enum.Status;
import com.Library.Managmenet.System.Library.Management.System1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(StudentRequestDto studentRequestDto){

        Student student=new Student();

        student.setName(studentRequestDto.getName());
        student.setMob(studentRequestDto.getMob());
        student.setEmail(studentRequestDto.getEmail());
        student.setDepartment(studentRequestDto.getDepartment());


//  create a card object
        LibraryCard card=new LibraryCard();

        card.setStatus(Status.ACTIVATED);
      //  card.setValidTill("04/9/2023");
        card.setStudent(student);


//   set the card attribute in student
        student.setCard(card);

        studentRepository.save(student);

    }

    public String findByEmail(String email){
        Student student= studentRepository.findByEmail(email);
        return student.getName();
    }
}

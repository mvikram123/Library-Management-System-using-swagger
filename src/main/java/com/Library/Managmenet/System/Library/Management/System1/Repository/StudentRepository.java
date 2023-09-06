package com.Library.Managmenet.System.Library.Management.System1.Repository;

import com.Library.Managmenet.System.Library.Management.System1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmail(String email); //custome search based on attribute;
}

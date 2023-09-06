package com.Library.Managmenet.System.Library.Management.System1.Entity;

import com.Library.Managmenet.System.Library.Management.System1.Enum.Department;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String mob;
    String email;
    @Enumerated(EnumType.STRING)
    Department department;

@OneToOne(mappedBy = "student" , cascade=CascadeType.ALL)
    LibraryCard card;

}

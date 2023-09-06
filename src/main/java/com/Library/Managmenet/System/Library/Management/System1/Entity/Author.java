package com.Library.Managmenet.System.Library.Management.System1.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity


public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    String author_name;
    String email;
    String mob;


    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
   // @JoinColumn
    List<Book> books=new ArrayList<>();






}

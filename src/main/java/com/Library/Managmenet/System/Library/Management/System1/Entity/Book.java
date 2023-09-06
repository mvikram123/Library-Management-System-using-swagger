package com.Library.Managmenet.System.Library.Management.System1.Entity;


import com.Library.Managmenet.System.Library.Management.System1.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    String book_name;
    int price;

    @Enumerated(EnumType.STRING)
    Genre genre;


    boolean isIssued;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transaction=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;

}

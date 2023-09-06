package com.Library.Managmenet.System.Library.Management.System1.Entity;

import com.Library.Managmenet.System.Library.Management.System1.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int card_No;


    @Enumerated(EnumType.STRING)

    Status status;


    @CreationTimestamp
    Date creationDate;

    @UpdateTimestamp
    Date updationDate;


    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card" , cascade = CascadeType.ALL)

    List<Transaction> transactionList=new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> issuedBook=new ArrayList<>();

}

package com.Library.Managmenet.System.Library.Management.System1.Entity;

import com.Library.Managmenet.System.Library.Management.System1.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String transactionNo;
    private boolean isIssued;

    @CreatedDate
    Date transactionDate;

    String message;

  //  @UpdateTimestamp
 //   Date updationTime;
    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;


    @ManyToOne
    @JoinColumn
    LibraryCard card;

    @ManyToOne
    @JoinColumn
    Book book;
}

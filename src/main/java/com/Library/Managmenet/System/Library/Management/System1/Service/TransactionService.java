package com.Library.Managmenet.System.Library.Management.System1.Service;

import com.Library.Managmenet.System.Library.Management.System1.DTO.IssueBookRequestDto;
import com.Library.Managmenet.System.Library.Management.System1.DTO.IssueBookResponseDto;
import com.Library.Managmenet.System.Library.Management.System1.Entity.Book;
import com.Library.Managmenet.System.Library.Management.System1.Entity.LibraryCard;
import com.Library.Managmenet.System.Library.Management.System1.Entity.Transaction;
import com.Library.Managmenet.System.Library.Management.System1.Enum.Status;
import com.Library.Managmenet.System.Library.Management.System1.Enum.TransactionStatus;
import com.Library.Managmenet.System.Library.Management.System1.Repository.BookRepository;
import com.Library.Managmenet.System.Library.Management.System1.Repository.CardRepository;
import com.Library.Managmenet.System.Library.Management.System1.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto)throws Exception{
    // create transaction object
      Transaction transaction=new Transaction();
      transaction.setTransactionNo((String.valueOf(UUID.randomUUID())));
      transaction.setIssued(true);



        LibraryCard card;
        try {
            card=cardRepository.findById(issueBookRequestDto.getBookId()).get();


        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card");
        }

  Book book;
        try{
            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }


        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("Invalid bookId");
            transactionRepository.save(transaction);
            throw  new Exception("Invalid bookId ");
        }
            transaction.setBook(book);
            transaction.setCard(card);

        if(card.getStatus()!= Status.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("your card is not activated");
        }
        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("Sorry ! Book is already issued");
            transactionRepository.save(transaction);
            throw new Exception("Sorry ! Book is already Issued");

        }
        // I can issue the book

        book.setIssued(true);
        transaction.setMessage("transaction successful");
        book.setCard(card);
        book.getTransaction().add(transaction);
        card.getTransactionList().add(transaction);
        card.getIssuedBook().add(book);

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        cardRepository.save(card);

        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
        issueBookResponseDto.setTransactionId(transaction.getTransactionNo());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setBook_name(book.getBook_name());

        return issueBookResponseDto;


    }
}

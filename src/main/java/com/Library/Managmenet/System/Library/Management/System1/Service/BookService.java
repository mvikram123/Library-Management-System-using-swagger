package com.Library.Managmenet.System.Library.Management.System1.Service;

import com.Library.Managmenet.System.Library.Management.System1.DTO.BookRequestDto;
import com.Library.Managmenet.System.Library.Management.System1.DTO.BookResponseDto;
import com.Library.Managmenet.System.Library.Management.System1.Entity.Author;
import com.Library.Managmenet.System.Library.Management.System1.Entity.Book;
import com.Library.Managmenet.System.Library.Management.System1.Repository.AuthorRepository;
import com.Library.Managmenet.System.Library.Management.System1.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    //BookRepository bookRepository;
    AuthorRepository authorRepository;
    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception{




          Author  author=authorRepository.findById(bookRequestDto.getAuthorId()).get();

        Book book=new Book();
        book.setBook_name(bookRequestDto.getBook_name());
        book.setPrice(bookRequestDto.getPrice());
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setAuthor(author);
        author.getBooks().add(book);
        authorRepository.save(author);



        BookResponseDto bookResponseDto=new BookResponseDto();
        bookResponseDto.setBook_name(book.getBook_name());
        bookResponseDto.setPrice(book.getPrice());
        return bookResponseDto;





    }
}

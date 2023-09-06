package com.Library.Managmenet.System.Library.Management.System1.Controller;

import com.Library.Managmenet.System.Library.Management.System1.DTO.BookRequestDto;
import com.Library.Managmenet.System.Library.Management.System1.DTO.BookResponseDto;
import com.Library.Managmenet.System.Library.Management.System1.Entity.Book;
import com.Library.Managmenet.System.Library.Management.System1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto)throws Exception{


         return bookService.addBook(bookRequestDto);


      //  return "book is added successfully";

    }
}

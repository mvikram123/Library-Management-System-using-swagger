package com.Library.Managmenet.System.Library.Management.System1.Controller;

import com.Library.Managmenet.System.Library.Management.System1.Entity.Author;
import com.Library.Managmenet.System.Library.Management.System1.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")

    public String addAuthor(@RequestBody Author author)
    {
        authorService.addAuthor(author);
        return  "author added successfully";
    }

    @GetMapping("/get_author")

    public List<Author> getAuthor()
    {
       return authorService.getAuthor();
    }
}

package com.Library.Managmenet.System.Library.Management.System1.Service;

import com.Library.Managmenet.System.Library.Management.System1.Entity.Author;
import com.Library.Managmenet.System.Library.Management.System1.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public void addAuthor(Author author){
        authorRepository.save(author);

    }

    public List<Author> getAuthor()
    {
     return  authorRepository.findAll();
    }
}

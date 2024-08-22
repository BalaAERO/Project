package com.example.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Book;
import com.example.project.Repository.BookRepository;


@Service
public class BookService {

    @Autowired
    private BookRepository repository;
    public List<Book> getAllBooks()
    {
        return repository.findAll();
    }

    public void saveBook(Book b)
    {
        this.repository.save(b);
    }
    public Book getBookId(Integer id)
    {
        Optional<Book> opt=repository.findById(id);
        Book b=null;
        if(opt.isPresent())
        {
            b=opt.get();
        }
        else
        {
            throw new RuntimeException("Book records not found for id"+id);
        }

        return b;
    }

    public void deleteBookByid(Integer id)
    {
        this.repository.deleteById(id);
    }

   
    
}

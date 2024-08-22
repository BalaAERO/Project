package com.example.project.Controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project.Entity.Book;
import com.example.project.Service.BookService;

public class BookContoller {

    @Autowired
    private BookService bs;

    @GetMapping("/")
    public String viewHomepage(Model m)
    {
        m.addAttribute("listBooks", bs.getAllBooks());
        return "index.html";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model m)
    {
        Book b=new Book();
        m.addAttribute("book", b);
        return "newbook.html";

    }
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book)
    {
        bs.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/ShowFormForUpdate/{id}")
    public String ShowFormForUpdate(@PathVariable(value ="id") Integer id,Model m)
    {
        Book b=bs.getBookId(id);
        m.addAttribute("book", b);
        return "updateBook.html";
    }

    public String deleteBook(@PathVariable(value = "id")Integer id)
    {
        this.bs.deleteBookByid(id);
        return "redirect:/";
    }
    
}

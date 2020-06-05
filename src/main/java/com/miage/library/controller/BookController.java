package com.miage.library.controller;


import com.miage.library.domain.Author;
import com.miage.library.domain.Book;
import com.miage.library.domain.Category;
import com.miage.library.domain.User;
import com.miage.library.service.AuthorService;
import com.miage.library.service.BookItemService;
import com.miage.library.service.BookService;
import com.miage.library.service.CategoryService;
import com.miage.library.service.impl.AuthorServiceImpl;
import com.miage.library.service.impl.BookItemServiceImpl;
import com.miage.library.service.impl.BookServiceImpl;
import com.miage.library.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @Autowired
    BookItemServiceImpl bookItemServiceImpl;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String book(Model model, @RequestParam("id") Long id){

        Book book = bookServiceImpl.findOne(id);
        model.addAttribute("book", book);
        return "book/book";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBook(Model model){
        List<Book> books = bookServiceImpl.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model){
        Book book = new Book();

        List<Author> authors = authorServiceImpl.findAll();
        List<Category> categories = categoryServiceImpl.findAll();

        model.addAttribute("authors", authors);
        model.addAttribute("categories", categories);
        model.addAttribute("book", book);

        return "book/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookPost(@RequestParam("cover") MultipartFile file, @RequestParam("iSBN") String iSBN,
                              @RequestParam("title") String title, @RequestParam("subject") String subject,
                              @RequestParam("publisher") String publisher, @RequestParam("language") String language,
                              @RequestParam("numberOfPages") Integer numberOfPages,
                              @RequestParam("authors") Long authors, @RequestParam("category") Long categories,
                              RedirectAttributes attributes) throws IOException {

        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/book/add";
        }

        Book b = bookServiceImpl.add(file,iSBN,title,subject,publisher,language,numberOfPages,authors,categories);
        System.out.println(b.getId());

        return "book/add";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model, @RequestParam("id") Long id){

        bookServiceImpl.delete(id);
        return "redirect:/book/list";
    }



}

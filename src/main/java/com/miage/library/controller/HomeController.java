package com.miage.library.controller;

import com.miage.library.dao.BookDao;
import com.miage.library.domain.Book;
import com.miage.library.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {


    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("book", books);
        for (Book b: books) {
            b.toString();
        }
        return "home";
    }

}

package com.miage.library.controller;


import com.miage.library.domain.*;
import com.miage.library.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.zip.DataFormatException;

@Controller
@RequestMapping("/book-item")
public class BookItemController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @Autowired
    BookItemServiceImpl bookItemServiceImpl;

    @Autowired
    RackServiceImpl rackServiceImpl;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String bookItem(Model model, @RequestParam("id") Long id){

        Book book = bookServiceImpl.findOne(id);
        model.addAttribute("book", book);
        return "book-item";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBook(Model model){
        List<BookItem> bookItems = bookItemServiceImpl.findAll();
        model.addAttribute("bookItems", bookItems);
        return "book-item/list";
    }


    // ADD
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBookItem(Model model){
        List<Book> books = bookServiceImpl.findAll();
        List<Rack> racks = rackServiceImpl.findAll();
        BookItem bookItem = new BookItem();

        model.addAttribute("bookItem", bookItem);
        model.addAttribute("books", books);
        model.addAttribute("racks", racks);

        return "book-item/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookItemPost(@RequestParam("book") Long book, @RequestParam("rack") Long rack,
                                  @RequestParam("isReferenceOnly") String isReferenceOnly, @RequestParam("borrowed") String borrowed,
                                  @RequestParam("dueDate") String dueDate, @RequestParam("format") String format,
                                  @RequestParam("status") String status,
                                  @RequestParam("dateOfPurchase") String dateOfPurchase, @RequestParam("publicationDate") String publicationDate,
                                  RedirectAttributes attributes) throws DataFormatException, ParseException {

        System.out.println(" "+status+" \n"+book+"\n " + rack+"\n " +  isReferenceOnly+"\n " +  borrowed+"\n " +  dueDate+"\n " +  format+"\n " +  dateOfPurchase+"\n " +  publicationDate) ;

        bookItemServiceImpl.add(book, rack,isReferenceOnly, borrowed, dueDate,format,status,dateOfPurchase,publicationDate);
        return "book-item/list";
    }



    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBookItemPost(@ModelAttribute("bookItem") BookItem newBookItem, Model model)   {

        System.out.println(newBookItem.toString());

        return "book-item/add";
    }



    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model, @RequestParam("id") Long id){

        bookServiceImpl.delete(id);
        return "redirect:/book-item/list";
    }



}

package com.fanzc.controller;

import com.fanzc.pojo.Books;
import com.fanzc.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {
    @Autowired
    @Qualifier("booksServiceImpl")
    private BooksService booksService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = booksService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>" + books);
        booksService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id, Model model){
        Books books = booksService.queryBookById(id);
        model.addAttribute("qBook", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>" + books);
        booksService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("deleteBook")
    public String deleteBook(int id){
        booksService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("queryBook")
    public String queryBook(String queryBookName, Model model){
        Books books = booksService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        if(books == null) {
            list = booksService.queryAllBook();
            model.addAttribute("err", "未找到书籍");
        } else {
            list.add(books);
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}

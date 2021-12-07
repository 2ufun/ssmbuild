package com.fanzc.test;

import com.fanzc.pojo.Books;
import com.fanzc.service.BooksService;
import com.fanzc.service.BooksServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksServiceImpl = context.getBean("booksServiceImpl", BooksService.class);
        for (Books books : booksServiceImpl.queryAllBook()) {
            System.out.println(books);
        }
    }
}

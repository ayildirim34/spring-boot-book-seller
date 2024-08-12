package com.yil.spring_boot_book_seller.controller;

import com.yil.spring_boot_book_seller.model.Book;
import com.yil.spring_boot_book_seller.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public ResponseEntity<?> bookSave(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("{bookId}") //api/book/{bookId}
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId)
    {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }
}

package org.example.controller;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }

    @GetMapping("/status")
    public List<Book> getBooksByStatus(@RequestParam String status){
        return bookRepository.findAvailableOnes(status);
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book){
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {

        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book){
        book.setId(id);
        return  bookRepository.saveAndFlush(book);
    }

    @PatchMapping("/update/id")
    public Book updateBookStatus(@PathVariable Long id,
                                 @RequestParam String status,
                                 @RequestParam Long userId){
        Book book = bookRepository.findById(id).get();
        book.setStatus(status);
        book.setUserId(userId);
        return bookRepository.saveAndFlush(book);

    }

}

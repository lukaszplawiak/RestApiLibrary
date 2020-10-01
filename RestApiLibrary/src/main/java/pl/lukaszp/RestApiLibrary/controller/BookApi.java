package pl.lukaszp.RestApiLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lukaszp.RestApiLibrary.model.Book;
import pl.lukaszp.RestApiLibrary.service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookApi {

    private BookService books;

    @Autowired
    public BookApi(BookService books) {
        this.books = books;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll(){
        return books.findAll();
    }

    @GetMapping
    public Optional<Book> getById(@RequestParam Long index){
        return books.findById(index);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return books.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return books.save(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long index){
        books.deleteById(index);
    }

}

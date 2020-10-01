package pl.lukaszp.RestApiLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.lukaszp.RestApiLibrary.model.Book;
import pl.lukaszp.RestApiLibrary.repository.BookRepo;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookService {

    private BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Iterable<Book> findAll(){
        return bookRepo.findAll();
    }
    public Optional<Book> findById(Long id){
        return bookRepo.findById(id);
    }
    public Book save(Book book){
        return bookRepo.save(book);
    }
    public Book update(Book book){
        return bookRepo.save(book);
    }

    public void deleteById(Long id){
        bookRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new Book(1L, "Shantaram", "Jan Kowalski", LocalDate.of(2010,10,15)));
        save(new Book(2L, "Bez Dogmatu", "Henryk Sienkiewicz", LocalDate.of(1890,4,25)));
        save(new Book(3L, "Java", "Jan Herbert", LocalDate.of(2016,5,8)));
        save(new Book(4L, "Alice in Wonderland", "Henry Ford", LocalDate.of(1876,11,13)));
        save(new Book(5L, "FollOut", "Noname Somoone", LocalDate.of(1999,9,9)));
    }


}

package pl.lukaszp.RestApiLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszp.RestApiLibrary.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}

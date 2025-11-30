package book.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    BookEntity findByNameAndPages(String name, Integer pages);
    
}
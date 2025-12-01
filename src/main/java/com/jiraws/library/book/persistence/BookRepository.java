package com.jiraws.library.book.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiraws.library.book.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    BookEntity findByNameAndPages(String name, Integer pages);
    
}
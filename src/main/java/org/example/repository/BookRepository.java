package org.example.repository;

import org.example.entity.Admin;
import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b Where b.status=?1", nativeQuery = true)
    List<Book> findAvailableOnes(String status);


    @Query(value = "SELECT * FROM Book b Where b.author=?1", nativeQuery = true)
    List<Book> findByAuthor(String author);

    @Query(value = "SELECT * FROM Book b Where b.title=?1", nativeQuery = true)
    Book findByTitle(String title);

}

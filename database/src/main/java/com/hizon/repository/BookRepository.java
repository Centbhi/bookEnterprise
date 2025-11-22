package com.hizon.repository;
import com.hizon.entity.BookData;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<BookData,Integer> {
    List<BookData> findByGenreContaining(String genre);
}

package com.hizon.repository;
import com.hizon.entity.BookData;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<BookData,Integer> {
    List<BookData> findByGenre(String genre);
}
